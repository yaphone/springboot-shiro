package cn.yaphone.shiro.controller;

import cn.yaphone.shiro.common.BaseResponse;
import cn.yaphone.shiro.common.ErrorCodeEnum;
import cn.yaphone.shiro.model.User;
import cn.yaphone.shiro.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author https://github.com/yaphone
 * @version 1.0
 * @date 2018/10/5 16:37
 */
@RestController
public class BaseController {

    @Autowired
    private BaseService baseService;

    @RequestMapping("hello")
    public BaseResponse hello() {
        return new BaseResponse(ErrorCodeEnum.SUCCESS, null);
    }

    @RequestMapping("getUser")
    public BaseResponse getUser() {
        User user = baseService.getUserById(1);
        return new BaseResponse(ErrorCodeEnum.SUCCESS, user);
    }
}
