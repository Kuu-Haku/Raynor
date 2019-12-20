package com.kuuhaku.raynor.dealhandle;

import com.kuuhaku.raynor.service.HeartBeatService;
import com.kuuhaku.raynor.service.HistoryService;
import com.kuuhaku.raynor.util.MongoDBService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
 * @Description TODO
 * @Author Kuuhaku
 * @Date 2019/12/19 14:40
 **/
public class BaseDeal<T> implements BaseInterFace<T> {
    private final static Logger logger = LogManager.getLogger(BaseDeal.class);
    @Autowired
    protected MongoDBService mongo;
    @Autowired
    protected HistoryService historyService;
    @Autowired
    protected HeartBeatService heartBeatService;




    public String deal(List<T> data) {
        return null;
    }


}

interface BaseInterFace<T>{
    public String deal(List<T> data);
}