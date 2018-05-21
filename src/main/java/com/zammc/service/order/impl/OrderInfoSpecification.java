package com.zammc.service.order.impl;

import com.github.wenhao.jpa.Specifications;
import com.zammc.domain.order.OrderInfoEntity;
import org.springframework.data.jpa.domain.Specification;

/**
 * @Author : fly
 * @Description :
 * @Date 2018/5/22
 */
public class OrderInfoSpecification {

    public static Specification<OrderInfoEntity> where(OrderInfoEntity request) {
        if(request.getOrderId() != 0) { //全部
                return Specifications.<OrderInfoEntity>and()
                        .eq("dataStatus", "0")
                        .eq("orderId", request.getOrderId())
                        .build();

        } else if (request.getOrderId() == 0) {
            return Specifications.<OrderInfoEntity>and()
                    .eq("dataStatus", "0")
                    .build();
        } else {
            return null;
        }
    }
}
