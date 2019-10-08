package com.csair.cbs.refundControl.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;


/**
 * tangqm
 * 退款查询参数
 */
@Setter
@Getter
@ToString
public class QueryRefundListParam implements Serializable {
    private static final long serialVersionUID = -4970582606959339099L;
    //当前页
    private int pageNum;
    //每页的数量
    private int pageSize;
    //总记录数
    private long total;
    //总页数
    private int pages;
    //订单号
    private String orderno;
    // 退款单号
    private String refundno;
    // 退款申请日期起
    private Date startRefundDate;
    // 退款申请日期终
    private Date endRefundDate;
    // 退款申请人
    private String operator;
    // 退款金额起
    private Float startRefundMoney;
    // 退款金额起
    private Float endRefundMoney;
    //退款状态
    private String refundStatus;
    //审核日期起
    private String startAuditDate;
    //审核日期终
    private String endAuditDate;
    //订单来源
    private String source;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

}
