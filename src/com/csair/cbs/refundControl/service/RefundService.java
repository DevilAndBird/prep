package com.csair.cbs.refundControl.service;

import com.csair.cbs.common.domain.PageInfo;
import com.csair.cbs.refundControl.pojo.OrderRefundInfo;
import com.csair.cbs.refundControl.pojo.OrderRefundResponse;
import com.csair.cbs.refundControl.pojo.QueryRefundListParam;
import org.springframework.stereotype.Service;

import java.io.IOException;
public interface RefundService {

     PageInfo<OrderRefundInfo> selectByPage(QueryRefundListParam queryRefundListParam) throws IOException;

     OrderRefundResponse getRefundDetailByRefundno(QueryRefundListParam queryRefundListParam) throws IOException;
}
