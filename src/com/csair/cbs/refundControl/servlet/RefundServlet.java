package com.csair.cbs.refundControl.servlet;

import com.csair.cbs.common.domain.PageInfo;
import com.csair.cbs.refundControl.pojo.OrderRefundInfo;
import com.csair.cbs.refundControl.pojo.OrderRefundInfoReq;
import com.csair.cbs.refundControl.pojo.OrderRefundResponse;
import com.csair.cbs.refundControl.pojo.QueryRefundListParam;
import com.csair.cbs.refundControl.service.RefundService;
import com.csair.cbs.refundControl.service.impl.RefundServiceImpl;
import com.csair.cbs.util.BaseServlet;
import com.csair.cbs.util.JsonParser;
import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class RefundServlet extends BaseServlet {

    public void toRefundPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RefundService refundservice = new RefundServiceImpl();
        QueryRefundListParam queryRefundListParam = new QueryRefundListParam();
        queryRefundListParam.setPageNum(1);
        queryRefundListParam.setPageSize(10);
        PageInfo<OrderRefundInfo> pageInfo = refundservice.selectByPage(queryRefundListParam);
        HttpSession session = request.getSession();
        session.setAttribute("pageInfo",pageInfo);
        request.getRequestDispatcher("/modules/refundControl/refund_list.jsp").include(request, response);
    }

    public void toRefundDetailPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RefundService refundservice = new RefundServiceImpl();
        QueryRefundListParam queryRefundListParam = new QueryRefundListParam();
        String refundno = request.getParameter("refundno");
        String orderno = request.getParameter("orderno");
        queryRefundListParam.setRefundno(refundno);
        queryRefundListParam.setOrderno(orderno);
        OrderRefundResponse orderRefundResponse = refundservice.getRefundDetailByRefundno(queryRefundListParam);
        HttpSession session = request.getSession();
        session.setAttribute("orderPayInfo",orderRefundResponse.getOrderPayInfo());
        session.setAttribute("orderAddress",orderRefundResponse.getOrderAddress());
        session.setAttribute("orderRefundInfo",orderRefundResponse.getOrderRefundInfo());
        session.setAttribute("orderMain",orderRefundResponse.getOrderMain());
        request.getRequestDispatcher("/modules/refundControl/refund_detial.jsp").include(request, response);
    }

    public void selectByPage(HttpServletRequest request, HttpServletResponse response,@RequestBody String jsonObj) throws IOException, ServletException {
        RefundService refundservice = new RefundServiceImpl();
        QueryRefundListParam queryRefundListParam = JsonParser.fromJson(jsonObj, QueryRefundListParam.class);
        PageInfo<OrderRefundInfo> pageInfo = refundservice.selectByPage(queryRefundListParam);
        HttpSession session = request.getSession();
        session.setAttribute("pageInfo",pageInfo);
        request.getRequestDispatcher("/modules/refundControl/refund_list.jsp").include(request, response);
    }

    public void updateRefundStatus(HttpServletRequest request, HttpServletResponse response){
        RefundService refundservice = new RefundServiceImpl();
        OrderRefundInfoReq qrderRefundInfoReq = new OrderRefundInfoReq();
        String refundno = request.getParameter("refundno");
        String status = request.getParameter("status");
        qrderRefundInfoReq.setRefundno(refundno);
        qrderRefundInfoReq.setStutas(status);

    }

}
