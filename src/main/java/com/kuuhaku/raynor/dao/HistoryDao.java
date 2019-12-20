package com.kuuhaku.raynor.dao;

import com.kuuhaku.raynor.entity.History;

import java.util.Map;
import java.util.List;

public interface HistoryDao{
    public int insertHistory(History _p);
    public List< History > selectHistory(Map _p);
    public int selectHistoryCount(Map _p);
}
