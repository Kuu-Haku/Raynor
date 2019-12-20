package com.kuuhaku.raynor.dealhandle;

import com.kuuhaku.raynor.entity.Voltage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Description TODO
 * @Author Kuuhaku
 * @Date 2019/12/13 15:25
 **/
@Service("VoltageDeal")
public class VoltageDeal extends BaseDeal<Voltage> {
    private final static Logger logger = LogManager.getLogger(VoltageDeal.class);
    @Override
    public String deal(List<Voltage> data) {
        String colName = null;
        //mongo.batchInsert(collectionNameBuild( new Date() ),data);
        System.out.print("voltage modal");
        return null;
    }

    public String collectionNameBuild( Date time ){
        SimpleDateFormat ft = new SimpleDateFormat("'voltage'_yyyy_MM");
        String name = ft.format( time );
        return name;
    }


}
