package com.zammc.domain.goods;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 商品分类
 * Created by baihe
 * ON 2018/4/19.
 */
@Entity
@Table(name = "goods_cate")
public class GoodsCateEntity {
    private long cateId;
    private String cateIcon;
    private String cateName;
    private Integer sort;
    private Byte status;
    private Timestamp createTime;
    private Timestamp updateTime;
    private Byte version;
    private Byte dataStatus;

    @Id
    @Column(name = "cate_id")
    public long getCateId() {
        return cateId;
    }

    public void setCateId(long cateId) {
        this.cateId = cateId;
    }

    @Basic
    @Column(name = "cate_icon")
    public String getCateIcon() {
        return cateIcon;
    }

    public void setCateIcon(String cateIcon) {
        this.cateIcon = cateIcon;
    }

    @Basic
    @Column(name = "cate_name")
    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    @Basic
    @Column(name = "sort")
    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Basic
    @Column(name = "status")
    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
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
    public Byte getVersion() {
        return version;
    }

    public void setVersion(Byte version) {
        this.version = version;
    }

    @Basic
    @Column(name = "data_status")
    public Byte getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(Byte dataStatus) {
        this.dataStatus = dataStatus;
    }

    @Override
    public String toString() {
        return "GoodsCateEntity{" +
                "cateId=" + cateId +
                ", cateIcon='" + cateIcon + '\'' +
                ", cateName='" + cateName + '\'' +
                ", sort=" + sort +
                ", status=" + status +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", version=" + version +
                ", dataStatus=" + dataStatus +
                '}';
    }
}
