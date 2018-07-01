package com.zammc.repository;

import com.zammc.domain.restaurant.RestaurantPropertyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @Author : fly
 * @Description :
 * @Date 2018/6/18
 */
@Repository
public interface RestaurantDetailRepository extends JpaRepository<RestaurantPropertyEntity, Long>, JpaSpecificationExecutor<RestaurantPropertyEntity> {
}
