package com.chx.tools.web.controller;

import com.chx.tools.common.base.BaseResult;
import com.chx.tools.timer.job.DemoJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author yanuun
 * @Date 16:01 2018/12/18
 **/
@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    @Autowired
    private DemoJob demoJob;

    /**
     * 获得用户信息
     * @return
     */
    @RequestMapping(value = "/getInfo",method = RequestMethod.GET)
    public BaseResult getUserInfo(){
        return BaseResult.ok();
    }

    @RequestMapping(value = "/testJob",method = RequestMethod.GET)
    public BaseResult testHive(){
        try {
            demoJob.execute("");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return BaseResult.ok();
    }

}
