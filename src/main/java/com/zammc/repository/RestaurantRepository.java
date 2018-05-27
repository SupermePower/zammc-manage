package com.zammc.repository;

import com.zammc.domain.restaurant.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @Author : fly
 * @Description :
 * @Date 2018/5/27
 */
@Repository
public interface RestaurantRepository extends JpaRepository<RestaurantEntity, Long>, JpaSpecificationExecutor<RestaurantEntity> {
}
