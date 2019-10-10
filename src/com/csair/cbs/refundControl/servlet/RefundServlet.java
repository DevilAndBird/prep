package com.csair.cbs.refundControl.servlet;

import com.csair.cbs.common.domain.PageInfo;
import com.csair.cbs.refundControl.pojo.OrderRefundInfo;
import com.csair.cbs.refundControl.pojo.OrderRefundInfoReq;
import com.csair.cbs.refundControl.pojo.OrderRefundResponse;
import com.csair.cbs.refundControl.pojo.QueryRefundListParam;
import com.csair.cbs.refundControl.service.RefundService;
import com.csair.cbs.refundControl.service.impl.RefundServiceImpl;
import com.csair.cbs.util.BaseServlet;
import com.csair.cbs.util.ServletUtils;

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

    public void selectByPage(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RefundService refundservice = new RefundServiceImpl();
        PageInfo<OrderRefundInfo> pageInfo = refundservice.selectByPage(tranformQuery(request));
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

    private QueryRefundListParam tranformQuery(HttpServletRequest request){
        QueryRefundListParam queryRefundListParam = new QueryRefundListParam();
        queryRefundListParam.setPageNum(ServletUtils.getParameterToInt("pageNum",10,request));
        queryRefundListParam.setPageSize(ServletUtils.getParameterToInt("pageSize",1,request));
        queryRefundListParam.setRefundno(request.getParameter("refundno"));
        queryRefundListParam.setOrderno(request.getParameter("orderno"));
        queryRefundListParam.setStartRefundDate(ServletUtils.getParameterToDate("startRefundDate",request));
        queryRefundListParam.setEndRefundDate(ServletUtils.getParameterToDate("endRefundDate",request));
        queryRefundListParam.setOperator(request.getParameter("operator"));
        queryRefundListParam.setStartRefundMoney(ServletUtils.getParameterToFloat("startRefundMoney",request));
        queryRefundListParam.setEndRefundMoney(ServletUtils.getParameterToFloat("endRefundMoney",request));
        queryRefundListParam.setRefundStatus(request.getParameter("refundStatus"));
        queryRefundListParam.setStartAuditDate(ServletUtils.getParameterToDate("startAuditDate",request));
        queryRefundListParam.setEndAuditDate(ServletUtils.getParameterToDate("endAuditDate",request));
        queryRefundListParam.setSource(request.getParameter("source"));
        return queryRefundListParam;
    }

}
