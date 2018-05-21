package com.zammc.domain.goods;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 商品属性
 * Created by baihe
 * ON 2018/4/19.
 */
@Entity
@Table(name = "goods_property")
public class GoodsPropertyEntity {
    private long id;
    private long goodsId;
    private String propertyName;
    private String propertyMsg;
    private byte propertyStatus;
    private String propertyImg;
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
    @Column(name = "goods_id")
    public long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(long goodsId) {
        this.goodsId = goodsId;
    }

    @Basic
    @Column(name = "property_name")
    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    @Basic
    @Column(name = "property_msg")
    public String getPropertyMsg() {
        return propertyMsg;
    }

    public void setPropertyMsg(String propertyMsg) {
        this.propertyMsg = propertyMsg;
    }

    @Basic
    @Column(name = "property_status")
    public byte getPropertyStatus() {
        return propertyStatus;
    }

    public void setPropertyStatus(byte propertyStatus) {
        this.propertyStatus = propertyStatus;
    }

    @Basic
    @Column(name = "property_img")
    public String getPropertyImg() {
        return propertyImg;
    }

    public void setPropertyImg(String propertyImg) {
        this.propertyImg = propertyImg;
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
