package com.kuuhaku.raynor.service;

import com.kuuhaku.raynor.entity.HeartBeat;

import java.util.List;


/**
* @Description 心跳接口
*/
public interface HeartBeatService{
	public void insert(List<HeartBeat> heartBeat);
	public void batchInsert(List<HeartBeat> heartBeat);
	public void flushHeartBeat();
}
