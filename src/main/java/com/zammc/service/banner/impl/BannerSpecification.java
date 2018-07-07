package com.zammc.service.banner.impl;

import com.github.wenhao.jpa.Specifications;
import com.zammc.domain.banner.BannerEntity;
import org.springframework.data.jpa.domain.Specification;

/**
 * @Author : fly
 * @Description :
 * @Date 2018/5/24
 */
public class BannerSpecification {

    public static Specification<BannerEntity> where(BannerEntity request) {
        if(null != request.getBannerName()) { //全部
            return Specifications.<BannerEntity>and()
                    .eq("dataStatus", "0")
                    .eq("bannerName", request.getBannerName())
                    .build();

        } else if (null == request.getBannerName()) {
            return Specifications.<BannerEntity>and()
                    .eq("dataStatus", "0")
                    .build();
        } else {
            return null;
        }
    }
}
