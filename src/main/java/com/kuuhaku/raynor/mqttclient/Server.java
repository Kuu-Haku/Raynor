package com.kuuhaku.raynor.mqttclient;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.UnsupportedEncodingException;

/**
 * @Description TODO
 * @Author Kuuhaku
 * @Date 2019/12/17 11:41
 **/
@Component
public class Server {
    private final static Logger logger = LoggerFactory.getLogger(Server.class);

    //mqtt服务器地址
    @Value("${mqtt.host}")
    private String HOST;
    //服务器的clientID
    @Value("${mqtt.server.id}")
    private String SERVER_ID;

    private String topic = "test";

    private MqttClient client;


    @PostConstruct
    private void connect() throws MqttException, UnsupportedEncodingException {
        client = new MqttClient(HOST, SERVER_ID, new MemoryPersistence());
        MqttConnectOptions options = new MqttConnectOptions();
        options.setCleanSession(false);
        options.setConnectionTimeout(10);
        // 设置会话心跳时间
        options.setKeepAliveInterval(20);
        try {
            client.setCallback(new MqttCallBack());
            client.connect(options);
            client.subscribe(SubscribeUsage.getTopicNameArray());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
