package com.chx.tools.timer.job;

import com.chx.tools.common.annotation.JobLog;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.springframework.stereotype.Component;

/**
 * @Author yanuun
 * @Date 11:17 2019/1/8
 **/
@JobHandler(value = "demoJob")
@Component
public class DemoJob extends IJobHandler {
    @Override
    @JobLog(description = "处理最近学习缓存数据")
    public ReturnT<String> execute(String s) throws Exception {
        return ReturnT.SUCCESS;
    }
}
