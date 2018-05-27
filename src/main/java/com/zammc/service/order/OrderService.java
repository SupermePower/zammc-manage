package com.zammc.service.order;

import com.zammc.domain.order.OrderInfoEntity;
import com.zammc.domain.order.OrderItemEntity;
import com.zammc.page.PageBean;

import java.math.BigDecimal;
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

    /**
     * 获取订单详情
     *
     * @param orderInfo
     * @return
     * @throws Exception
     */
    List<OrderItemEntity> queryOrderDetail(OrderInfoEntity orderInfo) throws Exception;

    /**
     * 获取订单总价
     *
     * @param orderInfo
     * @return
     * @throws Exception
     */
    BigDecimal queryGoodsItemPriceSum(OrderInfoEntity orderInfo) throws Exception;
}
