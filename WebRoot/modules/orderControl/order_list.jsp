<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<title>行李到家订单查询</title>
    <%@ include file="/common/common.jsp"%>
</head>



<body>
  <form action="OrderServlet?method=selectOrderList" id="form1" target="showtable" method="post"  >
    <div class="frame_total">
      <div class="title">行李到家订单查询</div>
      <div class="title_check">查询条件</div>

      <table width="100%" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td height="30" align="right">订单号：</td>
          <td align="left">
            <input name="orderno" id="orderno" type="text" value="${queryOrderParam.orderno}">
          </td>

          <td align="right">供应商：</td>
          <td align="left">
            <select name="providerId" id="providerId" class="select02" >
              <option value="" <c:if test="${queryOrderParam.providerId == ''}">selected</c:if>>全部</option>
              <option value="1" <c:if test="${queryOrderParam.providerId == 1}">selected</c:if>>包给我</option>
            </select>
          </td>

          <td height="30" align="right">供应商订单号：</td>
          <td align="left">
            <input name="providerOrderno" id="providerOrderno" type="text" value="${queryOrderParam.providerOrderno}">
          </td>
        </tr>

        <tr>
          <td align="right">支付状态：</td>
          <td align="left">
            <select name="payStatus" id="payStatus" class="select02"  >
              <option value="" <c:if test="${queryOrderParam.payStatus == ''}">selected</c:if>>全部</option>
              <option value="PAYSUCCESS"  <c:if test="${queryOrderParam.payStatus == 'PAYSUCCESS'}">selected</c:if>>支付成功</option>
              <option value="WAITPAY" <c:if test="${queryOrderParam.payStatus == 'WAITPAY'}">selected</c:if>>待支付</option>
              <option value="PAYFAIL" <c:if test="${queryOrderParam.payStatus == 'PAYFAIL'}">selected</c:if>>支付失败</option>
            </select>
          </td>

          <td align="right">寄件城市：</td>
          <td align="left">
            <select name="srcCity" id="srcCity" class="select02"  >
              <option value="" selected>全部</option>
              <option value="310000">上海</option>
            </select>
          </td>
        </tr>

        <tr>
          <td height="30" align="right">联系人姓名：</td>
          <td align="left">
            <input name="name" type="text" id="name" value="${queryOrderParam.name}">
          </td>

          <td height="30" align="right">收件时间：</td>
          <td align="left">
            <input name="sendTime" id="sendTime" type="text" class="input04" onFocus="WdatePicker({doubleCalendar:true,dateFmt:'yyyy-MM-dd',skin:'whyGreen'})" value="${queryOrderParam.sendTime}">
            <img src="/images/40066_type5/backstage/1102.gif" width="14" height="16"   align="absmiddle" style="cursor:pointer;">
          </td>
        </tr>

        <tr>
          <td height="30" align="right">寄件时间：</td>
          <td align="left">
            <input name="takeTime" id='takeTime' type="text" class="input04" onFocus="WdatePicker({doubleCalendar:true,dateFmt:'yyyy-MM-dd',skin:'whyGreen'})" value="${queryOrderParam.takeTime}">
            <img src="/images/40066_type5/backstage/1102.gif" width="14" height="16"   align="absmiddle" style="cursor:pointer;">
          </td>

          <td height="30" align="right">订单生成日期：</td>
          <td align="left">
            <input name="createTimeBegin" id="createTimeBegin" type="text" class="input04" onFocus="WdatePicker({doubleCalendar:true,dateFmt:'yyyy-MM-dd',skin:'whyGreen'})" value="${queryOrderParam.createTimeBegin}">
            <img src="/images/40066_type5/backstage/1102.gif" width="14" height="16"   align="absmiddle" style="cursor:pointer;"> 至
            <input name="createTimeEnd" id="createTimeEnd" type="text" class="input04" onFocus="WdatePicker({doubleCalendar:true,dateFmt:'yyyy-MM-dd',skin:'whyGreen'})" value="${queryOrderParam.createTimeEnd}">
            <img src="/images/40066_type5/backstage/1102.gif" width="14" height="16"   align="absmiddle" style="cursor:pointer;">
          </td>
        </tr>

        <tr>
          <td align="right">订单来源：</td>
          <td align="left">
            <select name="source" id="source" class="select02"  >
              <option value="" <c:if test="${queryOrderParam.source == ''}">selected</c:if>>全部</option>
              <option value="APP" <c:if test="${queryOrderParam.source == 'APP'}">selected</c:if>>APP</option>
              <option value="WXP" <c:if test="${queryOrderParam.source == 'WXP'}">selected</c:if>>微信小程序</option>
            </select>
          </td>

          <td align="right">订单状态：</td>
          <td align="left">
            <select name="status" id="status" class="select02"  >
              <option value="" <c:if test="${queryOrderParam.status == ''}">selected</c:if>>全部</option>
              <option value="WAITPAY" <c:if test="${queryOrderParam.status == 'WAITPAY'}">selected</c:if>>待支付</option>
              <option value="WAITPICK" <c:if test="${queryOrderParam.status == 'WAITPICK'}">selected</c:if>>待提取</option>
              <option value="PREPAID" <c:if test="${queryOrderParam.status == 'PREPAID'}">selected</c:if>>待提取</option>
              <option value="DELIVERYOVER" <c:if test="${queryOrderParam.status == 'DELIVERYOVER'}">selected</c:if>>已送达</option>
              <option value="DELIVERYING" <c:if test="${queryOrderParam.status == 'DELIVERYING'}">selected</c:if>>配送中</option>
              <option value="COMPLETED" <c:if test="${queryOrderParam.status == 'COMPLETED'}">selected</c:if>>已完成</option>
              <option value="CANCELLED" <c:if test="${queryOrderParam.status == 'CANCELLED'}">selected</c:if>>已取消</option>
            </select>
          </td>
        </tr>

        <tr>
        </tr>

        <tr>
          <td height="50" colspan="6" align="center">
          <input type="submit" class="button01" value="查　询"/>
          <input type="button" class="button01 resetbut" value="重  置" />
          </td>
        </tr>
      </table>

      <br />

        <div class="frame_total">
            <div class="title_check">查询结果</div>

            <table width="100%" border="0" cellpadding="0" cellspacing="0">
                <tr>
                    <td height="25" align="center" class="title_ii_m">序号</td>
                    <td align="center" class="title_ii_m">订单号</td>
                    <td align="center" class="title_ii_m">供应商订单号</td>
                    <td align="center" class="title_ii_m">联系人姓名</td>
                    <td align="center" class="title_ii_m">寄件时间 </td>
                    <td align="center" class="title_ii_m">取件时间 </td>
                    <td align="center" class="title_ii_m">供应商 </td>
                    <td align="center" class="title_ii_m">订单生成时间 </td>
                    <td align="center" class="title_ii_m">订单金额</td>
                    <td align="center" class="title_ii_m">订单状态</td>
                    <td align="center" class="title_ii_m">订单来源 </td>
                </tr>

                <input type="hidden" id="pageSize" value="${pageInfo.pages}">
                <input type="hidden" id="'pageNum" name="pageNum" >

                <!-- 开始循环 -->
                <c:choose>
                    <c:when test="${not empty pageInfo.list}">
                        <c:forEach items="${pageInfo.list}" var="obj" varStatus="vs">
                            <tr onMouseOver="this.style.backgroundColor='#e4f3ff'" onMouseOut="trmoveout(this);" onClick="trclick(this);">
                                <td height="30" class="border_b" align="center">${vs.index+1}</td>
                                <td class="border_b" align="center">
                                    <a href="#" target="_blank" class="color_blue">${obj.orderno}</a>
                                </td>
                                <td class="border_b" align="center">${obj.providerOrderno}</td>
                                <td class="border_b" align="center">${obj.name}</td>
                                <td class="border_b" align="center">${obj.takeTime}&nbsp;</td>
                                <td class="border_b" align="center">${obj.sendTime}&nbsp;</td>
                                <td class="border_b" align="center">${obj.providerName}</td>
                                <td class="border_b" align="center">${obj.createTime}</td>
                                <td class="border_b" align="center">${obj.actualMoney}</td>
                                <td class="border_b" align="center">${obj.statusDesc}</td>
                                <td class="border_b" align="center">${obj.sourceDesc}</td>
                            </tr>
                        </c:forEach>

                        <table border="0" cellpadding="0" cellspacing="0" width="100%" class="color_gray">
                            <tr>
                                <td height="35"  align="right" >共${pageInfo.total}条记录  第${pageInfo.pageNum}页
                                    <a href="javascript:void(0)" onclick="getData(1);" >首 页</a> |
                                    <a href="javascript:void(0)" onclick="getData('subtract');" >上一页</a> |
                                    <a href="javascript:void(0)" onclick="getData('add');" >下一页</a> |
                                    <a href="javascript:void(0)" onclick="getData('end');" >末页</a>
                                    跳转<select id="choicePage" name="pages" >
                                        <c:forEach begin="1" end="${pageInfo.pages}" var="idx">
                                            <c:choose>
                                                <c:when test="${idx == pageInfo.pageNum}">
                                                    <option value="${idx}" selected="selected" >${idx}</option>
                                                </c:when>
                                                <c:otherwise>
                                                    <option value="${idx}" >${idx}</option>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>
                                    </select>页&nbsp;
                                </td>
                            </tr>
                        </table>

                    </c:when>
                    <c:otherwise>
                        <tr class="main_info">
                            <td colspan="100" class="center" style="display: flex;align-items: center;justify-content: center;">没有相关数据</td>
                        </tr>
                    </c:otherwise>
                </c:choose>

            </table>


        </div>

    </div>
  </form>

  <script type="text/javascript">

      var _pageNum = '1';
      function getData(type){
          var pageCount = $("#pageSize").val();

          if('add' == type) {
            if(_pageNum + 1 > pageCount) {
                alert("已经是最后一页了");
                return false;
            }

              _pageNum = _pageNum + 1
          }else if('end' == type) {
              _pageNum = pageCount
          } else {
              if(_pageNum - 1 <=  0) {
                  alert("已经是第一页了");
                  return false
              }

              _pageNum = _pageNum - 1
          }



          var form1 = document.getElementById("form1");

          $('#pageNum').val(_pageNum);
          form1.submit();
      }

      var clickedtr = null;
      function trclick(obj){
          if(clickedtr!=null){
              clickedtr.style.backgroundColor="";
          }
          obj.style.backgroundColor="#e4f3ff";
          clickedtr = obj;
      }

      function trmoveout(obj){
          if(clickedtr!=obj){
              obj.style.backgroundColor="";
          }
      }

      // 重置
      $('.resetbut').click(function() {
          $('#orderno').val('');
          $('#name').val('');
          $('#providerOrderno').val('');
          $('#createTimeBegin').val('');
          $('#createTimeEnd').val('');
          $('#takeTime').val('');
          $('#sendTime').val('');
          $("#providerId").find("option[value='']").attr("selected",true);
          $("#source").find("option[value='']").attr("selected",true);
          $("#source").find("option[value='']").attr("selected",true);
          $("#status").find("option[value='']").attr("selected",true);
          $("#payStatus").find("option[value='']").attr("selected",true);
          $("#srcCity").find("option[value='']").attr("selected",true);
      });

  </script>
</body>
</html>
