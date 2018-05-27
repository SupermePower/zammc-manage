package com.zammc.service.goods.impl;

import com.zammc.common.FileUtil;
import com.zammc.domain.goods.GoodsCateEntity;
import com.zammc.idworker.IdWorker;
import com.zammc.page.PageBean;
import com.zammc.repository.GoodsCateRepository;
import com.zammc.response.Message;
import com.zammc.response.MessageStatus;
import com.zammc.response.MessageTitle;
import com.zammc.service.goods.GoodsCateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
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
    private IdWorker idWorker;

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

    /**
     * 启用分类信息
     *
     * @param goodsCateEntity
     * @throws Exception
     */
    @Override
    public void startUsingCate(GoodsCateEntity goodsCateEntity) throws Exception {
        GoodsCateEntity one = goodsCateRepository.findOne(goodsCateEntity.getCateId());
        if (null != one && one.getDataStatus() == 1 && one.getStatus() == 0) {
            one.setStatus((byte) 1);
            goodsCateRepository.saveAndFlush(one);
        }
    }

    /**
     * 禁用分类信息
     *
     * @param goodsCateEntity
     * @throws Exception
     */
    @Override
    public void forbiddenCate(GoodsCateEntity goodsCateEntity) throws Exception {
        GoodsCateEntity one = goodsCateRepository.findOne(goodsCateEntity.getCateId());
        if (null != one && one.getDataStatus() == 1 && one.getStatus() == 1) {
            one.setStatus((byte) 0);
            goodsCateRepository.saveAndFlush(one);
        }
    }

    /**
     * 删除分类信息
     *
     * @param goodsCateEntity
     * @throws Exception
     */
    @Override
    public void deleteGoodsCate(GoodsCateEntity goodsCateEntity) throws Exception {
        GoodsCateEntity one = goodsCateRepository.findOne(goodsCateEntity.getCateId());
        if (null != one && one.getDataStatus() == 1) {
            one.setDataStatus((byte) 0);
            goodsCateRepository.saveAndFlush(one);
        }
    }

    /**
     * 新增商品分类信息
     *
     * @param goodsCateEntity
     * @param request
     * @return
     * @throws Exception
     */
    public Message addGoodsCate(GoodsCateEntity goodsCateEntity, HttpServletRequest request) throws Exception {
        if (null == goodsCateEntity.getCateName() || "".equals(goodsCateEntity.getCateName())) {
            return new Message(MessageStatus.FAIL, MessageTitle.失败, "分类名称不能为空");
        }
        if (null == goodsCateEntity.getSort()) {
            return new Message(MessageStatus.FAIL, MessageTitle.失败, "分类显示顺序不能为空");
        }
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
            goodsCateEntity.setCateIcon(img);
        }
        goodsCateEntity.setCateId(idWorker.nextId());
        goodsCateRepository.saveAndFlush(goodsCateEntity);
        return new Message(MessageStatus.SUCCESS, MessageTitle.成功, "新增成功");
    }

    /**
     * 根据主键获取分类信息
     *
     * @param goodsCateEntity
     * @return
     * @throws Exception
     */
    public GoodsCateEntity queryGoodsCateById(GoodsCateEntity goodsCateEntity) throws Exception {
        return goodsCateRepository.findOne(goodsCateEntity.getCateId());
    }

    /**
     * 修改商品分类信息
     * @param goodsCateEntity
     * @param request
     * @return
     * @throws Exception
     */
    public Message editGoodsCate(GoodsCateEntity goodsCateEntity, HttpServletRequest request) throws Exception {
        if (null == goodsCateEntity.getCateName() || "".equals(goodsCateEntity.getCateName())) {
            return new Message(MessageStatus.FAIL, MessageTitle.失败, "分类名称不能为空");
        }
        if (null == goodsCateEntity.getSort()) {
            return new Message(MessageStatus.FAIL, MessageTitle.失败, "分类显示顺序不能为空");
        }
        GoodsCateEntity one = goodsCateRepository.findOne(goodsCateEntity.getCateId());
        if (null == goodsCateEntity.getCateIcon() && goodsCateEntity.getCateIcon() != one.getCateIcon()) {
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
                goodsCateEntity.setCateIcon(img);
            }
        }
        goodsCateRepository.saveAndFlush(goodsCateEntity);
        return new Message(MessageStatus.SUCCESS, MessageTitle.成功, "修改成功");
    }
}
