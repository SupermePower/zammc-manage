package com.zammc.service.reserve;

import com.zammc.domain.reserve.ReserveEntity;
import com.zammc.page.PageBean;

/**
 * @Author : fly
 * @Description :
 * @Date 2018/5/27
 */
public interface ReserveService {

    /**
     * 获取预约分页信息
     *
     * @param reserveEntity
     * @param pageBean
     * @throws Exception
     */
    void queryReservePage(ReserveEntity reserveEntity, PageBean pageBean) throws Exception;

    /**
     * 删除预约信息
     *
     * @param reserveEntity
     * @throws Exception
     */
    void deleteReserve(ReserveEntity reserveEntity) throws Exception;
}
