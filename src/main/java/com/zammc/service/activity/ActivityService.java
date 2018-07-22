package com.zammc.service.activity;

import com.zammc.domain.activity.ActivityEntity;
import com.zammc.page.PageBean;
import com.zammc.response.Message;

/**
 * @description 活动业务
 * @author: fly
 * @Date: 2018/7/22 下午2:34
 */
public interface ActivityService {

    /**
     * 获取活动信息
     *
     * @param activityEntity
     * @param pageBean
     * @return
     */
    void queryActivityPage(ActivityEntity activityEntity, PageBean pageBean) throws Exception;

    /**
     * 删除活动信息
     *
     * @param activityEntity
     * @return
     */
    Message deleteActivity(ActivityEntity activityEntity) throws Exception;

    /**
     * 新增活动
     *
     * @param activityEntity
     * @return
     */
    Message addActivity(ActivityEntity activityEntity) throws Exception;

    /**
     * 启用活动
     *
     * @param activityEntity
     * @return
     */
    Message startUsing(ActivityEntity activityEntity) throws Exception;

    /**
     * 禁用活动
     *
     * @param activityEntity
     * @return
     */
    Message forbidden(ActivityEntity activityEntity) throws Exception;
}
