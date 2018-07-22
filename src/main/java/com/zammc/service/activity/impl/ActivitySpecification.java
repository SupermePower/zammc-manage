package com.zammc.service.activity.impl;

import com.github.wenhao.jpa.Specifications;
import com.zammc.domain.activity.ActivityEntity;
import org.springframework.data.jpa.domain.Specification;

/**
 * @Author : fly
 * @Description : 筛选条件
 * @Date 2018/5/24
 */
public class ActivitySpecification {

    public static Specification<ActivityEntity> where(ActivityEntity request) {

        return Specifications.<ActivityEntity>and()
                .eq("dataStatus", "0")
                .build();
    }
}
