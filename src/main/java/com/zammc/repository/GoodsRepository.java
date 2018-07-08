package com.zammc.repository;

import com.zammc.domain.goods.GoodsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author : fly
 * @Description :
 * @Date 2018/5/22
 */
@Repository
public interface GoodsRepository extends JpaRepository<GoodsEntity, Long>, JpaSpecificationExecutor<GoodsEntity> {

    /**
     * 取货所有不是单品商品
     *
     * @return
     * @throws Exception
     */
    @Query(value = "select goods from GoodsEntity goods where goods.dataStatus = '0' and goods.goodsType = '1'")
    List<GoodsEntity> queryAllNotSingleGoods() throws Exception;
}
