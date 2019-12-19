package com.kuuhaku.raynor.dealhandle;

import com.kuuhaku.raynor.entity.HeartBeat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Kuuhaku
 * @Date 2019/12/10 23:55
 * @Description 心跳业务处理模块
 */
@Service("HeartDeal")
public class HeartDeal extends BaseDeal<HeartBeat> {
    private final static Logger logger = LogManager.getLogger(HeartDeal.class);
    private final static String USAGE = "Heart";
    @Override
    public String deal(List<HeartBeat> data) {
        for(HeartBeat i : data){
            System.out.println("_____________________heartBeat消息:"+i.toString());
        }
        return null;
    }
}
