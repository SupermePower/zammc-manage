package com.zammc.service.goods;

import com.zammc.domain.goods.GoodsCateEntity;
import com.zammc.page.PageBean;

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
}
