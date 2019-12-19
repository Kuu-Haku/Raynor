package com.kuuhaku.raynor.dealhandle;

import com.kuuhaku.raynor.util.MongoDBService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Description TODO
 * @Author Kuuhaku
 * @Date 2019/12/19 14:40
 **/
public class BaseDeal<T> {
    @Autowired
    protected MongoDBService mongo;

    public String deal(List<T> data){
        return null;
    }

}
