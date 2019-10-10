<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>退款单查询</title>
<%@ include file="/common/common.jsp"%>
</head>
<script type="text/javascript">
  function getData(pageNum){
      var pages = $("#pages").val();
      var pageSize = $("#choicePage").find("option:selected").val();
      if(pageNum > pages){
          alert("已经是最后一页了");
          return false;
      }
      if(pageNum<=0){
          alert("已经是第一页了");
          return false;
      }
      $("#pageNem").val(pageNum);
      $("#pageSize").val(pageSize);
      var form = document.getElementById("refundForm");
      form.submit();
  }
  // 重置
  $('.reset').click(function() {
      $('#orderno').val('');
      $('#refundno').val('');
      $('#startRefundDate').val('');
      $('#endRefundDate').val('');
      $('#operator').val('');
      $('#startRefundMoney').val('');
      $('#endRefundMoney').val('');
      $('#startAuditDate').val('');
      $('#endAuditDate').val('');
      $("#source").find("option[value='']").attr("selected",true);
      $("#refundStatus").find("option[value='']").attr("selected",true);
  });

</script>
<body>
<form action="RefundServlet?method=selectByPage" id="refundForm" method="post"  >
<div class="frame_total">
  <div class="title">退款单查询</div>
  <div class="title_check">查询条件</div>
  <table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tr>
      <td align="right">退款单号</td>
      <td align="left">
        <input type="text" value="" id="refundno" name="refundno" />
      </td>
      <td align="right">原订单号</td>
      <td align="left">
        <input type="text" value="" id="orderno" name="orderno"/>
      </td>
    </tr>
    <tr>
      <td align="right">申请日期</td>
      <td align="left">
        <input name="startRefundDate" type="text" class="input04" onFocus="WdatePicker({doubleCalendar:true,dateFmt:'yyyy-MM-dd',skin:'whyGreen'})" >
        <img src="/images/40066_type5/backstage/1102.gif" width="14" height="16"   align="absmiddle" style="cursor:pointer;"> 至
        <input name="endRefundDate" type="text" class="input04" onFocus="WdatePicker({doubleCalendar:true,dateFmt:'yyyy-MM-dd',skin:'whyGreen'})">
        <img src="/images/40066_type5/backstage/1102.gif" width="14" height="16"   align="absmiddle" style="cursor:pointer;">      </td>
      <td align="right">退款申请人</td>
      <td align="left">
        <input type="text" value="" id="operator" name="operator"/>
      </td>
    </tr>
    <tr>
      <td align="right">退款金额</td>
      <td align="left">
        <input name="startRefundMoney" type="text" class="input04">
         至
        <input name="endRefundMoney" type="text" class="input04"></td>
      <td height="30" align="right">退款单状态：</td>
      <td align="left">
        <select id="refundStatus" name="refundStatus" class="select02">
          <option value="" selected >全部</option>
          <option value="1">其他</option>
        </select>
      </td>
    </tr>
    <tr>
      <td align="right">审核日期</td>
      <td align="left">
        <input name="startAuditDate" type="text" class="input04" onFocus="WdatePicker({doubleCalendar:true,dateFmt:'yyyy-MM-dd',skin:'whyGreen'})" >
        <img src="/images/40066_type5/backstage/1102.gif" width="14" height="16"   align="absmiddle" style="cursor:pointer;"> 至
        <input name="endAuditDate" type="text" class="input04" onFocus="WdatePicker({doubleCalendar:true,dateFmt:'yyyy-MM-dd',skin:'whyGreen'})">
        <img src="/images/40066_type5/backstage/1102.gif" width="14" height="16"   align="absmiddle" style="cursor:pointer;">      </td>
      <td height="30" align="right">订单来源：</td>
      <td align="left">
        <select id="source" name="source" class="select02">
          <option value="" selected >全部</option>
          <option value="1">其他</option>
        </select>
      </td>
    </tr>
    <tr>
      <td height="50" colspan="6" align="center">
      <input type="submit" class="button01" value="查  询"/>
      <input type="reset" class="button01" id="resetbut" value="重  置" />
      <input type="reset" class="button01" value="报表下载" />
      </td>
    </tr>
  </table>
  <table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tr>
      <td height="25" class="title_ii_m"></td>
      <td align="center" class="title_ii_m">序号</td>
      <td align="center" class="title_ii_m">退款单号</td>
      <td align="center" class="title_ii_m">原订单号</td>
      <td align="center" class="title_ii_m">供应商</td>
      <td align="center" class="title_ii_m">申请时间</td>
      <td align="center" class="title_ii_m">退款金额</td>
      <td align="center" class="title_ii_m">退款单状态</td>
    </tr>
  <c:choose>
      <c:when test="${not empty pageInfo}">
        <c:forEach items="${pageInfo.list}" var="ori"
                   varStatus="vs">
          <tr onMouseOver="this.style.backgroundColor='#e4f3ff'">
            <td height="30" class="border_b">&nbsp; </td>
            <td align="center" class="border_b">${vs.index+1}</td>
            <td class="border_b" align="center">
              <a href="RefundServlet?method=toRefundDetailPage&refundno=${ori.refundno}&orderno=${ori.orderno}" target="_blank" class="color_blue">${ori.refundno}</a>
            </td>
            <td class="border_b" align="center">
              <a href="#" target="_blank" class="color_blue">${ori.orderno}</a>
            </td>
            <td class="border_b" align="center">${ori.providerName}&nbsp;</td>
            <td class="border_b" align="center">${ori.createTime}&nbsp;</td>
            <td class="border_b" align="center">${ori.refundMoney}&nbsp;</td>
            <td class="border_b" align="center">${ori.statusDesc}&nbsp;</td>
            </td>
          </tr>
        </c:forEach>
        <tr>
          <td height="35">
            <input type="hidden" id="pages" name="pages" value="${pageInfo.pages}">
            <input type="hidden" id="pageNum" name="pageNum" value="${pageInfo.pageNum}">
            <input type="hidden" id="pageSize" name="pageSize" value="${pageInfo.pageSize}">
          </td>
          <td height="35"  align="right" >共${pageInfo.total}条记录  第${pageInfo.pageNum}页 / 共${pageInfo.pages}页
            <a href="javascript:void(0)" onclick="getData(1);" >首 页</a> |
            <a href="javascript:void(0)" onclick="getData(${pageInfo.pageNum}-1;" >上一页</a> |
            <a href="javascript:void(0)" onclick="getData(${pageInfo.pageNum}+1);" >下一页</a> |
            <a href="javascript:void(0)" onclick="getData(${pageInfo.pages});" >末 页</a>   跳转
            <select id="choicePage"><option value="1" selected="selected" >10</option></select>页&nbsp;
          </td>
        </tr>
      </c:when>
      <c:otherwise>
        <tr class="main_info">
          <td colspan="100" class="center">没有相关数据</td>
        </tr>
      </c:otherwise>
    </c:choose>
  </table>
  <br />
</div>
</form>
</body>
</html>
