package com.zammc.controller;

import com.zammc.domain.table.DiningTableEntity;
import com.zammc.service.dining.DiningTableService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
@Slf4j
public class IndexController {

    @Autowired
    private DiningTableService diningTableService;

    /**
     * 获取首页信息
     *
     * @return
     */
    @RequestMapping(value = "/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index/index");
        try {
            //TODO 订单信息
            // 桌号信息
            List<DiningTableEntity> diningTableEntities = diningTableService.indexDiningTableData();
            modelAndView.addObject("diningTables", diningTableEntities);
            //TODO 热门商品
            //TODO 优惠菜
            //TODO 是否有新订单
        } catch (Exception e) {
            log.error("IndexController index Exception\n", e);
        }
        return modelAndView;
    }
}
