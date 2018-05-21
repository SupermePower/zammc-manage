package com.zammc.exception;

/**
 * @Author : fly
 * @Description :
 * @Date 2018/5/21
 */
public class BusinessException extends RuntimeException {

    private int dealCode;

    public BusinessException(String dealMsg) {
        super(dealMsg);
    }

    public BusinessException(int dealCode, String dealMsg) {
        super(dealMsg);
        this.dealCode = dealCode;
    }

    public BusinessException(int dealCode, String dealMsg, Throwable throwable) {
        super(dealMsg, throwable);
        this.dealCode = dealCode;
    }

    public int getDealCode() {
        return dealCode;
    }

    public void setDealCode(int dealCode) {
        this.dealCode = dealCode;
    }
}