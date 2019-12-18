package com.kuuhaku.raynor.dao;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @Description 心跳
 * @Author Kuuhaku
 * @Date 2019/12/12 15:53
 **/
@Component
public interface HeartBeatDao {
    Integer countAll();
}
