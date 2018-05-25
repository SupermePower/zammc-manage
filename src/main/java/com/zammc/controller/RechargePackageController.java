package com.zammc.controller;

import com.zammc.domain.recharge.RechargePackageEntity;
import com.zammc.page.PageBean;
import com.zammc.response.Message;
import com.zammc.response.MessageStatus;
import com.zammc.response.MessageTitle;
import com.zammc.service.recharge.RechargePackageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author : fly
 * @Description :
 * @Date 2018/5/25
 */
@Controller
@RequestMapping("/rechargePackage")
@Slf4j
public class RechargePackageController {

    @Autowired
    private RechargePackageService rechargePackageService;

    /**
     * 分页获取充值套餐信息
     *
     * @param rechargePackageEntity
     * @param pageBean
     * @return
     */
    @RequestMapping("/queryRechargePackagePage")
    public ModelAndView queryRechargePackagePage(RechargePackageEntity rechargePackageEntity, PageBean pageBean) {
        ModelAndView modelAndView = new ModelAndView("recharge/recharge-package-list");
        try {
            rechargePackageService.queryRechargePackagePage(rechargePackageEntity, pageBean);
            modelAndView.addObject("rechargePackage", rechargePackageEntity)
                    .addObject("page", pageBean);
        } catch (Exception e) {
            log.error("RechargePackageController queryRechargePackagePage Exception \n", e);
        }
        return modelAndView;
    }

    /**
     * 跳转到新增界面
     *
     * @return
     */
    @RequestMapping(value = "/toAdd")
    public ModelAndView toAdd() {
        return new ModelAndView("recharge/recharge-package-add");
    }

    /**
     * 新增充值信息
     *
     * @param rechargePackageEntity
     * @return
     */
    @RequestMapping(value = "/addRechargePackage")
    @ResponseBody
    public Message addRechargePackage(RechargePackageEntity rechargePackageEntity) {
        Message message = null;
        try {
            message = rechargePackageService.addRechargePackage(rechargePackageEntity);
        } catch (Exception e) {
            log.error("RechargePackageController addRechargePackage rechargePackage -> {} Exception \n", rechargePackageEntity.toString(), e);
            message = new Message(MessageStatus.FAIL, MessageTitle.失败, "新增失败");
        }
        return message;
    }

    /**
     * 跳转到编辑页面
     *
     * @param rechargePackageEntity
     * @return
     */
    @RequestMapping(value = "/toEdit")
    public ModelAndView toEdit(RechargePackageEntity rechargePackageEntity) {
        ModelAndView modelAndView = new ModelAndView("recharge/recharge-package-edit");
        try {
            RechargePackageEntity rechargePackage = rechargePackageService.queryRechargePackageById(rechargePackageEntity);
            modelAndView.addObject("rechargePackage", rechargePackage);
        } catch (Exception e) {
            log.error("RechargePackageController toEdit packageId -> {} Exception \n", rechargePackageEntity.getPackageId(), e);
        }
        return modelAndView;
    }

    /**
     * 编辑充值套餐信息
     *
     * @param rechargePackageEntity
     * @return
     */
    @RequestMapping(value = "/editRechargePackage")
    @ResponseBody
    public Message editRechargePackage(RechargePackageEntity rechargePackageEntity) {
        Message message = null;
        try {
            message = rechargePackageService.editRechargePackage(rechargePackageEntity);
        } catch (Exception e) {
            message = new Message(MessageStatus.FAIL, MessageTitle.失败, "编辑失败");
        }
        return message;
    }

    /**
     * 删除套餐信息
     *
     * @param rechargePackageEntity
     * @return
     */
    @RequestMapping("/deletePackage")
    @ResponseBody
    public Message deletePackage(RechargePackageEntity rechargePackageEntity) {
        Message message = null;
        try {
            rechargePackageService.deletePackage(rechargePackageEntity);
            message = new Message(MessageStatus.SUCCESS, MessageTitle.成功, "删除成功");
        } catch (Exception e) {
            log.error("RechargePackageController deletePackage packageId -> {}", rechargePackageEntity.getPackageId(), e);
            message = new Message(MessageStatus.FAIL, MessageTitle.失败, "删除失败");
        }
        return message;
    }
}
