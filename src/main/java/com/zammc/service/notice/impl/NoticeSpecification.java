package com.zammc.service.notice.impl;

import com.github.wenhao.jpa.Specifications;
import com.zammc.domain.notice.NoticeEntity;
import org.springframework.data.jpa.domain.Specification;

/**
 * @Author : fly
 * @Description :
 * @Date 2018/5/24
 */
public class NoticeSpecification {

    public static Specification<NoticeEntity> where(NoticeEntity request) {
        if(null != request.getNoticeName()) { //全部
            return Specifications.<NoticeEntity>and()
                    .eq("dataStatus", "1")
                    .eq("noticeName", request.getNoticeName())
                    .build();

        } else if (null == request.getNoticeName()) {
            return Specifications.<NoticeEntity>and()
                    .eq("dataStatus", "1")
                    .build();
        } else {
            return null;
        }
    }
}
