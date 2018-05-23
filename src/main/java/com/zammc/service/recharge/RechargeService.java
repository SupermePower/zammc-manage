package com.zammc.service.recharge;

import com.zammc.domain.recharge.RechargeOrderEntity;
import com.zammc.page.PageBean;

public interface RechargeService {

    /**
     *
     * @param rechargeOrderEntity
     * @param pageBean
     * @throws Exception
     */
    void queryRechargeOrderPage(RechargeOrderEntity rechargeOrderEntity, PageBean pageBean) throws Exception;
}
