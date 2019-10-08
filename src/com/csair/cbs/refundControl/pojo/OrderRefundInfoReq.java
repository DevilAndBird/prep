package com.csair.cbs.refundControl.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.io.Serializable;

@Getter
@Setter
@ToString
public class OrderRefundInfoReq implements Serializable {

	private String refundno;

	private String orderno;

	private String refundReason;

	private String refundMoney;

	private String payno;

	private String notes;

	private String stutas;

}
