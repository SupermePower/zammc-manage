package com.zammc.repository;

import com.zammc.domain.activity.ActivityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @description 活动数据仓库
 * @author: fly
 * @Date: 2018/7/22 下午2:51
 */
@Repository
public interface ActivityRepository extends JpaRepository<ActivityEntity, Long>, JpaSpecificationExecutor<ActivityEntity> {
}
