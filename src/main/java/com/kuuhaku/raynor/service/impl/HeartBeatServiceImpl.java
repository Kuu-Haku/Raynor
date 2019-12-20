package com.kuuhaku.raynor.service.impl;


import com.kuuhaku.raynor.dao.HeartBeatDao;
import com.kuuhaku.raynor.entity.HeartBeat;
import com.kuuhaku.raynor.service.HeartBeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @Description 心跳相关业务实现
*/
@Service("heartBeatService")
public class HeartBeatServiceImpl implements HeartBeatService {
	
	@Autowired
	private HeartBeatDao heartBeatDao;

	private Map<String, HeartBeat> heartBeatCache  = new HashMap<String, HeartBeat>();


	@Override
	public void insert(List<HeartBeat> heartBeat) {
		heartBeat.stream().forEach(heart->heartBeatCache.put(heart.getDeviceSerial(),heart));
	}

	@Override
	public void batchInsert(List<HeartBeat> heartBeat) {
		heartBeatDao.batchInsert(heartBeat);
	}

	public void flushHeartBeat(){
		if(heartBeatCache.size() == 0){return;}
		List<String> deviceList = heartBeatDao.getDeviceSerialList();
		Map<String,HeartBeat> origin = heartBeatCache;
		heartBeatCache = new HashMap<>();
		List<HeartBeat> updateList = new ArrayList<>();
		deviceList.stream().forEach(deviceSerial->{
			if(origin.containsKey(deviceSerial)){
				updateList.add(origin.remove(deviceSerial));
			}
		});
		List<HeartBeat> insertList = new ArrayList<>(origin.values());
		batchInsert(insertList);
		heartBeatDao.batchUpdate(updateList);
	}

}
