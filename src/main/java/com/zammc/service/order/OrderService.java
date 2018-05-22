package com.zammc.service.order;

import com.zammc.domain.order.OrderInfoEntity;
import com.zammc.page.PageBean;

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
    void queryOrderPage(OrderInfoEntity orderInfo, PageBean pageBean) throws Exception;

    /**
     * 删除订单信息
     *
     * @param orderInfo
     * @throws Exception
     */
    void deleteOrder(OrderInfoEntity orderInfo) throws Exception;

    /**
     * 结束订单
     *
     * @param orderInfo
     * @throws Exception
     */
    void finishOrder(OrderInfoEntity orderInfo) throws Exception;

    /**
     * 取消订单
     *
     * @param orderInfo
     * @throws Exception
     */
    void cancelOrder(OrderInfoEntity orderInfo) throws Exception;
}
