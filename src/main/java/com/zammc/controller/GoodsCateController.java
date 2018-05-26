package com.zammc.controller;

import com.zammc.domain.goods.GoodsCateEntity;
import com.zammc.page.PageBean;
import com.zammc.response.Message;
import com.zammc.response.MessageStatus;
import com.zammc.response.MessageTitle;
import com.zammc.service.goods.GoodsCateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

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

    /**
     * 新增分类信息
     *
     * @return
     */
    @RequestMapping(value = "/toAdd")
    public ModelAndView toAdd() {
        return new ModelAndView("goods/cate-add");
    }

    /**
     * 新增商品分类信息
     *
     * @param goodsCateEntity
     * @param request
     * @return
     */
    @RequestMapping(value = "/addGoodsCate")
    @ResponseBody
    public Message addGoodsCate(GoodsCateEntity goodsCateEntity, HttpServletRequest request) {
        Message message = null;
        return message;
    }

    /**
     * 启用商品分类信息
     *
     * @param goodsCateEntity
     * @return
     */
    @RequestMapping(value = "/startUsingCate")
    @ResponseBody
    public Message startUsingCate(GoodsCateEntity goodsCateEntity) {
        Message message = null;
        try {
            goodsCateService.startUsingCate(goodsCateEntity);
            message = new Message(MessageStatus.SUCCESS, MessageTitle.成功, "操作成功");
        } catch (Exception e) {
            log.error("GoodsCateController startUsingCate cateId -> {} Exception", goodsCateEntity.getCateId(), e);
            message = new Message(MessageStatus.FAIL, MessageTitle.失败, "操作失败");
        }
        return message;
    }

    /**
     * 禁用商品分类信息
     *
     * @param goodsCateEntity
     * @return
     */
    @RequestMapping(value = "/forbiddenCate")
    @ResponseBody
    public Message forbiddenCate(GoodsCateEntity goodsCateEntity) {
        Message message = null;
        try {
            goodsCateService.forbiddenCate(goodsCateEntity);
            message = new Message(MessageStatus.SUCCESS, MessageTitle.成功, "操作成功");
        } catch (Exception e) {
            log.error("GoodsCateController forbiddenCate cateId -> {} Exception", goodsCateEntity.getCateId(), e);
            message = new Message(MessageStatus.FAIL, MessageTitle.失败, "操作失败");
        }
        return message;
    }

    /**
     * 删除商品分类信息
     *
     * @param goodsCateEntity
     * @return
     */
    @RequestMapping(value = "/deleteGoodsCate")
    @ResponseBody
    public Message deleteGoodsCate(GoodsCateEntity goodsCateEntity) {
        Message message = null;
        try {
            goodsCateService.deleteGoodsCate(goodsCateEntity);
            message = new Message(MessageStatus.SUCCESS, MessageTitle.成功, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("GoodsCateController deleteGoodsCate cateId -> {} Exception", goodsCateEntity.getCateId(), e);
            message = new Message(MessageStatus.FAIL, MessageTitle.失败, "删除失败");
        }
        return message;
    }
}
