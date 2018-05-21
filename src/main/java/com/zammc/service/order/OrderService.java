package com.zammc.service.order;

import com.zammc.domain.order.OrderInfoEntity;
import com.zammc.page.PageBean;

import java.util.List;

/**
 * @Author : fly
 * @Description :
 * @Date 2018/5/22
 */
public interface OrderService {

    /**
     * 获取订单分页信息
     *
     * @param orderInfo
     * @param pageBean
     */
    List<OrderInfoEntity> queryOrderPage(OrderInfoEntity orderInfo, PageBean pageBean) throws Exception;
}
