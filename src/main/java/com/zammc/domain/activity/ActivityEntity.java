package com.zammc.domain.activity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @description 活动
 * @author: fly
 * @Date: 2018/7/22 下午12:08
 */
@Entity
@Table(name = "activity")
public class ActivityEntity {

    private long activityId;
    private String activityName;
    private Timestamp createTime;
    private Timestamp updateTime;
    private byte status;
    private byte dataStatus;

    public ActivityEntity() {
    }

    @Id
    @Column(name = "activity_id")
    public long getActivityId() {
        return activityId;
    }

    public void setActivityId(long activityId) {
        this.activityId = activityId;
    }

    @Basic
    @Column(name = "activity_name")
    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
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
    @Column(name = "status")
    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    @Basic
    @Column(name = "data_status")
    public byte getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(byte dataStatus) {
        this.dataStatus = dataStatus;
    }

    @Override
    public String toString() {
        return "ActivityEntity{" +
                "activityId=" + activityId +
                ", activityName='" + activityName + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", status=" + status +
                ", dataStatus=" + dataStatus +
                '}';
    }
}
