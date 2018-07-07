package com.zammc.service.goods.impl;

import com.github.wenhao.jpa.Specifications;
import com.zammc.domain.goods.GoodsEntity;
import org.springframework.data.jpa.domain.Specification;

/**
 * @Author : fly
 * @Description :
 * @Date 2018/5/22
 */
public class GoodsSpecification {
    public static Specification<GoodsEntity> where(GoodsEntity request) {
        if (null != request.getGoodsName()) {
            return Specifications.<GoodsEntity>and()
                    .eq("dataStatus", "0")
                    .eq("orderId", request.getGoodsName())
                    .build();

        } else if (null == request.getGoodsName()) {
            return Specifications.<GoodsEntity>and()
                    .eq("dataStatus", "0")
                    .build();
        } else {
            return null;
        }
    }
}
