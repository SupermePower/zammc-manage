package com.zammc.service.goods;

import com.zammc.domain.goods.GoodsPropertyEntity;
import com.zammc.page.PageBean;
import com.zammc.response.Message;

import javax.servlet.http.HttpServletRequest;

public interface GoodsPropertyService {

    /**
     * 获取商品属性信息
     *
     * @param pageBean
     * @throws Exception
     */
    void queryGoodsPropertyPage(PageBean pageBean) throws Exception;

    /**
     * 新增商品规格信息
     *
     * @param goodsPropertyEntity
     * @param request
     * @return
     * @throws Exception
     */
    Message addGoodsProperty(GoodsPropertyEntity goodsPropertyEntity, HttpServletRequest request) throws Exception;

    /**
     * 禁用规格信息
     *
     * @param goodsPropertyEntity
     * @return
     * @throws Exception
     */
    Message disable(GoodsPropertyEntity goodsPropertyEntity) throws Exception;

    /**
     * 启用规格信息
     *
     * @param goodsPropertyEntity
     * @return
     * @throws Exception
     */
    Message delete(GoodsPropertyEntity goodsPropertyEntity) throws Exception;

    /**
     * 启用规格信息
     *
     * @param goodsPropertyEntity
     * @return
     * @throws Exception
     */
    Message enable(GoodsPropertyEntity goodsPropertyEntity) throws Exception;
}
