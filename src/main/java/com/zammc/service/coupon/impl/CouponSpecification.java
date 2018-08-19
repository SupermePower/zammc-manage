package com.zammc.service.coupon.impl;

import com.github.wenhao.jpa.Specifications;
import com.zammc.domain.coupon.CouponEntity;
import org.springframework.data.jpa.domain.Specification;

/**
 * @Author : fly
 * @Description : 卡券查询条件
 * @Date 2018/5/24
 */
public class CouponSpecification {

    public static Specification where() {
        return Specifications.<CouponEntity>and()
                .eq("dataStatus", "0")
                .build();

    }
}
