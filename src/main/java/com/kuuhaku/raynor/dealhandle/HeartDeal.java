package com.kuuhaku.raynor.dealhandle;

import com.kuuhaku.raynor.entity.HeartBeat;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Kuuhaku
 * @Date 2019/12/10 23:55
 * @Description 心跳业务处理模块
 */
@Service("HeartDeal")
public class HeartDeal implements BaseDeal<HeartBeat> {
    private final static String USAGE = "Heart";
    @Override
    public String deal(List<HeartBeat> data) {
        for(HeartBeat i : data){
            System.out.println("_____________________heartBeat消息:"+i.toString());
        }
        return null;
    }
}
