package com.csair.cbs.orderControl.servlet;

import com.csair.cbs.common.domain.CommonVar;
import com.csair.cbs.common.domain.PageInfo;
import com.csair.cbs.orderControl.pojo.OrderMain;
import com.csair.cbs.orderControl.pojo.QueryOrderParam;
import com.csair.cbs.util.BaseServlet;
import com.csair.cbs.util.HttpClientUtil;
import com.csair.cbs.util.JsonParser;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class OrderServlet extends BaseServlet {

    private void selectOrderList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            QueryOrderParam queryOrderParam = new QueryOrderParam();
            queryOrderParam.setOrderno(request.getParameter("orderno"));
            queryOrderParam.setProviderId(StringUtils.isNotBlank(request.getParameter("providerId"))? Integer.valueOf(request.getParameter("providerId")) : null);
            queryOrderParam.setProviderOrderno(request.getParameter("providerOrderno"));
            queryOrderParam.setPayStatus(request.getParameter("payStatus"));
            queryOrderParam.setStatus(request.getParameter("status"));
            queryOrderParam.setSrcCity(request.getParameter("srcCity"));
            queryOrderParam.setName(request.getParameter("name"));
            queryOrderParam.setSendTime(request.getParameter("sendTime"));
            queryOrderParam.setTakeTime(request.getParameter("takeTime"));
            queryOrderParam.setCreateTimeBegin(request.getParameter("createTimeBegin"));
            queryOrderParam.setCreateTimeEnd(request.getParameter("createTimeEnd"));
            queryOrderParam.setPageNum(StringUtils.isNotBlank(request.getParameter("pageNum"))? Integer.valueOf(request.getParameter("pageNum")) : 1);
            queryOrderParam.setPageSize(10);
            String requestBody = JsonParser.toJsonForTouch(queryOrderParam);
            System.out.println(requestBody);
            String res = HttpClientUtil.doPostJson(CommonVar.POST_URL+"/api/ordermain/selectByPage",requestBody);
            System.out.println(res);
            PageInfo<OrderMain> pageInfo = JsonParser.fromJson(res, PageInfo.class);
            HttpSession session = request.getSession();
            session.setAttribute("queryOrderParam", queryOrderParam);
            session.setAttribute("pageInfo", pageInfo);
            request.getRequestDispatcher("/modules/orderControl/order_list.jsp").include(request, response);
        } catch(Exception e) {

        }
    }

}
