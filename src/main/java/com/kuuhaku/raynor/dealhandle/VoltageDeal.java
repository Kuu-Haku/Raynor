package com.kuuhaku.raynor.dealhandle;

import com.kuuhaku.raynor.entity.Voltage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description TODO
 * @Author Kuuhaku
 * @Date 2019/12/13 15:25
 **/
@Service("VoltageDeal")
public class VoltageDeal implements BaseDeal<Voltage> {
    private final static Logger logger = LogManager.getLogger(VoltageDeal.class);
    @Override
    public String deal(List<Voltage> data) {
        for(Voltage v: data){
            System.out.println("----------------------------voltage:"+v.getGroupName());
        }
        return null;
    }
}
