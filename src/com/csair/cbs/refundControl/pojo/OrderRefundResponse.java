package com.csair.cbs.refundControl.pojo;

import com.csair.cbs.orderControl.pojo.OrderAddress;
import com.csair.cbs.orderControl.pojo.OrderMain;
import com.csair.cbs.orderControl.pojo.OrderPayInfo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * Date:2019年9月26日
 * tangqm
 * DESC: 处理查询退款订单返回结果
 */
@Setter
@Getter
@ToString
public class OrderRefundResponse implements Serializable {
    /* 退款信息 */
    private OrderRefundInfo orderRefundInfo;
    /* 订单地址 */
    private OrderAddress orderAddress;
    /* 订单基本 */
    private OrderMain orderMain;
    /* 订单支付信息 */
    private OrderPayInfo orderPayInfo;

}
