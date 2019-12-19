package com.kuuhaku.raynor.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @Description TODO
 * @Author Kuuhaku
 * @Date 2019/12/19 11:28
 **/
public class MongoWatchThread implements Runnable{
    private final static Logger logger = LogManager.getLogger(MongoWatchThread.class);
    private final static int MAX_LOOP_TIME = 3000;
    private MongoDBService mongo;


    public void setMongo(MongoDBService mongo){
        this.mongo = mongo;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(MAX_LOOP_TIME);
                int count = mongo.flush();
                if(count > 0){
                    logger.info("插入数据量:{}",count);
                }
            } catch (Exception e) {
                logger.error("mongodb 插入监视线程异常",e);
            }
        }

    }
}
