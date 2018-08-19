package com.zammc.domain.coupon;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 代金券
 * Created by baihe
 * ON 2018/4/19.
 */
@Entity
@Table(name = "coupon")
@DynamicUpdate
@DynamicInsert
public class CouponEntity {
    private long id;
    private int couponNum;
    private byte couponType;
    private String couponImg;
    private BigDecimal couponSize;
    private BigDecimal couponCondition;
    private String couponMsg;
    private Timestamp couponTime;
    private Timestamp createTime;
    private Timestamp updateTime;
    private byte version;
    private byte dataStatus;
    private String couponName;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "coupon_num")
    public int getCouponNum() {
        return couponNum;
    }

    public void setCouponNum(int couponNum) {
        this.couponNum = couponNum;
    }

    @Basic
    @Column(name = "coupon_type")
    public byte getCouponType() {
        return couponType;
    }

    public void setCouponType(byte couponType) {
        this.couponType = couponType;
    }

    @Basic
    @Column(name = "coupon_img")
    public String getCouponImg() {
        return couponImg;
    }

    public void setCouponImg(String couponImg) {
        this.couponImg = couponImg;
    }

    @Basic
    @Column(name = "coupon_size")
    public BigDecimal getCouponSize() {
        return couponSize;
    }

    public void setCouponSize(BigDecimal couponSize) {
        this.couponSize = couponSize;
    }

    @Basic
    @Column(name = "coupon_condition")
    public BigDecimal getCouponCondition() {
        return couponCondition;
    }

    public void setCouponCondition(BigDecimal couponCondition) {
        this.couponCondition = couponCondition;
    }

    @Basic
    @Column(name = "coupon_msg")
    public String getCouponMsg() {
        return couponMsg;
    }

    public void setCouponMsg(String couponMsg) {
        this.couponMsg = couponMsg;
    }

    @Basic
    @Column(name = "coupon_time")
    public Timestamp getCouponTime() {
        return couponTime;
    }

    public void setCouponTime(Timestamp couponTime) {
        this.couponTime = couponTime;
    }

    @Basic
    @Column(name = "create_time")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "update_time")
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Basic
    @Column(name = "version")
    @Version
    public byte getVersion() {
        return version;
    }

    public void setVersion(byte version) {
        this.version = version;
    }

    @Basic
    @Column(name = "data_status")
    public byte getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(byte dataStatus) {
        this.dataStatus = dataStatus;
    }

    @Basic
    @Column(name = "coupon_name")
    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    @Override
    public String toString() {
        return "CouponEntity{" +
                "id=" + id +
                ", couponNum=" + couponNum +
                ", couponType=" + couponType +
                ", couponImg='" + couponImg + '\'' +
                ", couponSize=" + couponSize +
                ", couponCondition=" + couponCondition +
                ", couponMsg='" + couponMsg + '\'' +
                ", couponTime=" + couponTime +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", version=" + version +
                ", dataStatus=" + dataStatus +
                ", couponName='" + couponName + '\'' +
                '}';
    }
}
