package com.zammc.controller;

import com.zammc.domain.recharge.RechargeOrderEntity;
import com.zammc.page.PageBean;
import com.zammc.service.recharge.RechargeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/recharge")
@Slf4j
public class RechargeController {

    @Autowired
    private RechargeService rechargeService;

    //TODO 前端数据渲染

    /**
     * 获取充值订单信息分页展示
     *
     * @param rechargeOrderEntity
     * @param pageBean
     * @return
     */
    @RequestMapping(value = "/queryRechargeOrderPage")
    public ModelAndView queryRechargeOrderPage(RechargeOrderEntity rechargeOrderEntity, PageBean pageBean) {
        ModelAndView modelAndView = new ModelAndView("recharge-recharge-list");
        try {
            rechargeService.queryRechargeOrderPage(rechargeOrderEntity, pageBean);
            modelAndView.addObject("page", pageBean)
            .addObject("rechargeOrder", rechargeOrderEntity);
        } catch (Exception e) {
            log.error("RechargeController queryRechargeOrderPage Exception \n", e);
        }
        return modelAndView;
    }
}
