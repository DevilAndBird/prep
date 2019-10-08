<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ include file="/common/common.jsp"%>
<script type="text/javascript" src="../../common/kindeditor/kindeditor.js"></script>
<script type="text/javascript" src="../../common/Inc/calendar/WdatePicker.js"></script>
<script type="text/javascript" src="../../common/JS/ajax.js"></script>
<script type="text/javascript" src="../../common/CoordiJS/client.js"></script>
<link href="../../css/40066_type5/backstage.css" type="text/css" rel="stylesheet" />
<title>退款单明细</title>
</head>
<script type="text/javascript">
   function updateRefundStatus(status){

       $.ajax({
           url:"RefundServlet?method=updateRefundStatus",
           type:"POST",
           data:JSON.stringify($('refundForm').serializeObject()),
           contentType:"application/json",  //缺失会出现URL编码，无法转成json对象
           success:function(){
               alert("成功");
           }
       });
   }
</script>
<body>
<form action="" name="form1" id="form2" method="post" >
<div class="frame_total" >
  <div class="title">退款单明细&nbsp;&nbsp;&nbsp;</div>
    <table width="100%" border="0" cellpadding="0" cellspacing="0"  >
    <tr>
      <td height="30" colspan="3" align="left" class="supply_title">基础信息</td>
    </tr>

    <tr>
        <input type="hidden" id="refundno" value="${orderRefundInfo.refundno}">
        <td align="right">退款申请单号：</td><td align="left">${orderRefundInfo.refundno}</td>
        <td align="right">退款单状态：</td><td align="left">${orderRefundInfo.statusDesc}</td>
        <td align="right">供应商订单：</td><td align="left">${orderMain.providerOrderno}</td>
    </tr>
    <tr>
        <td align="right">订单号：${orderMain.orderno}</td>
        <td align="center">退款申请人：${orderRefundInfo.operator}</td>
    </tr>
    <tr>
      <td height="30" colspan="2" align="left" class="supply_title">原订单信息</td>
    </tr>
        <tr>
            <td align="right">联系人姓名：${orderMain.name}</td>
            <td align="center">客户手机号：${orderMain.mobile}</td>
        </tr>
        <tr>
            <td align="right">寄件地址：${orderAddress.srcAddress}</td>
            <td align="center">收件地址：${orderAddress.destAddress}</td>
        </tr>
        <tr>
            <td align="center">总价格：${orderPayInfo.actualMoney}</td>
        </tr>
    <tr>
      <td height="30" colspan="2" align="left" class="supply_title">订单原支付信息</td>
    </tr>

    <br />
    <tr>
      <td height="30" colspan="2" align="left" class="supply_title">退款处理方式</td>
    </tr>
    <br />
    <tr>
      <td width="10%" height="30" align="right" class="lh30">退款审核意见：</td>
      <td width="90%" align="left">
        <textarea name="remark" rows="5" class="textarea01"  style="width:95%;" id="remark" ></textarea>
      </td>
    </tr>
    
    <tr >
      <td height="30" colspan="2" align="center" class="lh30" id="functiontd">
	      	  <input  type="button" class="button01" value="审核成功" onclick="updateRefundStatus();" />
		      <input  type="button" class="button01" value="审核失败" onclick="updateRefundStatus();" />
         <img id="loadimg" src="images/loadin.gif" style="display:none;" />
      </td>
    </tr>
</table>
  
</div>
</form>
</body>
</div>
</form>
</body>
</html>
