package com.csair.cbs.refundControl.pojo;

import com.csair.cbs.common.domain.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@ToString
public class OrderRefundInfo extends BaseEntity<Integer> implements Serializable {
    private String refundno;

    private String orderno;

    private String refundReason;

    private Float refundMoney;

    private String source;

    private String refundType;

    private String payno;

    private String notes;

    private String status;

    private String statusDesc;

    private Date auditTime;

    private String operator;

    private String providerId;

    private String providerName;

    private static final long serialVersionUID = 1L;


}