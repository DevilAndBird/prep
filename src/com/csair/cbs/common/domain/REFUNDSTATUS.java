package com.csair.cbs.common.domain;

public enum REFUNDSTATUS {
    /** 调账失败 */
    ADJUSTMENTFAIL("ADJUSTMENTFAIL", "调账失败"),
    /** 调账成功 */
    ADJUSTMENTSUCC("ADJUSTMENTSUCC", "调账成功"),
    /** 待审核 */
    APPLYREFUND("APPLYREFUND", "待审核"),
    /** 审核失败 */
    AUDITFAIL("AUDITFAIL", "审核失败"),
    /** 审核成功 */
    AUDITSUCC("AUDITSUCC", "审核成功");

    private final String value;
    private final String name;

    public String getValue() {
        return this.value;
    }

    public String getName() {
        return this.name;
    }

    private REFUNDSTATUS(String value, String name) {
        this.value = value;
        this.name = name;
    }
}

