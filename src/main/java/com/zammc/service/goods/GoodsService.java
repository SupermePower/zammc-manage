package com.zammc.service.goods;

import com.zammc.domain.goods.GoodsEntity;
import com.zammc.page.PageBean;
import com.zammc.response.Message;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author : fly
 * @Description :
 * @Date 2018/5/22
 */
public interface GoodsService {

    /**
     * 获取商品分页信息
     *
     * @param goodsEntity
     * @param pageBean
     * @throws Exception
     */
    void queryGoodsPage(GoodsEntity goodsEntity, PageBean pageBean) throws Exception;

    /**
     * 删除商品信息
     *
     * @param goodsEntity
     * @throws Exception
     */
    void deleteGoods(GoodsEntity goodsEntity) throws Exception;

    /**
     * 商品下架
     *
     * @param goodsEntity
     * @throws Exception
     */
    void dismountGoods(GoodsEntity goodsEntity) throws Exception;

    /**
     * 商品上架
     *
     * @param goodsEntity
     * @throws Exception
     */
    void shelfGoods(GoodsEntity goodsEntity) throws Exception;

    /**
     * 新增商品信息
     *
     * @param goodsEntity
     * @param request
     * @return
     * @throws Exception
     */
    Message addGoods(GoodsEntity goodsEntity, HttpServletRequest request) throws Exception;
}
