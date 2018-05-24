package com.zammc.repository;

import com.zammc.domain.banner.BannerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @Author : fly
 * @Description :
 * @Date 2018/5/24
 */
@Repository
public interface BannerRepository extends JpaRepository<BannerEntity, Long>, JpaSpecificationExecutor<BannerEntity> {

}
