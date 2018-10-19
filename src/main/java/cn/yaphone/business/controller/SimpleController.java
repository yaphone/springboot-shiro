package cn.yaphone.business.controller;

import cn.yaphone.shiro.common.BaseResponse;
import cn.yaphone.shiro.common.ErrorCodeEnum;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author https://github.com/yaphone
 * @version 1.0
 * @date 2018/10/18 23:42
 */
@RestController
@RequestMapping("business")
public class SimpleController {

    @RequestMapping("test")
    @RequiresPermissions("document:read")
    public BaseResponse test() {
        return new BaseResponse(ErrorCodeEnum.SUCCESS, "Business Test");
    }

    @RequestMapping("test2")
    @RequiresAuthentication
    public BaseResponse test2() {
        return new BaseResponse(ErrorCodeEnum.SUCCESS, "Business Test 2");
    }
}
