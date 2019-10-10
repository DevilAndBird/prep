package com.csair.cbs.refundControl.service.impl;

import com.csair.cbs.common.domain.CommonVar;
import com.csair.cbs.common.domain.PageInfo;
import com.csair.cbs.refundControl.pojo.OrderRefundInfo;
import com.csair.cbs.refundControl.pojo.OrderRefundResponse;
import com.csair.cbs.refundControl.pojo.QueryRefundListParam;
import com.csair.cbs.refundControl.service.RefundService;
import com.csair.cbs.util.HttpClientUtil;
import com.csair.cbs.util.JsonParser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
@Service
public class RefundServiceImpl implements RefundService {
    @Override
    public PageInfo<OrderRefundInfo> selectByPage(QueryRefundListParam queryRefundListParam) throws IOException {
        String requestBody = JsonParser.toJsonForTouch(queryRefundListParam);
        String res = HttpClientUtil.doPostJson(CommonVar.POST_URL+"api/orderrefundinfo/getRefundListByParam",requestBody);
        PageInfo<OrderRefundInfo> pageInfo = null;
        if(StringUtils.isNotEmpty(res)){
            pageInfo = JsonParser.fromJson(res, PageInfo.class);
        }

        return pageInfo;
    }

    @Override
    public OrderRefundResponse getRefundDetailByRefundno(QueryRefundListParam queryRefundListParam) throws IOException {
        String requestBody = JsonParser.toJsonForTouch(queryRefundListParam);
        String res = HttpClientUtil.doPostJson(CommonVar.POST_URL+"api/orderrefundinfo/getDetailByRefundno",requestBody);
        OrderRefundResponse orderRefundResponse = JsonParser.fromJson(res, OrderRefundResponse.class);
        return orderRefundResponse;
    }
}
