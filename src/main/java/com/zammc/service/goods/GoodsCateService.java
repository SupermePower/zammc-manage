package com.zammc.service.goods;

import com.zammc.domain.goods.GoodsCateEntity;
import com.zammc.page.PageBean;
import com.zammc.response.Message;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author : fly
 * @Description :
 * @Date 2018/5/24
 */
public interface GoodsCateService {

    /**
     * 获取商品分类分页信息
     *
     * @param goodsCateEntity
     * @param pageBean
     * @throws Exception
     */
    void queryGoodsCatePage(GoodsCateEntity goodsCateEntity, PageBean pageBean) throws Exception;

    /**
     * 启用商品分类信息
     *
     * @param goodsCateEntity
     * @return
     */
    void startUsingCate(GoodsCateEntity goodsCateEntity) throws Exception;

    /**
     * 禁用商品分类信息
     *
     * @param goodsCateEntity
     * @return
     */
    void forbiddenCate(GoodsCateEntity goodsCateEntity) throws Exception;

    /**
     * 删除商品分类信息
     *
     * @param goodsCateEntity
     * @return
     */
    void deleteGoodsCate(GoodsCateEntity goodsCateEntity) throws Exception;

    /**
     * 新增商品分类信息
     *
     * @param goodsCateEntity
     * @param request
     * @return
     * @throws Exception
     */
    Message addGoodsCate(GoodsCateEntity goodsCateEntity, HttpServletRequest request) throws Exception;
}
