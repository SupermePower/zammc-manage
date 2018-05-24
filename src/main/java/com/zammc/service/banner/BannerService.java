package com.zammc.service.banner;

import com.zammc.domain.banner.BannerEntity;
import com.zammc.page.PageBean;
import com.zammc.response.Message;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author : fly
 * @Description :
 * @Date 2018/5/24
 */
public interface BannerService {

    /**
     * 获取banner分页信息
     *
     * @param bannerEntity
     * @param pageBean
     * @throws Exception
     */
    void queryBannerPage(BannerEntity bannerEntity, PageBean pageBean) throws Exception;

    /**
     * 删除banner
     *
     * @param bannerEntity
     * @throws Exception
     */
    void deleteBanner(BannerEntity bannerEntity) throws Exception;

    /**
     * 禁用banner
     *
     * @param bannerEntity
     * @throws Exception
     */
    void forbiddenBanner(BannerEntity bannerEntity) throws Exception;

    /**
     * 启用banner信息
     *
     * @param bannerEntity
     * @throws Exception
     */
    void startUsingBanner(BannerEntity bannerEntity) throws Exception;

    /**
     * 根据主键获取banner信息
     *
     * @param bannerEntity
     * @return
     * @throws Exception
     */
    BannerEntity queryBannerById(BannerEntity bannerEntity) throws Exception;

    /**
     * 编辑banner信息
     *
     * @param bannerEntity
     * @param request
     * @return
     * @throws Exception
     */
    Message editBanner(BannerEntity bannerEntity, HttpServletRequest request) throws Exception;

    /**
     * 新增banner信息
     *
     * @param bannerEntity
     * @param request
     * @return
     * @throws Exception
     */
    Message addBanner(BannerEntity bannerEntity, HttpServletRequest request) throws Exception;
}
