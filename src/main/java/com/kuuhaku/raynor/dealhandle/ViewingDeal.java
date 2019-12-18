package com.kuuhaku.raynor.dealhandle;

import com.kuuhaku.raynor.entity.Viewing;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description TODO
 * @Author Kuuhaku
 * @Date 2019/12/13 14:55
 **/
@Service("ViewingDeal")
public class ViewingDeal implements BaseDeal<Viewing> {
    private final static Logger logger = LogManager.getLogger(ViewingDeal.class);
    @Override
    public String deal(List<Viewing> data) {
        System.out.println("--------viewing数据:"+data.size());
        return null;
    }
}
