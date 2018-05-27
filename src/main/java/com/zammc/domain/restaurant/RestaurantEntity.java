package com.zammc.domain.restaurant;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 商店基本信息设置
 */
@Entity
@Table(name = "restaurant")
public class RestaurantEntity {
    private long restaurantId;
    private String restaurantName;
    private String restaurantImg;
    private String restaurantCode;
    private Timestamp createTime;
    private Timestamp updateTime;
    private int version;
    private byte dataStatus;
    private String summary;

    @Id
    @Column(name = "restaurant_id")
    public long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(long restaurantId) {
        this.restaurantId = restaurantId;
    }

    @Basic
    @Column(name = "restaurant_name")
    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    @Basic
    @Column(name = "restaurant_img")
    public String getRestaurantImg() {
        return restaurantImg;
    }

    public void setRestaurantImg(String restaurantImg) {
        this.restaurantImg = restaurantImg;
    }

    @Basic
    @Column(name = "restaurant_code")
    public String getRestaurantCode() {
        return restaurantCode;
    }

    public void setRestaurantCode(String restaurantCode) {
        this.restaurantCode = restaurantCode;
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

    @Basic
    @Column(name = "summary")
    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public String toString() {
        return "RestaurantEntity{" +
                "restaurantId=" + restaurantId +
                ", restaurantName='" + restaurantName + '\'' +
                ", restaurantImg='" + restaurantImg + '\'' +
                ", restaurantCode='" + restaurantCode + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", version=" + version +
                ", dataStatus=" + dataStatus +
                ", summary='" + summary + '\'' +
                '}';
    }
}
