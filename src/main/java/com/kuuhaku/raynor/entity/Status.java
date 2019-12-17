package com.kuuhaku.raynor.entity;

import com.kuuhaku.raynor.annotation.MessageUsage;
import org.springframework.stereotype.Component;

@Component
@MessageUsage(usage="Status")
public class Status{
    private String key = "";
    private String name = "";
    private String value = "";
    public String getKey(){
        return key;
    }
    public void setKey( String _key ){
        key = _key;
    }
    public String getName(){
        return name;
    }
    public void setName( String _name ) {
    }
    public String getValue(){
        return value;
    }
    public void setValue( String _value ){
        value = _value;
    }
}
