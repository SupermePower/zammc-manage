package com.zammc.repository;

import com.zammc.domain.goods.GoodsCateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @Author : fly
 * @Description :
 * @Date 2018/5/24
 */
@Repository
public interface GoodsCateRepository extends JpaRepository<GoodsCateEntity, Long>, JpaSpecificationExecutor<GoodsCateEntity> {
}
