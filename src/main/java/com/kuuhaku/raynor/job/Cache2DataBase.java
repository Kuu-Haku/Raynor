package com.kuuhaku.raynor.job;

import com.kuuhaku.raynor.service.HeartBeatService;
import com.kuuhaku.raynor.util.MongoDBService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @Description 用于各种数据定时从内存容器中迁移到数据库
 * @Author Kuuhaku
 * @Date 2019/12/20 14:41
 **/
@Configuration
@EnableScheduling
public class Cache2DataBase {
    private final static Logger logger = LogManager.getLogger(Cache2DataBase.class);

    @Autowired
    private HeartBeatService heartBeatService;

    @Autowired
    private MongoDBService mongoDBService;

    @Scheduled(fixedRate=3000)
    public void  Cache2DataBaseTask(){
        try{
            heartBeatService.flushHeartBeat();
            mongoDBService.flush();
        }catch(Exception e){
            logger.error("定时迁移任务发生异常:",e);
        }
    }
}
