package com.zammc.service.goods;

import com.zammc.domain.goods.GoodsCateEntity;
import com.zammc.page.PageBean;
import com.zammc.response.Message;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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

    /**
     * 根据主键获取分类信息
     *
     * @param goodsCateEntity
     * @return
     * @throws Exception
     */
    GoodsCateEntity queryGoodsCateById(GoodsCateEntity goodsCateEntity) throws Exception;

    /**
     * 修改商品分类信息
     *
     * @param goodsCateEntity
     * @param request
     * @return
     * @throws Exception
     */
    Message editGoodsCate(GoodsCateEntity goodsCateEntity, HttpServletRequest request) throws Exception;

    /**
     * 获取分类信息
     *
     * @return
     * @throws Exception
     */
    List<GoodsCateEntity> queryCateList() throws Exception;
}
