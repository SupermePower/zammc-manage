package com.zammc.repository;

import com.zammc.domain.goods.GoodsPropertyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author : fly
 * @Description :
 * @Date 2018/6/17
 */
public interface GoodsPropertyRepository extends JpaRepository<GoodsPropertyEntity, Long> {
}
