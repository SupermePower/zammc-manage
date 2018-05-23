package com.zammc.service.customer;

import com.zammc.domain.user.UserInfoEntity;
import com.zammc.page.PageBean;

public interface CustomerService {

    /**
     * 获取顾客分页信息
     *
     * @param userInfoEntity
     * @param pageBean
     * @throws Exception
     */
    void queryCustomerPage(UserInfoEntity userInfoEntity, PageBean pageBean) throws Exception;

    /**
     * 删除顾客信息
     *
     * @param userInfo
     * @throws Exception
     */
    void deleteCustomer(UserInfoEntity userInfo) throws Exception;
}
