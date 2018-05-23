package com.zammc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class IndexController {

    /**
     * 获取首页信息
     *
     * @return
     */
    @RequestMapping(value = "/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index/index");
        //TODO 订单信息
        //TODO 桌号信息
        //TODO 热门商品
        //TODO 优惠菜
        //TODO 是否有新订单
        return modelAndView;
    }
}
