package com.zammc.domain.discount;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 折扣
 * Created by baihe
 * ON 2018/4/19.
 */
@Entity
@Table(name = "discount")
public class DiscountEntity {
    private long id;
    private byte discountType;
    private BigDecimal discountCondition;
    private BigDecimal discountSize;
    private String memo;
    private Timestamp createTime;
    private Timestamp updateTime;
    private byte version;
    private byte dataStatus;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "discount_type")
    public byte getDiscountType() {
        return discountType;
    }

    public void setDiscountType(byte discountType) {
        this.discountType = discountType;
    }

    @Basic
    @Column(name = "discount_condition")
    public BigDecimal getDiscountCondition() {
        return discountCondition;
    }

    public void setDiscountCondition(BigDecimal discountCondition) {
        this.discountCondition = discountCondition;
    }

    @Basic
    @Column(name = "discount_size")
    public BigDecimal getDiscountSize() {
        return discountSize;
    }

    public void setDiscountSize(BigDecimal discountSize) {
        this.discountSize = discountSize;
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
