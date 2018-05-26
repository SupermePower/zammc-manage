package com.zammc.service.dining.impl;

import com.github.wenhao.jpa.Specifications;
import com.zammc.domain.goods.GoodsEntity;
import com.zammc.domain.table.DiningTableEntity;
import org.springframework.data.jpa.domain.Specification;

/**
 * @Author : fly
 * @Description :
 * @Date 2018/5/26
 */
public class DiningTableSpecification {
    public static Specification<DiningTableEntity> where(DiningTableEntity request) {
        if (null != request.getTableCode()) {
            return Specifications.<DiningTableEntity>and()
                    .eq("dataStatus", "1")
                    .eq("tableCode", request.getTableCode())
                    .build();

        } else if (null == request.getTableCode()) {
            return Specifications.<DiningTableEntity>and()
                    .eq("dataStatus", "1")
                    .build();
        } else {
            return null;
        }
    }

}
