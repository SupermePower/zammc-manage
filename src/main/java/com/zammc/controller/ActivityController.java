package com.zammc.controller;

import com.zammc.domain.activity.ActivityEntity;
import com.zammc.page.PageBean;
import com.zammc.response.Message;
import com.zammc.response.MessageStatus;
import com.zammc.response.MessageTitle;
import com.zammc.service.activity.ActivityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @description 活动设置控制器
 * @author: fly
 * @Date: 2018/7/22 上午10:19
 */
@Controller
@RequestMapping("/activity")
@Slf4j
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    /**
     * 获取活动信息
     *
     * @param activityEntity
     * @param pageBean
     * @return
     */
    @RequestMapping(path = "/queryActivityPage")
    public ModelAndView queryActivityPage(ActivityEntity activityEntity, PageBean pageBean) {
        ModelAndView modelAndView = new ModelAndView("activity/activity-list");
        try {
            activityService.queryActivityPage(activityEntity, pageBean);
            modelAndView.addObject("activityEntity", activityEntity)
                    .addObject("page", pageBean);
        } catch (Exception e) {
            log.error("ActivityController queryActivityPage Exception", e);
        }
        return modelAndView;
    }

    /**
     * 删除活动信息
     *
     * @param activityEntity
     * @return
     */
    @RequestMapping(path = "/deleteActivity")
    @ResponseBody
    public Message deleteActivity(ActivityEntity activityEntity) {
        Message message = null;
        try {
            message = activityService.deleteActivity(activityEntity);
        } catch (Exception e) {
            log.error("ActivityController deleteActivity activityId -> {} Exception", activityEntity.getActivityId(), e);
            message = new Message(MessageStatus.FAIL, MessageTitle.失败, "删除失败");
        }
        return message;
    }

    /**
     * 跳转到新增页面
     *
     * @return
     */
    @RequestMapping(path = "/toAdd")
    public ModelAndView toAdd() {
        return new ModelAndView("activity/activity-add");
    }

    /**
     * 新增活动
     *
     * @param activityEntity
     * @return
     */
    @RequestMapping(path = "/addActivity")
    @ResponseBody
    public Message addActivity(ActivityEntity activityEntity) {
        Message message = null;
        try {
            message = activityService.addActivity(activityEntity);
        } catch (Exception e) {
            log.error("ActivityController addActivity activity -> {} Exception", activityEntity.toString(), e);
            message = new Message(MessageStatus.FAIL, MessageTitle.失败, "新增失败");
        }
        return message;
    }

    /**
     * 启用活动
     *
     * @param activityEntity
     * @return
     */
    @RequestMapping(path = "/startUsing")
    @ResponseBody
    public Message startUsing(ActivityEntity activityEntity) {
        Message message = null;
        try {
            message = activityService.startUsing(activityEntity);
        } catch (Exception e) {
            log.error("ActivityController startUsing activityId -> {}", activityEntity.toString(), e);
            message = new Message(MessageStatus.FAIL, MessageTitle.失败, "操作失败");
        }
        return message;
    }

    /**
     * 禁用活动
     *
     * @param activityEntity
     * @return
     */
    @RequestMapping(path = "/forbidden")
    @ResponseBody
    public Message forbidden(ActivityEntity activityEntity) {
        Message message = null;
        try {
            message = activityService.forbidden(activityEntity);
        } catch (Exception e) {
            log.error("ActivityController forbidden activityId -> {}", activityEntity.toString(), e);
            message = new Message(MessageStatus.FAIL, MessageTitle.失败, "操作失败");
        }
        return message;
    }
}
