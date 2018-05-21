package com.zammc.service.order.impl;

import com.zammc.domain.order.OrderInfoEntity;
import com.zammc.page.PageBean;
import com.zammc.repository.OrderRepository;
import com.zammc.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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

    /**
     * 获取订单分页信息
     *
     * @param orderInfo
     * @param pageBean
     */
    public List<OrderInfoEntity> queryOrderPage(OrderInfoEntity orderInfo, PageBean pageBean) throws Exception {
        int page = pageBean.getPageNum();
        int size = pageBean.getPageSize();

        List<Sort.Order> orders = new ArrayList<>();
        orders.add(new Sort.Order(Sort.Direction.DESC, "updateTime"));
        Sort sort = new Sort(orders);
        Pageable pageable = new PageRequest(page, size, sort);
        Page<OrderInfoEntity> orderInfoPage = orderRepository.findAll(OrderInfoSpecification.where(orderInfo), pageable);
        pageBean.setPageNum(orderInfoPage.getNumber());
        pageBean.setPageSize(orderInfoPage.getSize());
        pageBean.setTotalPage(orderInfoPage.getTotalPages());
        pageBean.setTotalRecorder((int)orderInfoPage.getTotalElements());
        return orderInfoPage.getContent();

    }
}
