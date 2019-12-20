package com.kuuhaku.raynor.dealhandle;

import com.kuuhaku.raynor.entity.Viewing;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Description Viewing 数据处理模块(入库)
 * @Author Kuuhaku
 * @Date 2019/12/13 14:55
 **/
@Service("ViewingDeal")
public class ViewingDeal extends BaseDeal<Viewing> {
    private final static Logger logger = LogManager.getLogger(ViewingDeal.class);
    @Override
    public String deal(List<Viewing> data) {
        //mongo.batchInsert(collectionNameBuild( new Date() ),data);
        System.out.print("viewiing modal");
        return null;
    }
    public String collectionNameBuild( Date time ){
        SimpleDateFormat ft = new SimpleDateFormat("'viewing'_yyyy_MM");
        String name = ft.format( time );
        return name;
    }

}
