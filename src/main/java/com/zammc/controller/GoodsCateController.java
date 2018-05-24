package com.zammc.controller;

import com.zammc.domain.goods.GoodsCateEntity;
import com.zammc.page.PageBean;
import com.zammc.service.goods.GoodsCateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author : fly
 * @Description :
 * @Date 2018/5/24
 */
@Controller
@RequestMapping("/goodsCate")
@Slf4j
public class GoodsCateController {


    @Autowired
    private GoodsCateService goodsCateService;

    /**
     * 获取商品分类分页信息
     *
     * @param goodsCateEntity
     * @param pageBean
     * @return
     */
    @RequestMapping(value = "/queryGoodsCatePage")
    public ModelAndView queryGoodsCatePage(GoodsCateEntity goodsCateEntity, PageBean pageBean) {
        ModelAndView modelAndView = new ModelAndView("goods/cate-list");
        try {
            goodsCateService.queryGoodsCatePage(goodsCateEntity, pageBean);
            modelAndView.addObject("page", pageBean)
                    .addObject("cate", goodsCateEntity);
        } catch (Exception e) {
            log.error("GoodsCateController queryGoodsCatePage Exception \n", e);
        }
        return modelAndView;
    }
}
