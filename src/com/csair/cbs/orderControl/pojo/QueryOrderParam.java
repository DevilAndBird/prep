package com.csair.cbs.orderControl.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Setter
@Getter
@ToString
public class QueryOrderParam implements Serializable {
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
    /* 供应商id */
    private Integer providerId;
    /* 订单来源*/
    private String source;
    /* 订单状态 */
    private String status;
    /* 支付状态*/
    private String payStatus;
    /* 寄件城市 */
    private String srcCity;
    //收件人姓名
    private String name;
    //收件人电话
    private String mobile;
    //供应商订单号
    private String providerOrderno;
    //订单生成开始时间
    private String createTimeBegin;
    //订单生成结束时间
    private String createTimeEnd;
    // 寄件时间
    private String takeTime;
    // 取件时间
    private String sendTime;

}
