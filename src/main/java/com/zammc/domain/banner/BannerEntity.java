package com.zammc.domain.banner;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * banner
 */
@Entity
@Table(name = "banner")
@DynamicInsert
@DynamicUpdate
public class BannerEntity {
    private long bannerId;
    private String bannerName;
    private String bannerUrl;
    private byte bannerStatus;
    private int bannerSort;
    private Timestamp createTime;
    private Timestamp updateTime;
    private int version;
    private byte dataStatus;

    @Id
    @Column(name = "banner_id")
    public long getBannerId() {
        return bannerId;
    }

    public void setBannerId(long bannerId) {
        this.bannerId = bannerId;
    }

    @Basic
    @Column(name = "banner_name")
    public String getBannerName() {
        return bannerName;
    }

    public void setBannerName(String bannerName) {
        this.bannerName = bannerName;
    }

    @Basic
    @Column(name = "banner_url")
    public String getBannerUrl() {
        return bannerUrl;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }

    @Basic
    @Column(name = "banner_status")
    public byte getBannerStatus() {
        return bannerStatus;
    }

    public void setBannerStatus(byte bannerStatus) {
        this.bannerStatus = bannerStatus;
    }

    @Basic
    @Column(name = "banner_sort")
    public int getBannerSort() {
        return bannerSort;
    }

    public void setBannerSort(int bannerSort) {
        this.bannerSort = bannerSort;
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
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
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
