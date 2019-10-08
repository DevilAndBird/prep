package com.csair.cbs.orderControl.pojo;

import com.csair.cbs.common.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@ToString
public class OrderMain extends BaseEntity<Integer> implements Serializable {
    /* 订单号 */
    private String orderno;
    /* 服務類型*/
    private String serviceType;
    /* 服务商名称*/
    private String providerId;
    /* 供应商名称 */
    private String providerName;
    /* 供应商订单号 */
    private String providerOrderno;
    /* 订单状态：
        待支付：WAITPAY、
        待分配：PREPAID、
        待提取：WAITPICK、
        配送中:DELIVERYING、
        已送达:DELIVERYOVER、
        已完成:COMPLTED、
        已取消:CANCELLED */
    private String status;
    /* 订单状态描述 */
    private String statusDesc;
    /* 总金额*/
    private Float totalMoney;
    /* 实际金额*/
    private Float actualMoney;
    /* 行李数 */
    private Integer num;
    /* 取件时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date takeTime;
    /* 派件时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date sendTime;
    /* 客户姓名*/
    private String name;
    /* 客户手机号*/
    private String mobile;
    /* 客户身份证 */
    private String idno;
    /* 备注*/
    private String notes;
    /* 订单来源 */
    private String source;
    /* 订单来源 */
    private String sourceDesc;

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Float getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Float totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Float getActualMoney() {
        return actualMoney;
    }

    public void setActualMoney(Float actualMoney) {
        this.actualMoney = actualMoney;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Date getTakeTime() {
        return takeTime;
    }

    public void setTakeTime(Date takeTime) {
        this.takeTime = takeTime;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getIdno() {
        return idno;
    }

    public void setIdno(String idno) {
        this.idno = idno;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getProviderOrderno() {
        return providerOrderno;
    }

    public void setProviderOrderno(String providerOrderno) {
        this.providerOrderno = providerOrderno;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSourceDesc() {
        return sourceDesc;
    }

    public void setSourceDesc(String sourceDesc) {
        this.sourceDesc = sourceDesc;
    }
}