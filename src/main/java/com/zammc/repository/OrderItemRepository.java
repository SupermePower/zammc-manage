package com.zammc.repository;

import com.zammc.domain.order.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author : fly
 * @Description :
 * @Date 2018/5/27
 */
@Repository
public interface OrderItemRepository extends JpaRepository<OrderItemEntity, Long>, JpaSpecificationExecutor<OrderItemEntity> {

    /**
     * 获取订单详情
     *
     * @param orderId
     * @return
     * @throws Exception
     */
    @Query(value = "select orderItem from OrderItemEntity orderItem where orderItem.orderId = :orderId and orderItem.dataStatus = '0'")
    List<OrderItemEntity> queryOrderItem(@Param("orderId") Long orderId) throws Exception;

    /**
     * 获取订单总价
     *
     * @param orderId
     * @return
     * @throws Exception
     */
    @Query(value = "select sum(subtotal) from order_item where order_id = :orderId", nativeQuery = true)
    BigDecimal queryGoodsItemPriceSum(@Param("orderId") Long orderId) throws Exception;
}
