package com.zammc.service.goods.impl;

import com.zammc.domain.goods.GoodsCateEntity;
import com.zammc.domain.goods.GoodsEntity;
import com.zammc.page.PageBean;
import com.zammc.repository.GoodsCateRepository;
import com.zammc.service.goods.GoodsCateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : fly
 * @Description :
 * @Date 2018/5/24
 */
@Service
public class GoodsCateServiceImpl implements GoodsCateService {

    @Autowired
    private GoodsCateRepository goodsCateRepository;

    /**
     * 获取商品分类分页信息
     *
     * @param goodsCateEntity
     * @param pageBean
     * @throws Exception
     */
    public void queryGoodsCatePage(GoodsCateEntity goodsCateEntity, PageBean pageBean) throws Exception {
        int page = pageBean.getPageNum() - 1;
        int size = pageBean.getPageSize();

        List<Sort.Order> orders = new ArrayList<>();
        orders.add(new Sort.Order(Sort.Direction.DESC, "updateTime"));
        Sort sort = new Sort(orders);
        Pageable pageable = new PageRequest(page, size, sort);
        Page<GoodsCateEntity> goodsCatePage = goodsCateRepository.findAll(GoodsCateSpecification.where(goodsCateEntity), pageable);
        pageBean.setPageSize(goodsCatePage.getSize());
        pageBean.setPageNum(goodsCatePage.getNumber() + 1);
        pageBean.setTotalPage(goodsCatePage.getTotalPages());
        pageBean.setTotalRecorder(goodsCatePage.getTotalElements());
        pageBean.setContent(goodsCatePage.getContent());
    }
}
