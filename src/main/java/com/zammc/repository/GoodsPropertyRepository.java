package com.zammc.repository;

import com.zammc.domain.goods.GoodsPropertyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author : fly
 * @Description :
 * @Date 2018/6/17
 */
public interface GoodsPropertyRepository extends JpaRepository<GoodsPropertyEntity, Long>, JpaSpecificationExecutor<GoodsPropertyEntity> {
}
