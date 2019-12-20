package com.kuuhaku.raynor.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.kuuhaku.raynor.dao.HistoryDao;
import com.kuuhaku.raynor.entity.History;
import com.kuuhaku.raynor.service.HistoryService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description 焊接历史service
 * @Author KuuHaKu
 * @DATE 2019/12/20 15:24
**/
@Service("historyService")
public class HistoryServiceImpl implements HistoryService {
    private final static Logger logger = LogManager.getLogger(HistoryServiceImpl.class);

    @Autowired
    private HistoryDao historyDao;

    protected static Date ERROR_TIME_LINE = null;

    static {
        try {
            ERROR_TIME_LINE = new SimpleDateFormat("yyyy-MM-dd").parse("2018-12-30");
        } catch (ParseException e) {
            logger.error("初始化错误时间标记点失败:",e);
        }
    }

    /**
     * @Description 保存焊接历史
     * @Author Kuuhaku
     * @DATE 2019/12/20 15:21
    **/
    @Transactional
    public void insertHistory(List<History> historyList){
        Date now = new Date();
        historyList.stream().forEach(history -> {
            history.setId(UUID.randomUUID().toString().replaceAll( "-","" ));
            history.setCreateTime(now);
            if(ERROR_TIME_LINE.getTime()<history.getStartTime().getTime()&&history.getStartTime().getTime()<now.getTime()+600000){
                historyDao.insertHistory(history);
            }
        });
    }



};
