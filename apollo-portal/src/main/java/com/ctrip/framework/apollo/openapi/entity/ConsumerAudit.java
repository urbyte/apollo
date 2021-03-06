package com.ctrip.framework.apollo.openapi.entity;

import com.google.common.base.MoreObjects;

import javax.persistence.*;
import java.util.Date;

/**
 * Consumer 操作审计日志
 *
 * @author Jason Song(song_s@ctrip.com)
 */
@Entity
@Table(name = "ConsumerAudit")
public class ConsumerAudit {

    /**
     * 日志编号，自增
     */
    @Id
    @GeneratedValue
    @Column(name = "Id")
    private long id;
    /**
     * 第三方应用编号，使用 {@link Consumer#id}
     */
    @Column(name = "ConsumerId", nullable = false)
    private long consumerId;
    /**
     * 请求 URI
     */
    @Column(name = "Uri", nullable = false)
    private String uri;
    /**
     * 请求 Method
     */
    @Column(name = "Method", nullable = false)
    private String method;
    /**
     * 数据创建时间
     */
    @Column(name = "DataChange_CreatedTime")
    private Date dataChangeCreatedTime;
    /**
     * 数据最后更新时间
     */
    @Column(name = "DataChange_LastTime")
    private Date dataChangeLastModifiedTime;

    @PrePersist
    protected void prePersist() {
        if (this.dataChangeCreatedTime == null) {
            this.dataChangeCreatedTime = new Date();
        }
        if (this.dataChangeLastModifiedTime == null) {
            dataChangeLastModifiedTime = this.dataChangeCreatedTime;
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(long consumerId) {
        this.consumerId = consumerId;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Date getDataChangeCreatedTime() {
        return dataChangeCreatedTime;
    }

    public void setDataChangeCreatedTime(Date dataChangeCreatedTime) {
        this.dataChangeCreatedTime = dataChangeCreatedTime;
    }

    public Date getDataChangeLastModifiedTime() {
        return dataChangeLastModifiedTime;
    }

    public void setDataChangeLastModifiedTime(Date dataChangeLastModifiedTime) {
        this.dataChangeLastModifiedTime = dataChangeLastModifiedTime;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .omitNullValues()
                .add("id", id)
                .add("consumerId", consumerId)
                .add("uri", uri)
                .add("method", method)
                .add("dataChangeCreatedTime", dataChangeCreatedTime)
                .add("dataChangeLastModifiedTime", dataChangeLastModifiedTime)
                .toString();
    }
}
