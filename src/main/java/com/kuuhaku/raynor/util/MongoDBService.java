package com.kuuhaku.raynor.util;

import com.kuuhaku.raynor.annotation.ServiceBean;
import com.kuuhaku.raynor.entity.BaseEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description TODO
 * @Author Kuuhaku
 * @Date 2019/12/13 13:09
 **/
@ServiceBean
@Service
public class MongoDBService {
    private final static Logger logger = LogManager.getLogger(MongoDBService.class);
    @Autowired
    private MongoTemplate mongoTemplate;

    private Date lastFlushTime = new Date();

    //等待插入的数据集
    private static Map<String, List<? extends BaseEntity>> waitInsertMap = new ConcurrentHashMap<>();


    public void batchInsert(String colName, List dataList){
        if(waitInsertMap.containsKey(colName)){
            waitInsertMap.get(colName).addAll(dataList);
        }else{
            waitInsertMap.put(colName,dataList);
        }
    }

    public synchronized int flush(){
        Set<String> keys = waitInsertMap.keySet();
        List data;
        int count = 0;
        for(String key:keys){
            data = waitInsertMap.remove(key);
            if(null == data || data.size() == 0){
                continue;
            }
            count += data.size();
            mongoTemplate.insert(data,key);
        }
        lastFlushTime = new Date();
        return count;
    }

    public Date getLastFlushTime(){
        return lastFlushTime;
    }
}

