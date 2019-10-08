package com.csair.cbs.orderControl.pojo;

import com.csair.cbs.common.domain.BaseEntity;

import java.io.Serializable;

public class OrderAddress extends BaseEntity<Integer> implements Serializable {
    /* 订单号 */
    private String orderno;
    /*  */
    private Integer srcAddressId;
    /* 出发地类型 */
    private String srcAddrType;
    /* 出发地地表性建筑 */
    private String srcLandMark;
    /* 出发地省份 */
    private String srcProvId;
    /* 出发地城市 */
    private String srcCityId;
    /* 出发地省份名称 */
    private String srcProvName;
    /* 出发地城市名称 */
    private String srcCityName;
    /* 出发地地址详情 */
    private String srcAddress;
    private Integer destAddressId;
    /* 目的地类型 */
    private String destAddrType;
    /* 目的地地表性建筑 */
    private String destLandMark;
    /* 目的地省份 */
    private String destProvId;
    /* 目的地城市 */
    private String destCityId;
    /* 目的地省份名称 */
    private String destProvName;
    /* 目的地城市名称 */
    private String destCityName;
    /* 目的地地址详情 */
    private String destAddress;
    /* 出发地地址类型 */
    private String srcAddrTypeDesc;
    /* 目的地地址类型 */
    private String destAddrTypeDesc;

    public String getSrcAddrTypeDesc() {
        return srcAddrTypeDesc;
    }

    public void setSrcAddrTypeDesc(String srcAddrTypeDesc) {
        this.srcAddrTypeDesc = srcAddrTypeDesc;
    }

    public String getDestAddrTypeDesc() {
        return destAddrTypeDesc;
    }

    public void setDestAddrTypeDesc(String destAddrTypeDesc) {
        this.destAddrTypeDesc = destAddrTypeDesc;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    private static final long serialVersionUID = 1L;

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno == null ? null : orderno.trim();
    }

    public Integer getSrcAddressId() {
        return srcAddressId;
    }

    public void setSrcAddressId(Integer srcAddressId) {
        this.srcAddressId = srcAddressId;
    }

    public String getSrcAddrType() {
        return srcAddrType;
    }

    public void setSrcAddrType(String srcAddrType) {
        this.srcAddrType = srcAddrType == null ? null : srcAddrType.trim();
    }

    public String getSrcLandMark() {
        return srcLandMark;
    }

    public void setSrcLandMark(String srcLandMark) {
        this.srcLandMark = srcLandMark == null ? null : srcLandMark.trim();
    }

    public String getSrcProvId() {
        return srcProvId;
    }

    public void setSrcProvId(String srcProvId) {
        this.srcProvId = srcProvId == null ? null : srcProvId.trim();
    }

    public String getSrcCityId() {
        return srcCityId;
    }

    public void setSrcCityId(String srcCityId) {
        this.srcCityId = srcCityId == null ? null : srcCityId.trim();
    }

    public String getSrcProvName() {
        return srcProvName;
    }

    public void setSrcProvName(String srcProvName) {
        this.srcProvName = srcProvName == null ? null : srcProvName.trim();
    }

    public String getSrcCityName() {
        return srcCityName;
    }

    public void setSrcCityName(String srcCityName) {
        this.srcCityName = srcCityName == null ? null : srcCityName.trim();
    }

    public String getSrcAddress() {
        return srcAddress;
    }

    public void setSrcAddress(String srcAddress) {
        this.srcAddress = srcAddress == null ? null : srcAddress.trim();
    }

    public Integer getDestAddressId() {
        return destAddressId;
    }

    public void setDestAddressId(Integer destAddressId) {
        this.destAddressId = destAddressId;
    }

    public String getDestAddrType() {
        return destAddrType;
    }

    public void setDestAddrType(String destAddrType) {
        this.destAddrType = destAddrType == null ? null : destAddrType.trim();
    }

    public String getDestLandMark() {
        return destLandMark;
    }

    public void setDestLandMark(String destLandMark) {
        this.destLandMark = destLandMark == null ? null : destLandMark.trim();
    }

    public String getDestProvId() {
        return destProvId;
    }

    public void setDestProvId(String destProvId) {
        this.destProvId = destProvId == null ? null : destProvId.trim();
    }

    public String getDestCityId() {
        return destCityId;
    }

    public void setDestCityId(String destCityId) {
        this.destCityId = destCityId == null ? null : destCityId.trim();
    }

    public String getDestProvName() {
        return destProvName;
    }

    public void setDestProvName(String destProvName) {
        this.destProvName = destProvName == null ? null : destProvName.trim();
    }

    public String getDestCityName() {
        return destCityName;
    }

    public void setDestCityName(String destCityName) {
        this.destCityName = destCityName == null ? null : destCityName.trim();
    }

    public String getDestAddress() {
        return destAddress;
    }

    public void setDestAddress(String destAddress) {
        this.destAddress = destAddress == null ? null : destAddress.trim();
    }
}