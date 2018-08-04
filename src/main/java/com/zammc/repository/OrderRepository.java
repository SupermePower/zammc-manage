package com.zammc.repository;

import com.zammc.domain.order.OrderInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

/**
 * @Author : fly
 * @Description :
 * @Date 2018/5/22
 */
@Repository
public interface OrderRepository extends JpaRepository<OrderInfoEntity, Long>, JpaSpecificationExecutor<OrderInfoEntity> {

    /**
     * 获取当日订单总量
     *
     * @param currentTime 当前时间
     * @return
     * @throws Exception
     */
    @Query(value = "select count(orderInfo) from OrderInfoEntity orderInfo where orderInfo.createTime > :#{#currentTime} and orderInfo.dataStatus = '0'")
    Long queryOrderCount(@Param("currentTime") Timestamp currentTime) throws Exception;

    /**
     * 获取当日营业额信息
     *
     * @param currentTime 当前时间
     * @return
     * @throws Exception
     */
    @Query(value = "select sum (orderInfo.totalprice) from OrderInfoEntity orderInfo where orderInfo.createTime > :#{#currentTime} and orderInfo.dataStatus = '0'")
    Double queryTotalPrice(@Param("currentTime") Timestamp currentTime) throws Exception;
}
