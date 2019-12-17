package com.kuuhaku.raynor.dealhandle;

import com.kuuhaku.raynor.entity.Status;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description TODO
 * @Author Kuuhaku
 * @Date 2019/12/13 14:55
 **/
@Service("StatusDeal")
public class StatusDeal implements BaseDeal<Status> {
    @Override
    public String deal(List<Status> data) {
        System.out.println("++++++++status数据:"+data.size());
        return null;
    }
}
