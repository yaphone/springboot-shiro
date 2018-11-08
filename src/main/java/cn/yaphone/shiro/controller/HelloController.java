package cn.yaphone.shiro.controller;

import cn.yaphone.shiro.common.BaseResponse;
import cn.yaphone.shiro.common.ErrorCodeEnum;
import cn.yaphone.shiro.controller.service.TestService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author https://github.com/yaphone
 * @version 1.0
 * @date 2018/10/22 23:28
 */
@RequestMapping("test")
@RestController
public class HelloController {

    @Autowired
    private TestService testService;

    @RequestMapping("hello")
    @RequiresPermissions("ip:search")
    public BaseResponse sayHello() {
        return new BaseResponse(ErrorCodeEnum.SUCCESS, testService.sayHello());
    }

}
