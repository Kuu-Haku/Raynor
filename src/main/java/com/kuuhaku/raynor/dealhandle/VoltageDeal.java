package com.kuuhaku.raynor.dealhandle;

import com.kuuhaku.raynor.entity.Voltage;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description TODO
 * @Author Kuuhaku
 * @Date 2019/12/13 15:25
 **/
@Service("VoltageDeal")
public class VoltageDeal implements BaseDeal<Voltage> {
    @Override
    public String deal(List<Voltage> data) {
        for(Voltage v: data){
            System.out.println("----------------------------voltage:"+v.getGroupName());
        }
        return null;
    }
}
