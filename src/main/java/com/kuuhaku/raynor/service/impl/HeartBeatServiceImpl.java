package com.kuuhaku.raynor.service.impl;

import com.kuuhaku.raynor.annotation.ServiceBean;
import com.kuuhaku.raynor.dao.HeartBeatDao;
import com.kuuhaku.raynor.service.HeartBeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description TODO
 * @Author Kuuhaku
 * @Date 2019/12/12 15:56
 **/
@ServiceBean
@Service
public class HeartBeatServiceImpl implements HeartBeatService {
    @Autowired
    private HeartBeatDao heartBeatDao;

    public int count() {
        int count = heartBeatDao.countAll();
        System.out.println("count:");
        return count;
    }
}
