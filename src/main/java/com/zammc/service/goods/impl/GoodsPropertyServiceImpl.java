package com.zammc.service.goods.impl;

import com.zammc.domain.goods.GoodsPropertyEntity;
import com.zammc.idworker.IdWorker;
import com.zammc.page.PageBean;
import com.zammc.repository.GoodsPropertyRepository;
import com.zammc.response.Message;
import com.zammc.response.MessageStatus;
import com.zammc.response.MessageTitle;
import com.zammc.service.goods.GoodsPropertyService;
import com.zammc.service.goods.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service
public class GoodsPropertyServiceImpl implements GoodsPropertyService {

    @Autowired
    private GoodsPropertyRepository goodsPropertyRepository;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private IdWorker idWorker;

    /**
     * 获取商品属性信息
     *
     * @param pageBean
     * @throws Exception
     */
    public void queryGoodsPropertyPage(PageBean pageBean) throws Exception {
        int page = pageBean.getPageNum() - 1;
        int size = pageBean.getPageSize();

        List<Sort.Order> orders = new ArrayList<>();
        orders.add(new Sort.Order(Sort.Direction.DESC, "updateTime"));
        Sort sort = new Sort(orders);
        Pageable pageable = new PageRequest(page, size, sort);
        Page<GoodsPropertyEntity> goodsPropertyEntities = goodsPropertyRepository.findAll(GoodsPropertySpecification.where(), pageable);
        pageBean.setPageSize(goodsPropertyEntities.getSize());
        pageBean.setPageNum(goodsPropertyEntities.getNumber() + 1);
        pageBean.setTotalPage(goodsPropertyEntities.getTotalPages());
        pageBean.setTotalRecorder(goodsPropertyEntities.getTotalElements());
        pageBean.setContent(goodsPropertyEntities.getContent());
    }

    /**
     * 新增商品规格信息
     *
     * @param goodsPropertyEntity
     * @param request
     * @return
     * @throws Exception
     */
    public Message addGoodsProperty(GoodsPropertyEntity goodsPropertyEntity, HttpServletRequest request) throws Exception {
        String propertyMsgs = request.getParameter("propertyMsgs");
        if ("".equals(propertyMsgs) || null == propertyMsgs) {
            return new Message(MessageStatus.FAIL, MessageTitle.失败, "规格参数不能为空");
        }
        String[] split = propertyMsgs.split(",");
        if ("".equals(goodsPropertyEntity.getGoodsId()) || 0 == goodsPropertyEntity.getGoodsId()) {
            return new Message(MessageStatus.FAIL, MessageTitle.失败, "商品不能为空");
        }
        if ("".equals(goodsPropertyEntity.getPropertyName()) || null == goodsPropertyEntity.getPropertyName()) {
            return new Message(MessageStatus.FAIL, MessageTitle.失败, "规格不能为空");
        }
        for (String propertyMsg : split) {
            goodsPropertyEntity.setId(idWorker.nextId());
            goodsPropertyEntity.setPropertyMsg(propertyMsg);
            goodsPropertyRepository.saveAndFlush(goodsPropertyEntity);
        }
        return new Message(MessageStatus.SUCCESS, MessageTitle.成功, "新增成功");
    }

    /**
     * 禁用规格信息
     *
     * @param goodsPropertyEntity
     * @return
     * @throws Exception
     */
    public Message disable(GoodsPropertyEntity goodsPropertyEntity) throws Exception {
        GoodsPropertyEntity one = goodsPropertyRepository.findOne(goodsPropertyEntity.getId());
        if (null != one && one.getDataStatus() == 0 && one.getPropertyStatus() == 0) {
            one.setPropertyStatus((byte) 1);
            goodsPropertyRepository.saveAndFlush(one);
        }
        return new Message(MessageStatus.SUCCESS, MessageTitle.成功, "操作成功");
    }

    /**
     * 启用规格信息
     *
     * @param goodsPropertyEntity
     * @return
     * @throws Exception
     */
    public Message enable(GoodsPropertyEntity goodsPropertyEntity) throws Exception {
        GoodsPropertyEntity one = goodsPropertyRepository.findOne(goodsPropertyEntity.getId());
        if (null != one && one.getDataStatus() == 0 && one.getPropertyStatus() == 1) {
            one.setPropertyStatus((byte) 0);
            goodsPropertyRepository.saveAndFlush(one);
        }
        return new Message(MessageStatus.SUCCESS, MessageTitle.成功, "操作成功");
    }

    /**
     * 删除规格信息
     *
     * @param goodsPropertyEntity
     * @return
     * @throws Exception
     */
    public Message delete(GoodsPropertyEntity goodsPropertyEntity) throws Exception {
        GoodsPropertyEntity one = goodsPropertyRepository.findOne(goodsPropertyEntity.getId());
        if (null != one && one.getDataStatus() == 0) {
            one.setDataStatus((byte) 1);
            goodsPropertyRepository.saveAndFlush(one);
        }
        return new Message(MessageStatus.SUCCESS, MessageTitle.成功, "删除成功");
    }
}
