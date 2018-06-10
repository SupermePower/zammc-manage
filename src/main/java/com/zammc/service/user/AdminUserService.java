package com.zammc.service.user;

import com.zammc.domain.user.AdminUserEntity;
import com.zammc.response.Message;

import javax.servlet.http.HttpServletRequest;

public interface AdminUserService {

    /**
     * 后台用户登录
     *
     * @param adminUserEntity
     * @return
     * @throws Exception
     */
    Message userLogin(AdminUserEntity adminUserEntity, HttpServletRequest request) throws Exception;
}
