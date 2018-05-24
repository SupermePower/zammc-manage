package com.zammc.service.banner.impl;

import com.zammc.common.FileUtil;
import com.zammc.domain.banner.BannerEntity;
import com.zammc.idworker.IdWorker;
import com.zammc.page.PageBean;
import com.zammc.repository.BannerRepository;
import com.zammc.response.Message;
import com.zammc.response.MessageStatus;
import com.zammc.response.MessageTitle;
import com.zammc.service.banner.BannerService;
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
public class BannerServiceImpl implements BannerService {


    @Autowired
    private IdWorker idWorker;

    @Autowired
    private BannerRepository bannerRepository;


    /**
     * 获取banner分页信息
     *
     * @param bannerEntity
     * @param pageBean
     * @throws Exception
     */
    public void queryBannerPage(BannerEntity bannerEntity, PageBean pageBean) throws Exception {
        int page = pageBean.getPageNum() - 1;
        int size = pageBean.getPageSize();

        List<Sort.Order> orders = new ArrayList<>();
        orders.add(new Sort.Order(Sort.Direction.ASC, "bannerSort"));
        Sort sort = new Sort(orders);
        Pageable pageable = new PageRequest(page, size, sort);
        Page<BannerEntity> bannerPage = bannerRepository.findAll(BannerSpecification.where(bannerEntity), pageable);
        pageBean.setPageSize(bannerPage.getSize());
        pageBean.setPageNum(bannerPage.getNumber() + 1);
        pageBean.setTotalPage(bannerPage.getTotalPages());
        pageBean.setTotalRecorder(bannerPage.getTotalElements());
        pageBean.setContent(bannerPage.getContent());
    }

    /**
     * 删除banner
     *
     * @param bannerEntity
     * @throws Exception
     */
    public void deleteBanner(BannerEntity bannerEntity) throws Exception {
        BannerEntity one = bannerRepository.findOne(bannerEntity.getBannerId());
        if (null != one && one.getDataStatus() == 1) {
            one.setDataStatus((byte) 0);
            bannerRepository.saveAndFlush(one);
        }
    }

    /**
     * 禁用banner
     *
     * @param bannerEntity
     * @throws Exception
     */
    public void forbiddenBanner(BannerEntity bannerEntity) throws Exception {
        BannerEntity one = bannerRepository.findOne(bannerEntity.getBannerId());
        if (null != one && one.getDataStatus() == 1 && one.getBannerStatus() == 1) {
            one.setBannerStatus((byte) 0);
            bannerRepository.saveAndFlush(one);
        }
    }

    /**
     * 启用banner信息
     *
     * @param bannerEntity
     * @throws Exception
     */
    public void startUsingBanner(BannerEntity bannerEntity) throws Exception {
        BannerEntity one = bannerRepository.findOne(bannerEntity.getBannerId());
        if (null != one && one.getDataStatus() == 1 && one.getBannerStatus() == 0) {
            one.setBannerStatus((byte) 1);
            bannerRepository.saveAndFlush(one);
        }
    }

    /**
     * 根据主键获取banner信息
     *
     * @param bannerEntity
     * @return
     * @throws Exception
     */
    public BannerEntity queryBannerById(BannerEntity bannerEntity) throws Exception {
        return bannerRepository.findOne(bannerEntity.getBannerId());
    }

    /**
     * 编辑banner信息
     *
     * @param bannerEntity
     * @param request
     * @return
     * @throws Exception
     */
    public Message editBanner(BannerEntity bannerEntity, HttpServletRequest request) throws Exception {
        if (null == bannerEntity.getBannerName() || "".equals(bannerEntity.getBannerName())) {
            return new Message(MessageStatus.SUCCESS, MessageTitle.失败, "banner名称不能为空");
        }
        BannerEntity banner = bannerRepository.findOne(bannerEntity.getBannerId());
        /*
         * 1：上传图片原有图片是否相等
         * 2：上传图片是否为null
         * 3：上传图片是否为空串
         */
        if (!bannerEntity.getBannerUrl().equals(banner.getBannerUrl()) || "".equals(banner.getBannerUrl()) || null == banner.getBannerUrl()) {
            MultipartHttpServletRequest mreq = (MultipartHttpServletRequest) request;
            MultipartFile image = mreq.getFile("image");
            if (checkBannerImage(banner, image)) return new Message(MessageStatus.FAIL, MessageTitle.失败, "上传图片不能为空");
        }
        banner.setBannerName(bannerEntity.getBannerName());
        banner.setBannerSort(bannerEntity.getBannerSort());
        bannerRepository.saveAndFlush(banner);
        return new Message(MessageStatus.SUCCESS, MessageTitle.成功, "修改成功");
    }

    /**
     * 新增banner信息
     *
     * @param bannerEntity
     * @param request
     * @return
     * @throws Exception
     */
    public Message addBanner(BannerEntity bannerEntity, HttpServletRequest request) throws Exception {
        MultipartHttpServletRequest mreq = (MultipartHttpServletRequest) request;
        MultipartFile image = mreq.getFile("image");
        if (checkBannerImage(bannerEntity, image)) return new Message(MessageStatus.FAIL, MessageTitle.失败, "上传图片不能为空");
        if (null == bannerEntity.getBannerName() || "".equals(bannerEntity.getBannerName())) {
            return new Message(MessageStatus.FAIL, MessageTitle.失败, "banner名称不能为空");
        }
        bannerEntity.setBannerId(idWorker.nextId());
        bannerRepository.saveAndFlush(bannerEntity);
        return new Message(MessageStatus.SUCCESS, MessageTitle.成功, "新增成功");
    }

    /**
     * 校验banner信息
     *
     * @param bannerEntity
     * @param image
     * @return
     */
    private boolean checkBannerImage(BannerEntity bannerEntity, MultipartFile image) {
        if (image == null) {
            return true;
        } else {
            String img = "";
            try {
                img = FileUtil.uploadFile(image.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
            bannerEntity.setBannerUrl(img);
        }
        return false;
    }
}
