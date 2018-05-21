package com.zammc.domain.account;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 账户流水
 * Created by baihe
 * ON 2018/4/19.
 */
@Entity
@Table(name = "account_water")
public class AccountWaterEntity {
    private long waterId;
    private String userId;
    private Long orderId;
    private byte waterType;
    private BigDecimal waterNum;
    private Timestamp wanterTime;
    private String memo;
    private Timestamp createTime;
    private Timestamp updateTime;
    private byte version;
    private byte dataStatus;

    @Id
    @Column(name = "water_id")
    public long getWaterId() {
        return waterId;
    }

    public void setWaterId(long waterId) {
        this.waterId = waterId;
    }

    @Basic
    @Column(name = "user_id")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "order_id")
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "water_type")
    public byte getWaterType() {
        return waterType;
    }

    public void setWaterType(byte waterType) {
        this.waterType = waterType;
    }

    @Basic
    @Column(name = "water_num")
    public BigDecimal getWaterNum() {
        return waterNum;
    }

    public void setWaterNum(BigDecimal waterNum) {
        this.waterNum = waterNum;
    }

    @Basic
    @Column(name = "wanter_time")
    public Timestamp getWanterTime() {
        return wanterTime;
    }

    public void setWanterTime(Timestamp wanterTime) {
        this.wanterTime = wanterTime;
    }

    @Basic
    @Column(name = "memo")
    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
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

}
