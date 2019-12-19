package com.kuuhaku.raynor.mqttclient;

import com.kuuhaku.raynor.annotation.MessageUsage;
import com.kuuhaku.raynor.annotation.ServiceBean;
import com.kuuhaku.raynor.dealhandle.BaseDeal;
import com.kuuhaku.raynor.util.MongoDBService;
import com.kuuhaku.raynor.util.MongoWatchThread;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author Kuuhaku
 * @Date 2019/11/27 0:58
 * @Description 管理所有的消息类型,提供根据消息类别名useage(String)获取消息类class的服务
 */
@Component
public class SystemManager extends ApplicationObjectSupport {
    private final static Logger logger = LogManager.getLogger(SystemManager.class);
    private static Map<String, Class> clazzMap = new HashMap<>();
    private static Map<String, BaseDeal> dealMap = new HashMap<>();
    private static Map<Class, Object> serviceBeanMap = new HashMap<>();
    private int count = 0;

    @Autowired
    private Server server;
    @Autowired
    private MongoDBService mongo;



    @PostConstruct
    private void init() throws MqttException, UnsupportedEncodingException {
        ApplicationContext applicationContext = super.getApplicationContext();
        Map<String, Object> beanMap = applicationContext.getBeansWithAnnotation(MessageUsage.class);
        String[] usageArray = new String[beanMap.size()];
        logger.info("订阅消息类型----开始加载:");
        beanMap.forEach((name,bean)->{
            logger.info("--->"+name);
            String usage = bean.getClass().getAnnotation(MessageUsage.class).usage();
            clazzMap.put(usage.toUpperCase(), bean.getClass());
            //获取对应deal实现类
            dealMap.put(usage.toUpperCase(),(BaseDeal) applicationContext.getBean(usage+"Deal"));
            //单层匹配,批量接收某个类型的数据
            usageArray[count] = usage+"/+";
            count++;
        });
        logger.info("订阅消息类型----加载完成("+count+")");
        logger.info("ServiceBean----开始加载:");
        count = 0;
        beanMap = applicationContext.getBeansWithAnnotation(ServiceBean.class);
        beanMap.forEach((name, bean) -> {
            logger.info("--->" + name);
            Class clazz = bean.getClass();
            serviceBeanMap.put(clazz, bean);
            count++;
        });
        logger.info("ServiceBean----加载完成(" + count + ")");
        logger.info("启动mongodb数据定时入库");
        MongoWatchThread timeWatch = new MongoWatchThread();
        timeWatch.setMongo(mongo);
        Thread watcher = new Thread(timeWatch);
        watcher.start();
        server.setSubscribeUsage(usageArray);
        server.connect();
    }

    public static Class getClazz(String usage){
        return clazzMap.get(usage.toUpperCase());
    }
    public static BaseDeal getDeal(String usage){
        return dealMap.get(usage);
    }
    public static <T> T getService(Class<T> clazz) {
        return (T) serviceBeanMap.get(clazz);
    }
    public static String[] getUsageArray(){
        String[] usage = new String[clazzMap.size()];
        clazzMap.keySet().toArray(usage);
        return usage;
    }
}
