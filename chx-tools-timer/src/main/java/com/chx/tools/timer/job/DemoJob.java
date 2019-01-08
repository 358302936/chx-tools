package com.chx.tools.timer.job;

import com.chx.tools.common.annotation.JobLog;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Author yanuun
 * @Date 11:17 2019/1/8
 **/
@JobHandler(value = "demoJob")
@Component
@Slf4j
public class DemoJob extends IJobHandler {
    @Override
    @JobLog(description = "定时器demo")
    public ReturnT<String> execute(String s) throws Exception {
        log.info("定时器执行了……");
        return ReturnT.SUCCESS;
    }
}
