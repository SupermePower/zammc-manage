package com.zammc.service.notice.impl;

import com.zammc.common.FileUtil;
import com.zammc.domain.notice.NoticeEntity;
import com.zammc.idworker.IdWorker;
import com.zammc.page.PageBean;
import com.zammc.repository.NoticeRepository;
import com.zammc.response.Message;
import com.zammc.response.MessageStatus;
import com.zammc.response.MessageTitle;
import com.zammc.service.notice.NoticeService;
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
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private NoticeRepository noticeRepository;

    /**
     * 分页获取公告信息
     *
     * @param noticeEntity
     * @param pageBean
     * @throws Exception
     */
    public void queryNoticePage(NoticeEntity noticeEntity, PageBean pageBean) throws Exception {
        int page = pageBean.getPageNum() - 1;
        int size = pageBean.getPageSize();

        List<Sort.Order> orders = new ArrayList<>();
        orders.add(new Sort.Order(Sort.Direction.ASC, "noticeSort"));
        Sort sort = new Sort(orders);
        Pageable pageable = new PageRequest(page, size, sort);
        Page<NoticeEntity> noticePage = noticeRepository.findAll(NoticeSpecification.where(noticeEntity), pageable);
        pageBean.setPageSize(noticePage.getSize());
        pageBean.setPageNum(noticePage.getNumber() + 1);
        pageBean.setTotalPage(noticePage.getTotalPages());
        pageBean.setTotalRecorder(noticePage.getTotalElements());
        pageBean.setContent(noticePage.getContent());
    }

    /**
     * 新增公告信息
     *
     * @param noticeEntity
     * @param request
     * @return
     * @throws Exception
     */
    public Message addNotice(NoticeEntity noticeEntity, HttpServletRequest request) throws Exception {
        if (null == noticeEntity.getNoticeName() || "".equals(noticeEntity.getNoticeName())) {
            return new Message(MessageStatus.FAIL, MessageTitle.失败, "公告名称不能为空");
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
            noticeEntity.setNoticeUrl(img);
        }
        noticeEntity.setNoticeId(idWorker.nextId());
        noticeRepository.saveAndFlush(noticeEntity);
        return new Message(MessageStatus.SUCCESS, MessageTitle.成功, "添加成功");
    }

    /**
     * 禁用公告信息
     *
     * @param noticeEntity
     * @throws Exception
     */
    @Override
    public void forbiddenNotice(NoticeEntity noticeEntity) throws Exception {
        NoticeEntity one = noticeRepository.findOne(noticeEntity.getNoticeId());
        if (null != one && one.getDataStatus() == 1 && one.getNoticeStatus() == 1) {
            one.setNoticeStatus((byte) 0);
            noticeRepository.saveAndFlush(one);
        }
    }

    /**
     * 启用公告信息
     *
     * @param noticeEntity
     * @throws Exception
     */
    @Override
    public void startUsingNotice(NoticeEntity noticeEntity) throws Exception {
        NoticeEntity one = noticeRepository.findOne(noticeEntity.getNoticeId());
        if (null != one && one.getDataStatus() == 1 && one.getNoticeStatus() == 0) {
            one.setNoticeStatus((byte) 1);
            noticeRepository.saveAndFlush(one);
        }
    }

    /**
     * 删除公告信息
     *
     * @param noticeEntity
     * @throws Exception
     */
    @Override
    public void deleteNotice(NoticeEntity noticeEntity) throws Exception {
        NoticeEntity one = noticeRepository.findOne(noticeEntity.getNoticeId());
        if (null != one && one.getDataStatus() == 1) {
            one.setDataStatus((byte) 0);
            noticeRepository.saveAndFlush(one);
        }
    }

    /**
     * 根据主键获取公告信息
     *
     * @param noticeEntity
     * @return
     * @throws Exception
     */
    public NoticeEntity queryNoticeById(NoticeEntity noticeEntity) throws Exception {
        return noticeRepository.findOne(noticeEntity.getNoticeId());
    }

    /**
     * 编辑公告信息
     *
     * @param noticeEntity
     * @param request
     * @return
     * @throws Exception
     */
    public Message editNotice(NoticeEntity noticeEntity, HttpServletRequest request) throws Exception {
        if (null == noticeEntity.getNoticeName() || "".equals(noticeEntity.getNoticeName())) {
            return new Message(MessageStatus.SUCCESS, MessageTitle.失败, "公告名称不能为空");
        }
        NoticeEntity notice = noticeRepository.findOne(noticeEntity.getNoticeId());
        /*
         * 1：上传图片原有图片是否相等
         * 2：上传图片是否为null
         * 3：上传图片是否为空串
         */
        if (!noticeEntity.getNoticeUrl().equals(notice.getNoticeUrl()) || "".equals(notice.getNoticeUrl()) || null == notice.getNoticeUrl()) {
            MultipartHttpServletRequest mreq = (MultipartHttpServletRequest) request;
            MultipartFile image = mreq.getFile("image");
            if (checkNoticeImage(notice, image)) return new Message(MessageStatus.FAIL, MessageTitle.失败, "上传图片不能为空");
        }
        notice.setNoticeName(noticeEntity.getNoticeName());
        notice.setNoticeSort(noticeEntity.getNoticeSort());
        noticeRepository.saveAndFlush(notice);
        return new Message(MessageStatus.SUCCESS, MessageTitle.成功, "修改成功");
    }

    /**
     * 校验banner信息
     *
     * @param noticeEntity
     * @param image
     * @return
     */
    private boolean checkNoticeImage(NoticeEntity noticeEntity, MultipartFile image) {
        if (image == null) {
            return true;
        } else {
            String img = "";
            try {
                img = FileUtil.uploadFile(image.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
            noticeEntity.setNoticeUrl(img);
        }
        return false;
    }
}
