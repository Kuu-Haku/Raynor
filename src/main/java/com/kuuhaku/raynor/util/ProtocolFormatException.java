package com.kuuhaku.raynor.util;

/**
 * @Description TODO
 * @Author Kuuhaku
 * @Date 2019/12/19 13:41
 **/
public class ProtocolFormatException extends Exception{
    private String desc;
    public ProtocolFormatException(String desc){
        super(desc);
        this.desc = desc;
    }
}
