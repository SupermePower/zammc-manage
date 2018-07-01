package com.zammc.service.restaurant;

import com.zammc.domain.restaurant.RestaurantPropertyEntity;
import com.zammc.page.PageBean;
import com.zammc.response.Message;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author : fly
 * @Description :
 * @Date 2018/6/18
 */
public interface RestaurantDetailService {

    /**
     * 获取店家详情
     *
     * @param restaurantPropertyEntity
     * @param pageBean
     * @throws Exception
     */
    void queryRestaurantDetailPage(RestaurantPropertyEntity restaurantPropertyEntity, PageBean pageBean) throws Exception;

    /**
     * 新增店铺详情
     *
     * @param restaurantPropertyEntity
     * @param request
     * @return
     * @throws Exception
     */
    Message addRestaurantDetail(RestaurantPropertyEntity restaurantPropertyEntity, HttpServletRequest request) throws Exception;

    /**
     * 获取店面闲情根据店面主键
     *
     * @param restaurantPropertyEntity
     * @return
     * @throws Exception
     */
    RestaurantPropertyEntity queryRestaurantPropertyById(RestaurantPropertyEntity restaurantPropertyEntity) throws Exception;

    /**
     * 删除店面详情信息
     *
     * @param restaurantPropertyEntity
     * @throws Exception
     */
    void deleteRestaurantDetail(RestaurantPropertyEntity restaurantPropertyEntity) throws Exception;
}
