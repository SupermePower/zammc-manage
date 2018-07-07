package com.zammc.repository;

import com.zammc.domain.table.DiningTableEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author : fly
 * @Description :
 * @Date 2018/5/26
 */
@Repository
public interface DiningTableRepository extends JpaRepository<DiningTableEntity, Long>, JpaSpecificationExecutor<DiningTableEntity> {

    /**
     * 首页获取餐位信息
     *
     * @return
     * @throws Exception
     */
    @Query(value = "select * from dining_table where data_status = '1' limit 8", nativeQuery = true)
    List<DiningTableEntity> indexDiningTableData() throws Exception;
}
