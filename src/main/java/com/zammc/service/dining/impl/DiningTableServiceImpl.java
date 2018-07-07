package com.zammc.service.dining.impl;

import com.zammc.domain.table.DiningTableEntity;
import com.zammc.idworker.IdWorker;
import com.zammc.page.PageBean;
import com.zammc.repository.DiningTableRepository;
import com.zammc.response.Message;
import com.zammc.response.MessageStatus;
import com.zammc.response.MessageTitle;
import com.zammc.service.dining.DiningTableService;
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
 * @Date 2018/5/26
 */
@Service
public class DiningTableServiceImpl implements DiningTableService {

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private DiningTableRepository diningTableRepository;

    /**
     * 获取餐位分页信息
     *
     * @param diningTableEntity
     * @param pageBean
     * @throws Exception
     */
    public void queryDiningTablePage(DiningTableEntity diningTableEntity, PageBean pageBean) throws Exception {
        int page = pageBean.getPageNum() - 1;
        int size = pageBean.getPageSize();

        List<Sort.Order> orders = new ArrayList<>();
        orders.add(new Sort.Order(Sort.Direction.DESC, "updateTime"));
        Sort sort = new Sort(orders);
        Pageable pageable = new PageRequest(page, size, sort);
        Page<DiningTableEntity> diningTablePage = diningTableRepository.findAll(DiningTableSpecification.where(diningTableEntity), pageable);
        pageBean.setPageSize(diningTablePage.getSize());
        pageBean.setPageNum(diningTablePage.getNumber() + 1);
        pageBean.setTotalPage(diningTablePage.getTotalPages());
        pageBean.setTotalRecorder(diningTablePage.getTotalElements());
        pageBean.setContent(diningTablePage.getContent());
    }

    /**
     * 新增餐位信息
     *
     * @param diningTableEntity
     * @return
     * @throws Exception
     */
    public Message addDiningTable(DiningTableEntity diningTableEntity) throws Exception {
        if (null == diningTableEntity.getTableCode() || "".equals(diningTableEntity.getTableCode())) {
            return new Message(MessageStatus.FAIL, MessageTitle.失败, "餐位编码不能为空");
        }
        diningTableEntity.setTableId(idWorker.nextId());
        diningTableEntity.setTableStatus((byte) 1);
        diningTableEntity.setDataStatus((byte) 1);
        diningTableRepository.saveAndFlush(diningTableEntity);
        return new Message(MessageStatus.SUCCESS, MessageTitle.成功, "新增成功");
    }

    /**
     * 根据主键获取餐位信息
     *
     * @param diningTableEntity
     * @return
     * @throws Exception
     */
    public DiningTableEntity queryDiningTableById(DiningTableEntity diningTableEntity) throws Exception {
        return diningTableRepository.findOne(diningTableEntity.getTableId());
    }

    /**
     * 编辑餐位信息
     *
     * @param diningTableEntity
     * @return
     * @throws Exception
     */
    public Message editDiningTable(DiningTableEntity diningTableEntity) throws Exception {
        if (null == diningTableEntity.getTableCode() || "".equals(diningTableEntity.getTableCode())) {
            return new Message(MessageStatus.FAIL, MessageTitle.失败, "餐位编码不能为空");
        }
        diningTableRepository.saveAndFlush(diningTableEntity);
        return new Message(MessageStatus.SUCCESS, MessageTitle.成功, "修改成功");
    }

    /**
     * 删除餐位信息
     *
     * @param diningTableEntity
     * @throws Exception
     */
    public void deleteDiningTable(DiningTableEntity diningTableEntity) throws Exception {
        DiningTableEntity one = diningTableRepository.findOne(diningTableEntity.getTableId());
        if (null != one && one.getDataStatus() == 1) {
            one.setDataStatus((byte) 0);
            diningTableRepository.saveAndFlush(one);
        }
    }

    /**
     * 首页餐位信息
     *
     * @return
     * @throws Exception
     */
    public List<DiningTableEntity> indexDiningTableData() throws Exception {
        return diningTableRepository.indexDiningTableData();
    }
}
