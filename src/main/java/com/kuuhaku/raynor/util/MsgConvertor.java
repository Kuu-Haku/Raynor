package com.kuuhaku.raynor.util;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.kuuhaku.raynor.mqttclient.BaseProtocol;
import com.kuuhaku.raynor.mqttclient.SystemManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author Kuuhaku
 * @Date 2019/12/12 13:24
 **/
public class MsgConvertor {
    private final static Logger logger = LogManager.getLogger(MsgConvertor.class);
    private static final String USAGEKEY = "usage";
    private static final String CONTENTKEY = "content";
    private static final String DEVICESERIALKEY = "deviceSerial";
    private static final String TIMEKEY = "time";

    public static BaseProtocol fromJson(String msg) throws ProtocolFormatException {
        Gson gson = new Gson();
        BaseProtocol result = new BaseProtocol();
        List contentList = new ArrayList();
        try{
            JsonParser jsp = new JsonParser();
            JsonElement jse = jsp.parse(msg);
            JsonObject jso = jse.getAsJsonObject();
            if(!jso.has(USAGEKEY)){
                return null;
            }
            String usage = jso.get(USAGEKEY).getAsString();
            //获取消息内容类型
            Class contentType = SystemManager.getClazz(usage.toUpperCase());
            JsonElement content = jso.get(CONTENTKEY);
            for(JsonElement single:content.getAsJsonArray()){
                contentList.add(gson.fromJson(single,contentType));
            }
            //填装其他属性
            result.setContent(contentList);
            result.setDeviceSerial(jso.get(DEVICESERIALKEY).getAsString());
            if(jso.has(TIMEKEY)){
                result.setTime(jso.get(TIMEKEY).getAsString());
            }
            result.setUsage(usage);
        }catch(Exception e){
            throw new ProtocolFormatException("内容解析失败:"+e.getMessage());
        }
        return result;
    }

}

