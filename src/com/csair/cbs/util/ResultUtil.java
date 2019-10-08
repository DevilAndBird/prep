package com.csair.cbs.util;

import com.csair.cbs.common.domain.CommonVar;
import com.csair.cbs.common.domain.ResultBean;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: tangan
 * @Date: 2018/6/11 19:28
 * @Description:
 */
public class ResultUtil
{
    private static final Logger LOGGER = LoggerFactory.getLogger(ResultUtil.class);
    public static ResultBean success(Object data)
    {
        ResultBean result=new ResultBean();
        result.setResultCode(CommonVar.SUCCESS_CODE);
        result.setResultMessage("操作成功");
        result.setData(data);
        return result;
    }
    /**
     * 构造异常返回
     * @param message 提示语
     * @param interfaceCode 接口编码
     * @param errorCode 错误码
     * @param lang 国际化
     * @return
     */
    public static ResultBean fail(String message, String interfaceCode, String errorCode, String lang){
        ResultBean result=new ResultBean();
        result.setResultCode(interfaceCode+errorCode);
        result.setResultMessage(i18nString(message, lang));
        result.setData(null);
        return result;
    }
    /**
     * 构造异常返回
     * @param message 提示语
     * @param interfaceCode 接口编码
     * @param errorCode 错误码
     * @return
     */
    public static ResultBean fail(String message, String interfaceCode, String errorCode){
        ResultBean result=new ResultBean();
        result.setResultCode(getErrorCode(interfaceCode, errorCode));
        result.setResultMessage(message);
        result.setData(null);
        return result;
    }
    public static ResultBean fail(String message, String errorCode){
        ResultBean result=new ResultBean();
        result.setResultCode(errorCode);
        result.setResultMessage(message);
        result.setData(null);
        return result;
    }
    public static String getMsgJson(ResultBean resultBean) throws IOException {
        if(!CommonVar.SUCCESS_CODE.equals(resultBean.getResultCode())){
            return ResultUtil.getErrorMsgJson(resultBean);
        }

        if (resultBean.getData() instanceof String) {
            return resultBean.getData().toString();
        }

        return JsonParser.toJson(resultBean.getData());
    }
    public static String getMsgJsonIncludeResultCode (ResultBean resultBean) throws IOException {
        if(!CommonVar.SUCCESS_CODE.equals(resultBean.getResultCode())){
            return ResultUtil.getErrorMsgJson(resultBean);
        }

        if (resultBean.getData() instanceof String) {
            return resultBean.getData().toString();
        }

        return JsonParser.toJson(resultBean);
    }

    public static String getErrorMsgJson(String errMeg,String interfaceCode,String errorCode,String lang){
        Map<String, String> result=getErrorMsgJsonObj(errMeg,interfaceCode,errorCode,lang);
        return JsonParser.toJsonQuietly(result);
    }
    /**
     *
     * @param errMeg 异常提示语的KEY,或者本身,如果是KEY需要在国际化文件中配置
     * @param interfaceCode 报错接口
     * @param errorCode 错误编码
     * @param lang 语言
     * @return
     */
    public static Map<String, String> getErrorMsgJsonObj(String errMeg,String interfaceCode,String errorCode,String lang){
        String mess=i18nString(errMeg, lang);
        Map<String, String> result=new HashMap<String, String>();
        result.put("resultCode", getErrorCode(interfaceCode, errorCode));
        String[] strArray = new String[]{mess, "【",interfaceCode, errorCode, "】"};
        String msgAndCode = buildCommonJsonResp(strArray);
        result.put("resultMessage", msgAndCode);
        return result;
    }
    /**
     * 根据resultBean封装APP,触屏格式的异常返回
     * @param resultBean
     * @return
     */
    public static String getErrorMsgJson(ResultBean resultBean){
        String[] messArray= new String[] {resultBean.getResultMessage(),"【",resultBean.getResultCode(),"】"};
        Map<String, String> result=new HashMap<String, String>();
        result.put("resultCode", resultBean.getResultCode());
        result.put("resultMessage", buildCommonJsonResp(messArray));
        return JsonParser.toJsonQuietly(result);
    }
    public static String getErrorMsgJson(String errMeg,String interfaceCode,String errorCode){
        Map<String, String> result=new HashMap<String, String>();
        result.put("resultCode", getErrorCode(interfaceCode, errorCode));
        result.put("resultMessage", errMeg);
        return JsonParser.toJsonQuietly(result);
    }
    private static String getErrorCode(String interfaceCode,String code){
        return   interfaceCode+code;
    }
    private static String buildCommonJsonResp(String[] strArray) {
        StringBuilder strBuilder = new StringBuilder();
        for (String str : strArray) {
            strBuilder.append(transferBlankString(str));
        }
        String result = strBuilder.toString();
        LOGGER.error(result);
        return result;
    }
    /***
     * 字符串为null时转换为“”
     * @param str 输入字符串
     * @return
     */
    private static String transferBlankString(String str) {
        if (StringUtils.isBlank(str)) {
            str = "";
        }
        return str;
    }
    /***
     * 字符串i18n转换
     * @param str 输入字符串
     * @param lang 语言位
     * @return
     */
    private static String i18nString(String str, String lang) {
        if (StringUtils.isBlank(lang) || StringUtils.isBlank(str)) {
            return str;
        }
        String destStr = str;
        try {
            destStr = MessagesUtils.getString(str, lang);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());// 忽略此异常
        }
        return destStr;
    }
}
