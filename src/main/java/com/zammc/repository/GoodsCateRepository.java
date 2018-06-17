package com.zammc.repository;

import com.zammc.domain.goods.GoodsCateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author : fly
 * @Description :
 * @Date 2018/5/24
 */
@Repository
public interface GoodsCateRepository extends JpaRepository<GoodsCateEntity, Long>, JpaSpecificationExecutor<GoodsCateEntity> {

    /**
     * 获取商品分类信息
     *
     * @return
     * @throws Exception
     */
    @Query(value = "select cate from GoodsCateEntity cate where cate.dataStatus = '1' and cate.status = '1'")
    List<GoodsCateEntity> queryCateList() throws Exception;
}
