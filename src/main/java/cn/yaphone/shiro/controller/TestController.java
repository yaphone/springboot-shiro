package cn.yaphone.shiro.controller;

import cn.yaphone.shiro.common.BaseResponse;
import cn.yaphone.shiro.common.ErrorCodeEnum;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author https://github.com/yaphone
 * @version 1.0
 * @date 2018/10/16 23:23
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/hello")
    public BaseResponse sayHello() {
        System.out.println("Hello World");
        return new BaseResponse(ErrorCodeEnum.SUCCESS, "Hello World!");
    }
}
