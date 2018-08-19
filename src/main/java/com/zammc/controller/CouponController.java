package com.zammc.controller;

import com.zammc.domain.coupon.CouponEntity;
import com.zammc.page.PageBean;
import com.zammc.response.Message;
import com.zammc.response.MessageStatus;
import com.zammc.response.MessageTitle;
import com.zammc.service.coupon.CouponService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @description 卡券
 * @author: liying.fu
 * @Date: 2018/8/19 下午3:06
 */
@Controller
@RequestMapping("/coupon")
@Slf4j
public class CouponController {

    @Autowired
    private CouponService couponService;

    /**
     * 获取代金券分页信息
     *
     * @param couponEntity
     * @param pageBean
     * @return
     */
    @RequestMapping(value = "/queryCouponPage")
    public ModelAndView queryCouponPage(CouponEntity couponEntity, PageBean pageBean) {
        ModelAndView modelAndView = new ModelAndView("coupon/coupon-list");
        try {
            couponService.queryCouponPage(pageBean);
            modelAndView.addObject("page", pageBean);
        } catch (Exception e) {
            log.error("CouponController queryCouponPage Exception", e);
        }
        return modelAndView;
    }

    /**
     * 跳转到新增页面
     *
     * @return
     */
    @RequestMapping(value = "/toAdd")
    public ModelAndView toAdd() {
        return new ModelAndView("coupon/coupon-add");
    }

    /**
     * 新增卡券信息
     *
     * @param couponEntity
     * @return
     */
    @RequestMapping(value = "/addCoupon")
    @ResponseBody
    public Message addCoupon(CouponEntity couponEntity) {
        Message message;
        try {
            couponService.addCoupon(couponEntity);
            message = new Message(MessageStatus.SUCCESS, MessageTitle.成功, "新增成功");
        } catch (Exception e) {
            log.error("CouponController addCoupon couponEntity -> {} Exception", couponEntity.toString(), e);
            message = new Message(MessageStatus.FAIL, MessageTitle.失败, "新增失败");
        }
        return message;
    }

    /**
     * 删除卡券信息
     *
     * @param couponEntity
     * @return
     */
    @RequestMapping(value = "/deleteCoupon")
    @ResponseBody
    public Message deleteCoupon(CouponEntity couponEntity) {
        Message message;
        try {
            couponService.deleteCoupon(couponEntity);
            message = new Message(MessageStatus.SUCCESS, MessageTitle.成功, "删除成功");
        } catch (Exception e) {
            log.error("CouponController deleteCoupon id -> {} Exception", couponEntity.getId(), e);
            message = new Message(MessageStatus.FAIL, MessageTitle.失败, "删除失败");
        }
        return message;
    }
}
