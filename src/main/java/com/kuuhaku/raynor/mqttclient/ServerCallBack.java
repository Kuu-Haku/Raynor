package com.kuuhaku.raynor.mqttclient;

import com.kuuhaku.raynor.dealhandle.BaseDeal;
import com.kuuhaku.raynor.util.MsgConvertor;
import com.kuuhaku.raynor.util.ProtocolFormatException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 * @Description TODO
 * @Author Kuuhaku
 * @Date 2019/12/17 13:07
 **/
public class ServerCallBack implements MqttCallback {
    private final static Logger logger = LogManager.getLogger(ServerCallBack.class);


    @Override
    public void connectionLost(Throwable throwable) {
        //TODO:丢失链接后的重连操作
        logger.error("链接Broker失败:",throwable);
    }

    @Override
    public void messageArrived(String s, MqttMessage msg){
        //消息分拣
        //自动分拣
        String content = null;
        try{
            content = new String(msg.getPayload());
            BaseProtocol base = MsgConvertor.fromJson(content);
            String usage = base.getUsage().toUpperCase();
            BaseDeal handle = SystemManager.getDeal(usage);
            handle.deal(base.getContent());
        }catch (ProtocolFormatException e){
            logger.error("content:{}\nerror:{}",content,e.getMessage());
        }
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
        //TODO:消息推送后的操作
    }
}
