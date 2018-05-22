package com.zammc.repository;

import com.zammc.domain.goods.GoodsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @Author : fly
 * @Description :
 * @Date 2018/5/22
 */
@Repository
public interface GoodsRepository extends JpaRepository<GoodsEntity, Long>, JpaSpecificationExecutor<GoodsEntity> {
}
