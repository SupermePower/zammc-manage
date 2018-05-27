package com.zammc.service.order.impl;

import com.zammc.domain.order.OrderInfoEntity;
import com.zammc.domain.order.OrderItemEntity;
import com.zammc.page.PageBean;
import com.zammc.repository.OrderItemRepository;
import com.zammc.repository.OrderRepository;
import com.zammc.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author : fly
 * @Description : 订单业务
 * @Date 2018/5/22
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    /**
     * 获取订单分页信息
     *
     * @param orderInfo
     * @param pageBean
     */
    public void queryOrderPage(OrderInfoEntity orderInfo, PageBean pageBean) throws Exception {
        int page = pageBean.getPageNum() - 1;
        int size = pageBean.getPageSize();

        List<Sort.Order> orders = new ArrayList<>();
        orders.add(new Sort.Order(Sort.Direction.DESC, "updateTime"));
        Sort sort = new Sort(orders);
        Pageable pageable = new PageRequest(page, size, sort);
        Page<OrderInfoEntity> orderInfoPage = orderRepository.findAll(OrderInfoSpecification.where(orderInfo), pageable);
        pageBean.setPageSize(orderInfoPage.getSize());
        pageBean.setPageNum(orderInfoPage.getNumber() + 1);
        pageBean.setTotalPage(orderInfoPage.getTotalPages());
        pageBean.setTotalRecorder(orderInfoPage.getTotalElements());
        pageBean.setContent(orderInfoPage.getContent());
    }

    /**
     * 删除订单信息
     *
     * @param orderInfo
     * @throws Exception
     */
    public void deleteOrder(OrderInfoEntity orderInfo) throws Exception {
        OrderInfoEntity one = orderRepository.findOne(orderInfo.getOrderId());
        if (one != null && one.getDataStatus() == 1) {
            one.setDataStatus((byte) 0);
            orderRepository.saveAndFlush(one);
        }
    }

    /**
     * 结束订单
     *
     * @param orderInfo
     * @throws Exception
     */
    public void finishOrder(OrderInfoEntity orderInfo) throws Exception {
        OrderInfoEntity one = orderRepository.findOne(orderInfo.getOrderId());
        if (one != null && one.getDataStatus() == 1) {
            one.setPayStatus((byte) 1);
            orderRepository.saveAndFlush(one);
        }
    }

    /**
     * 取消订单
     *
     * @param orderInfo
     * @throws Exception
     */
    public void cancelOrder(OrderInfoEntity orderInfo) throws Exception {
        OrderInfoEntity one = orderRepository.findOne(orderInfo.getOrderId());
        one.setPayStatus((byte) 2);
        orderRepository.saveAndFlush(one);
    }

    /**
     * 获取订单详情
     *
     * @param orderInfo
     * @return
     * @throws Exception
     */
    public List<OrderItemEntity> queryOrderDetail(OrderInfoEntity orderInfo) throws Exception {
        return orderItemRepository.queryOrderItem(orderInfo.getOrderId());
    }

    /**
     * 获取订单总价
     *
     * @param orderInfo
     * @return
     * @throws Exception
     */
    public BigDecimal queryGoodsItemPriceSum(OrderInfoEntity orderInfo) throws Exception {
        return orderItemRepository.queryGoodsItemPriceSum(orderInfo.getOrderId());
    }
}
