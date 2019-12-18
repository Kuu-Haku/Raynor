package com.kuuhaku.raynor.mqttclient;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

/**
 * @Description TODO
 * @Author Kuuhaku
 * @Date 2019/12/17 11:41
 **/
@Component
public class Server {
    private final static Logger logger = LogManager.getLogger(Server.class);
    //mqtt服务器地址
    @Value("${mqtt.host}")
    private String HOST;
    //服务器的clientID
    @Value("${mqtt.server.id}")
    private String SERVER_ID;
    private MqttClient client;
    private String[] subscribeUsage;

    public void setSubscribeUsage(String[] subscribeUsage){
        this.subscribeUsage = subscribeUsage;
    }

    public void connect() throws MqttException, UnsupportedEncodingException {
        client = new MqttClient(HOST, SERVER_ID, new MemoryPersistence());
        MqttConnectOptions options = new MqttConnectOptions();
        options.setCleanSession(false);
        options.setConnectionTimeout(10);
        // 设置会话心跳时间
        options.setKeepAliveInterval(20);
        try {
            client.setCallback(new ServerCallBack());
            client.connect(options);
            client.subscribe(subscribeUsage);
        } catch (Exception e) {
            logger.error("连接分发",e);
        }
    }
}
