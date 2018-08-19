package com.zammc.service.coupon;

import com.zammc.domain.coupon.CouponEntity;
import com.zammc.page.PageBean;

/**
 * @description 卡券业务
 * @author: liying.fu
 * @Date: 2018/8/19 下午3:11
 */
public interface CouponService {

    /**
     * 获取卡券分页信息
     *
     * @param pageBean
     */
    void queryCouponPage(PageBean pageBean) throws Exception;

    /**
     * 新增卡券信息
     *
     * @param couponEntity
     * @return
     * @throws Exception
     */
    void addCoupon(CouponEntity couponEntity) throws Exception;

    /**
     * 删除卡券信息
     *
     * @param couponEntity
     * @throws Exception
     */
    void deleteCoupon(CouponEntity couponEntity) throws Exception;
}
