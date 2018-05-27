package com.zammc.service.restaurant;

import com.zammc.domain.restaurant.RestaurantEntity;
import com.zammc.page.PageBean;
import com.zammc.response.Message;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author : fly
 * @Description :
 * @Date 2018/5/27
 */
public interface RestaurantService {

    /**
     * 获取商店信息
     *
     * @param pageBean
     * @throws Exception
     */
    void queryRestaurantPage(PageBean pageBean) throws Exception;

    /**
     * 根据主键获取店家信息
     *
     * @param restaurantEntity
     * @throws Exception
     */
    RestaurantEntity queryRestaurantById(RestaurantEntity restaurantEntity) throws Exception;

    /**
     * 编辑店家信息
     *
     * @param restaurantEntity
     * @param request
     * @return
     * @throws Exception
     */
    Message editRestaurant(RestaurantEntity restaurantEntity, HttpServletRequest request) throws Exception;
}
