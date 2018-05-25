package com.zammc.service.recharge;

import com.zammc.domain.recharge.RechargePackageEntity;
import com.zammc.page.PageBean;
import com.zammc.response.Message;

/**
 * @Author : fly
 * @Description :
 * @Date 2018/5/25
 */
public interface RechargePackageService {

    /**
     * 分页获取充值套餐信息
     *
     * @param rechargePackageEntity
     * @param pageBean
     * @throws Exception
     */
    void queryRechargePackagePage(RechargePackageEntity rechargePackageEntity, PageBean pageBean) throws Exception;

    /**
     * 删除充值套餐信息
     *
     * @param rechargePackageEntity
     * @throws Exception
     */
    void deletePackage(RechargePackageEntity rechargePackageEntity) throws Exception;

    /**
     * 获取套餐信息根据主键
     *
     * @param rechargePackageEntity
     * @return
     * @throws Exception
     */
    RechargePackageEntity queryRechargePackageById(RechargePackageEntity rechargePackageEntity) throws Exception;

    /**
     * 编辑充值套餐信息
     *
     * @param rechargePackageEntity
     * @return
     * @throws Exception
     */
    Message editRechargePackage(RechargePackageEntity rechargePackageEntity) throws Exception;

    /**
     * 新增充值套餐信息
     *
     * @param rechargePackageEntity
     * @return
     * @throws Exception
     */
    Message addRechargePackage(RechargePackageEntity rechargePackageEntity) throws Exception;
}
