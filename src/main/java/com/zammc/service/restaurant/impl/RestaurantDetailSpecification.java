package com.zammc.service.restaurant.impl;

import com.github.wenhao.jpa.Specifications;
import com.zammc.domain.order.OrderInfoEntity;
import com.zammc.domain.restaurant.RestaurantPropertyEntity;
import org.springframework.data.jpa.domain.Specification;

/**
 * @Author : fly
 * @Description :
 * @Date 2018/7/1
 */
public class RestaurantDetailSpecification {

    public static Specification<RestaurantPropertyEntity> where(RestaurantPropertyEntity propertyEntity) {
        return Specifications.<RestaurantPropertyEntity>and()
                .eq("dataStatus", "1")
                .build();

    }
}
