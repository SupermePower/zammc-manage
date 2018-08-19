package com.zammc.repository;

import com.zammc.domain.coupon.CouponEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @description
 * @author: liying.fu
 * @Date: 2018/8/19 下午3:14
 */
@Repository
public interface CouponRepository extends JpaRepository<CouponEntity, Long>, JpaSpecificationExecutor<CouponEntity> {
}
