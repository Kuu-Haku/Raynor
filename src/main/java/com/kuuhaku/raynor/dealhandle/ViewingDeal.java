package com.kuuhaku.raynor.dealhandle;

import com.kuuhaku.raynor.entity.Viewing;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description TODO
 * @Author Kuuhaku
 * @Date 2019/12/13 14:55
 **/
@Service("ViewingDeal")
public class ViewingDeal implements BaseDeal<Viewing> {
    @Override
    public String deal(List<Viewing> data) {
        System.out.println("--------viewing数据:"+data.size());
        return null;
    }
}
