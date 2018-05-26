package com.zammc.domain.table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @Author : fly
 * @Description :
 * @Date 2018/5/26
 */
@Entity
@Table(name = "dining_table")
@DynamicInsert
@DynamicUpdate
public class DiningTableEntity {

    private long tableId;
    private String tableCode;
    private byte tableStatus;
    private byte dataStatus;
    private Timestamp createTime;
    private Timestamp updateTime;
    private int version;

    public DiningTableEntity() {
    }

    @Id
    @Column(name = "table_id")
    public long getTableId() {
        return tableId;
    }

    public void setTableId(long tableId) {
        this.tableId = tableId;
    }

    @Basic
    @Column(name = "table_code")
    public String getTableCode() {
        return tableCode;
    }

    public void setTableCode(String tableCode) {
        this.tableCode = tableCode;
    }

    @Basic
    @Column(name = "table_status")
    public byte getTableStatus() {
        return tableStatus;
    }

    public void setTableStatus(byte tableStatus) {
        this.tableStatus = tableStatus;
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

    @Override
    public String toString() {
        return "DiningTableEntity{" +
                "tableId=" + tableId +
                ", tableCode='" + tableCode + '\'' +
                ", tableStatus=" + tableStatus +
                ", dataStatus=" + dataStatus +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", version=" + version +
                '}';
    }
}
