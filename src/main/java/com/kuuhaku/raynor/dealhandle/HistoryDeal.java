package com.kuuhaku.raynor.dealhandle;


import com.kuuhaku.raynor.entity.History;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @Description TODO
 * @Author Kuuhaku
 * @Date 2019/12/20 9:05
 **/
@Service("HistoryDeal")
public class HistoryDeal extends BaseDeal<History> {
    private final static Logger logger = LogManager.getLogger(History.class);
    private final static String USAGE = "History";
    @Override
    public String deal(List<History> data) {
        historyService.insertHistory(data);
        return null;
    }
}
