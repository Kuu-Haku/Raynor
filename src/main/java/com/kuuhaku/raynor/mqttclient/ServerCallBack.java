package com.kuuhaku.raynor.mqttclient;

import com.kuuhaku.raynor.dealhandle.BaseDeal;
import com.kuuhaku.raynor.service.HeartBeatService;
import com.kuuhaku.raynor.service.impl.HeartBeatServiceImpl;
import com.kuuhaku.raynor.util.MongoDBService;
import com.kuuhaku.raynor.util.MsgConvertor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description TODO
 * @Author Kuuhaku
 * @Date 2019/12/17 13:07
 **/
public class ServerCallBack implements MqttCallback {
    private final static Logger logger = LogManager.getLogger(ServerCallBack.class);

    @Autowired
    private HeartBeatService heartBeatService;
//    @Autowired
//    private MongoDBService mongoDBService;


    @Override
    public void connectionLost(Throwable throwable) {

    }

    @Override
    public void messageArrived(String s, MqttMessage msg){
        //消息分拣
        //自动分拣
//        try{
//            String content = new String(msg.getPayload());
//            BaseProtocol base = MsgConvertor.fromJson(content);
//            String usage = base.getUsage().toUpperCase();
//            BaseDeal handle = SystemManager.getDeal(usage);
//            String result = handle.deal(base.getContent());
//        }catch (Exception e){
//            logger.error("error:",e);
//        }
        try{
            System.out.println(SystemManager.getService(HeartBeatServiceImpl.class).count());
        }catch (Exception e){
            System.out.println(e);
        }




    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {

    }
}
