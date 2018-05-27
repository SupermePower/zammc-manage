package com.zammc.controller;

import com.zammc.domain.restaurant.RestaurantEntity;
import com.zammc.page.PageBean;
import com.zammc.response.Message;
import com.zammc.response.MessageStatus;
import com.zammc.response.MessageTitle;
import com.zammc.service.restaurant.RestaurantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author : fly
 * @Description :
 * @Date 2018/5/27
 */
@Controller
@RequestMapping("/restaurant")
@Slf4j
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    /**
     * 获取商店分页信息
     *
     * @param pageBean
     * @return
     */
    @RequestMapping(value = "/queryRestaurantPage")
    public ModelAndView queryRestaurantPage(PageBean pageBean) {
        ModelAndView modelAndView = new ModelAndView("restaurant/restaurant-list");
        try {
            restaurantService.queryRestaurantPage(pageBean);
            modelAndView.addObject("page", pageBean);
        } catch (Exception e) {
            log.error("RestaurantController queryRestaurantPage Exception \n", e);
        }
        return modelAndView;
    }

    /**
     * 跳转到编辑页面
     *
     * @param restaurantEntity
     * @return
     */
    @RequestMapping(value = "/toEdit")
    public ModelAndView toEdit(RestaurantEntity restaurantEntity) {
        ModelAndView modelAndView = new ModelAndView("restaurant/restaurant-edit");
        try {
            RestaurantEntity restaurant = restaurantService.queryRestaurantById(restaurantEntity);
            modelAndView.addObject("restaurant", restaurant);
        } catch (Exception e) {
            log.error("RestaurantController toEdit restaurantId -> {} Exception \n", restaurantEntity.getRestaurantId(), e);
        }
        return modelAndView;
    }

    /**
     * 编辑店家信息
     *
     * @param restaurantEntity
     * @param request
     * @return
     */
    @RequestMapping(value = "/editRestaurant")
    @ResponseBody
    public Message editRestaurant(RestaurantEntity restaurantEntity, HttpServletRequest request) {
        Message message = null;
        try {
            message = restaurantService.editRestaurant(restaurantEntity, request);
        } catch (Exception e) {
            log.error("RestaurantController editRestaurant restaurant -> {} Exception \n", restaurantEntity.toString(), e);
            message = new Message(MessageStatus.FAIL, MessageTitle.失败, "编辑失败");
        }
        return message;
    }
}
