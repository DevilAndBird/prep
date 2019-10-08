package com.csair.cbs.common.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Auther: tangqm
 * @Date: 2019年9月24日
 * @Description:
 */
@Setter
@Getter
@ToString
public class ResultBean<T> implements Serializable {
    private static final long serialVersionUID = -5523976877598156206L;
    private String resultCode = "0000";
    //错误信息
    private String resultMessage = "操作成功";
    //服务器时间
    private long serverTime;
    //数据
    private T data;

    public ResultBean() {
    }

    public ResultBean(String resultCode, String resultMessage) {
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
    }


}
