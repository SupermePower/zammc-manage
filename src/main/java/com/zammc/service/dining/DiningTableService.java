package com.zammc.service.dining;

import com.zammc.domain.table.DiningTableEntity;
import com.zammc.page.PageBean;
import com.zammc.response.Message;

import java.util.List;

/**
 * @Author : fly
 * @Description :
 * @Date 2018/5/26
 */
public interface DiningTableService {

    /**
     * 获取餐位分页信息
     *
     * @param diningTableEntity
     * @param pageBean
     * @throws Exception
     */
    void queryDiningTablePage(DiningTableEntity diningTableEntity, PageBean pageBean) throws Exception;

    /**
     * 新增餐位信息
     *
     * @param diningTableEntity
     * @return
     * @throws Exception
     */
    Message addDiningTable(DiningTableEntity diningTableEntity) throws Exception;

    /**
     * 根据主键获取餐位信息
     *
     * @param diningTableEntity
     * @return
     * @throws Exception
     */
    DiningTableEntity queryDiningTableById(DiningTableEntity diningTableEntity) throws Exception;

    /**
     * 编辑餐位信息
     *
     * @param diningTableEntity
     * @return
     * @throws Exception
     */
    Message editDiningTable(DiningTableEntity diningTableEntity) throws Exception;

    /**
     * 删除餐位信息
     *
     * @param diningTableEntity
     * @throws Exception
     */
    void deleteDiningTable(DiningTableEntity diningTableEntity) throws Exception;

    /**
     * 首页餐位信息
     *
     * @return
     * @throws Exception
     */
    List<DiningTableEntity> indexDiningTableData() throws Exception;

    /**
     * 获取空闲餐位数
     *
     * @return
     * @throws Exception
     */
    Long queryFreeTableCount() throws Exception;
}
