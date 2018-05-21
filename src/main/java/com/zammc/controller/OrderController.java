package com.zammc.controller;

import com.zammc.domain.order.OrderInfoEntity;
import com.zammc.page.PageBean;
import com.zammc.service.order.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Author : fly
 * @Description : 订单
 * @Date 2018/5/20
 */
@Controller
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 获取订单信息
     *
     * @return
     */
    @RequestMapping(value = "/queryOrderPage")
    public ModelAndView queryOrderPage(OrderInfoEntity orderInfo, PageBean pageBean) {
        ModelAndView modelAndView = new ModelAndView("order/order-list");
        try {
            List<OrderInfoEntity> orderInfoEntities = orderService.queryOrderPage(orderInfo, pageBean);
            modelAndView.addObject("pageBean", pageBean)
                    .addObject("order", orderInfo)
                    .addObject("orderList", orderInfoEntities);
        } catch (Exception e) {
            log.error("OrderController queryOrderPage Exception \n", e);
        }
        return modelAndView;
    }
}
