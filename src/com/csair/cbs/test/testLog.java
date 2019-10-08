package com.csair.cbs.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class testLog {

    @Test
    public void testLog() {
        Logger log = LoggerFactory.getLogger(this.getClass());
        log.trace("这是rrace日志。。。");
        log.debug("这是debuug日志。。。");
        log.info("这是info日志。。。");
        log.warn("这是warn日志。。。");
        log.error("这是error日志。。。");
    }

}
