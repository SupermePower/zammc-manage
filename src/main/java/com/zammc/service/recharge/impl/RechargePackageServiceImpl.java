package com.zammc.service.recharge.impl;

import com.zammc.domain.recharge.RechargePackageEntity;
import com.zammc.idworker.IdWorker;
import com.zammc.page.PageBean;
import com.zammc.repository.RechargePackageRepository;
import com.zammc.response.Message;
import com.zammc.response.MessageStatus;
import com.zammc.response.MessageTitle;
import com.zammc.service.recharge.RechargePackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author : fly
 * @Description :
 * @Date 2018/5/25
 */
@Service
public class RechargePackageServiceImpl implements RechargePackageService {

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private RechargePackageRepository rechargePackageRepository;

    /**
     * 分页过去充值套餐信息
     *
     * @param rechargePackageEntity
     * @param pageBean
     * @throws Exception
     */
    @Override
    public void queryRechargePackagePage(RechargePackageEntity rechargePackageEntity, PageBean pageBean) throws Exception {
        int page = pageBean.getPageNum() - 1;
        int size = pageBean.getPageSize();

        List<Sort.Order> orders = new ArrayList<>();
        orders.add(new Sort.Order(Sort.Direction.DESC, "updateTime"));
        Sort sort = new Sort(orders);
        Pageable pageable = new PageRequest(page, size, sort);
        Page<RechargePackageEntity> rechargePackagePage = rechargePackageRepository.findAll(RechargePackageSpecification.where(rechargePackageEntity), pageable);
        pageBean.setPageSize(rechargePackagePage.getSize());
        pageBean.setPageNum(rechargePackagePage.getNumber() + 1);
        pageBean.setTotalPage(rechargePackagePage.getTotalPages());
        pageBean.setTotalRecorder(rechargePackagePage.getTotalElements());
        pageBean.setContent(rechargePackagePage.getContent());
    }

    /**
     * 删除充值套餐信息
     *
     * @param rechargePackageEntity
     * @throws Exception
     */
    public void deletePackage(RechargePackageEntity rechargePackageEntity) throws Exception {
        RechargePackageEntity one = rechargePackageRepository.findOne(rechargePackageEntity.getPackageId());
        if (null != one && one.getDataStatus() == 0) {
            one.setDataStatus((byte) 1);
            rechargePackageRepository.saveAndFlush(one);
        }
    }

    /**
     * 获取套餐信息根据主键
     *
     * @param rechargePackageEntity
     * @return
     * @throws Exception
     */
    public RechargePackageEntity queryRechargePackageById(RechargePackageEntity rechargePackageEntity) throws Exception {
        return rechargePackageRepository.findOne(rechargePackageEntity.getPackageId());
    }

    /**
     * 编辑充值套餐信息
     *
     * @param rechargePackageEntity
     * @return
     * @throws Exception
     */
    public Message addRechargePackage(RechargePackageEntity rechargePackageEntity) throws Exception {
        Message x = checkPackage(rechargePackageEntity);
        if (x != null) return x;

        rechargePackageEntity.setPackageId(idWorker.nextId());
        rechargePackageRepository.saveAndFlush(rechargePackageEntity);
        return new Message(MessageStatus.SUCCESS, MessageTitle.成功, "新增成功");
    }

    /**
     * 编辑充值套餐信息
     *
     * @param rechargePackageEntity
     * @return
     * @throws Exception
     */
    public Message editRechargePackage(RechargePackageEntity rechargePackageEntity) throws Exception {
        Message x = checkPackage(rechargePackageEntity);
        if (x != null) return x;

        rechargePackageRepository.saveAndFlush(rechargePackageEntity);
        return new Message(MessageStatus.SUCCESS, MessageTitle.成功, "修改成功");
    }

    /**
     * 校验套餐信息
     *
     * @param rechargePackageEntity
     * @return
     */
    private Message checkPackage(RechargePackageEntity rechargePackageEntity) {
        if (null == rechargePackageEntity.getPackageName() || "".equals(rechargePackageEntity.getPackageName())) {
            return new Message(MessageStatus.FAIL, MessageTitle.失败, "套餐名称不能为空");
        }
        if (null == rechargePackageEntity.getRechargeMoney()) {
            return new Message(MessageStatus.FAIL, MessageTitle.失败, "充值金额不能为空");
        }
        if (rechargePackageEntity.getRechargeMoney().compareTo(new BigDecimal(0)) <= 0) {
            return new Message(MessageStatus.FAIL, MessageTitle.失败, "充值金额必须大于0");
        }
        if (null == rechargePackageEntity.getPayMoney()) {
            return new Message(MessageStatus.FAIL, MessageTitle.失败, "支付金额不能为空");
        }
        if (rechargePackageEntity.getPayMoney().compareTo(new BigDecimal(0)) <= 0) {
            return new Message(MessageStatus.FAIL, MessageTitle.失败, "支付金额必须大于0");
        }
        return null;
    }
}
