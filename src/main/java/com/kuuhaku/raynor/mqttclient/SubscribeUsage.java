package com.kuuhaku.raynor.mqttclient;

/**
 * @Description TODO
 * @Author Kuuhaku
 * @Date 2019/12/17 16:16
 **/
public enum  SubscribeUsage {
    View("view"),
    Status("Status"),
    Voltage("Voltage")
    ;
    public String name;
    SubscribeUsage(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public static String[] getTopicNameArray(){
        int array_length = SubscribeUsage.values().length;
        String[] usageArray = new String[array_length];
        for(SubscribeUsage su:SubscribeUsage.values()){
            array_length--;
            usageArray[array_length] = su.getName();
        }
        return usageArray;
    }
}
