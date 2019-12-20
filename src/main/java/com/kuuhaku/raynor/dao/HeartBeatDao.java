package com.kuuhaku.raynor.dao;

import java.util.List;
import java.util.Map;

import com.kuuhaku.raynor.entity.HeartBeat;

public interface HeartBeatDao {

	void insert(HeartBeat heartBeat);
	
	void delete(Map _p);
	
	void update(HeartBeat heartBeat);
	
	HeartBeat get(Map _p);
	
	List<HeartBeat> getAll();

	void batchUpdate(List<HeartBeat> heartBeats);
	List<String> getDeviceSerialList();
	void batchInsert(List<HeartBeat> heartBeats);
	
}
