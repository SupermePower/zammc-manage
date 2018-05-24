package com.zammc.service.notice;

import com.zammc.domain.notice.NoticeEntity;
import com.zammc.page.PageBean;
import com.zammc.response.Message;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author : fly
 * @Description :
 * @Date 2018/5/24
 */
public interface NoticeService {

    /**
     * 分页获取公告信息
     *
     * @param noticeEntity
     * @param pageBean
     * @throws Exception
     */
    void queryNoticePage(NoticeEntity noticeEntity, PageBean pageBean) throws Exception;

    /**
     * 新增公告信息
     *
     * @param noticeEntity
     * @param request
     * @return
     * @throws Exception
     */
    Message addNotice(NoticeEntity noticeEntity, HttpServletRequest request) throws Exception;

    /**
     * 禁用公告信息
     *
     * @param noticeEntity
     * @throws Exception
     */
    void forbiddenNotice(NoticeEntity noticeEntity) throws Exception;

    /**
     * 启用公告信息
     *
     * @param noticeEntity
     * @throws Exception
     */
    void startUsingNotice(NoticeEntity noticeEntity) throws Exception;

    /**
     * 删除公告信息
     *
     * @param noticeEntity
     * @throws Exception
     */
    void deleteNotice(NoticeEntity noticeEntity) throws Exception;

    /**
     * 根据主键获取公告信息
     *
     * @param noticeEntity
     * @return
     * @throws Exception
     */
    NoticeEntity queryNoticeById(NoticeEntity noticeEntity) throws Exception;

    /**
     * 编辑公告信息
     *
     * @param noticeEntity
     * @param request
     * @return
     * @throws Exception
     */
    Message editNotice(NoticeEntity noticeEntity, HttpServletRequest request) throws Exception;
}
