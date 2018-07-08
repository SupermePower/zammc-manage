package com.zammc.service.goods.impl;

import com.github.wenhao.jpa.Specifications;
import com.zammc.domain.goods.GoodsPropertyEntity;
import org.springframework.data.jpa.domain.Specification;

/**
 * @Author : fly
 * @Description :
 * @Date 2018/5/22
 */
public class GoodsPropertySpecification {
    public static Specification<GoodsPropertyEntity> where() {
        return Specifications.<GoodsPropertyEntity>and()
                .eq("dataStatus", "0")
                .build();
    }
}
