package com.zammc.service.goods.impl;

import com.zammc.common.FileUtil;
import com.zammc.domain.goods.GoodsEntity;
import com.zammc.domain.goods.GoodsPropertyEntity;
import com.zammc.idworker.IdWorker;
import com.zammc.page.PageBean;
import com.zammc.repository.GoodsPropertyRepository;
import com.zammc.repository.GoodsRepository;
import com.zammc.response.Message;
import com.zammc.response.MessageStatus;
import com.zammc.response.MessageTitle;
import com.zammc.service.goods.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author : fly
 * @Description :
 * @Date 2018/5/22
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private GoodsRepository goodsRepository;

    @Autowired
    private GoodsPropertyRepository goodsPropertyRepository;

    /**
     * 获取商品分页信息
     *
     * @param goodsEntity
     * @param pageBean
     */
    public void queryGoodsPage(GoodsEntity goodsEntity, PageBean pageBean) throws Exception {
        int page = pageBean.getPageNum() - 1;
        int size = pageBean.getPageSize();

        List<Sort.Order> orders = new ArrayList<>();
        orders.add(new Sort.Order(Sort.Direction.DESC, "updateTime"));
        Sort sort = new Sort(orders);
        Pageable pageable = new PageRequest(page, size, sort);
        Page<GoodsEntity> orderInfoPage = goodsRepository.findAll(GoodsSpecification.where(goodsEntity), pageable);
        pageBean.setPageSize(orderInfoPage.getSize());
        pageBean.setPageNum(orderInfoPage.getNumber() + 1);
        pageBean.setTotalPage(orderInfoPage.getTotalPages());
        pageBean.setTotalRecorder(orderInfoPage.getTotalElements());
        pageBean.setContent(orderInfoPage.getContent());
    }

    /**
     * 删除商品信息
     *
     * @param goodsEntity
     * @throws Exception
     */
    public void deleteGoods(GoodsEntity goodsEntity) throws Exception {
        GoodsEntity one = goodsRepository.findOne(goodsEntity.getGoodsId());
        if (one != null && one.getDataStatus() == 0) {
            one.setDataStatus((byte) 1);
            goodsRepository.saveAndFlush(one);
        }
    }

    /**
     * 下架商品
     *
     * @param goodsEntity
     * @throws Exception
     */
    public void dismountGoods(GoodsEntity goodsEntity) throws Exception {
        GoodsEntity one = goodsRepository.findOne(goodsEntity.getGoodsId());
        if (one != null && one.getGoodsStatus() == 0) {
            one.setGoodsStatus((byte) 1);
            goodsRepository.saveAndFlush(one);
        }
    }

    /**
     * 上架商品
     *
     * @param goodsEntity
     * @throws Exception
     */
    public void shelfGoods(GoodsEntity goodsEntity) throws Exception {
        GoodsEntity one = goodsRepository.findOne(goodsEntity.getGoodsId());
        if (one != null && one.getGoodsStatus() == 1) {
            one.setGoodsStatus((byte) 0);
            goodsRepository.saveAndFlush(one);
        }
    }

    /**
     * 新增商品信息
     *
     * @param goodsEntity
     * @param request
     * @return
     * @throws Exception
     */
    @Transactional
    public Message addGoods(GoodsEntity goodsEntity, HttpServletRequest request) throws Exception {
        long goodsId = idWorker.nextId();
//        String propertys = request.getParameter("property");
//        if (goodsEntity.getGoodsType().equals("1")) {
//            if (null == propertys || "".equals(propertys)) {
//                return new Message(MessageStatus.FAIL, MessageTitle.失败, "商品规格不能为空");
//            }
//            //增加商品规格信息
//            addGoodsProperty(goodsId, propertys);
//        }
        MultipartHttpServletRequest mreq = (MultipartHttpServletRequest) request;
        MultipartFile image = mreq.getFile("image");
        if (image == null) {
            return new Message(MessageStatus.FAIL, MessageTitle.失败, "上传图片不能为空");
        } else {
            String img = "";
            try {
                img = FileUtil.uploadFile(image.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
            goodsEntity.setGoodsImg(img);
        }

        goodsEntity.setGoodsId(goodsId);
        goodsRepository.saveAndFlush(goodsEntity);
        return new Message(MessageStatus.SUCCESS, MessageTitle.成功, "添加成功");
    }

    /**
     * 增加商品规格信息
     *
     * @param goodsId
     * @param propertys
     */
    private void addGoodsProperty(long goodsId, String propertys) {
        String[] split = propertys.split(", ");
        for (String property : split) {
            GoodsPropertyEntity goodsPropertyEntity = new GoodsPropertyEntity();
            goodsPropertyEntity.setId(idWorker.nextId());
            goodsPropertyEntity.setGoodsId(goodsId);
            goodsPropertyEntity.setPropertyName(property);
            goodsPropertyEntity.setPropertyStatus((byte) 0);
            goodsPropertyRepository.saveAndFlush(goodsPropertyEntity);
        }
    }

    /**
     * 取货所有不是单品商品
     *
     * @return
     * @throws Exception
     */
    public List<GoodsEntity> queryAllNotSingleGoods() throws Exception {
        return goodsRepository.queryAllNotSingleGoods();
    }
}
