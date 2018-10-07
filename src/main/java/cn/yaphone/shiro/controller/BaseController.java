package cn.yaphone.shiro.controller;

import cn.yaphone.shiro.common.BaseResponse;
import cn.yaphone.shiro.common.ErrorCodeEnum;
import cn.yaphone.shiro.model.User;
import cn.yaphone.shiro.service.BaseService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author https://github.com/yaphone
 * @version 1.0
 * @date 2018/10/5 16:37
 */
@RestController
public class BaseController {

    @Autowired
    private BaseService baseService;

    @RequestMapping("doc/hello")
    @RequiresPermissions("document:read")
    public BaseResponse hello() {
        return new BaseResponse(ErrorCodeEnum.SUCCESS, "Hello World");
    }

    @RequestMapping("getUser")
    public BaseResponse getUser() {
        User user = baseService.getUserById(1);
        return new BaseResponse(ErrorCodeEnum.SUCCESS, user);
    }

    @RequestMapping("login")
    public BaseResponse login(@RequestBody  Map<String, String> params) {
        User user = new User();
        user.setUsername(params.get("username"));
        user.setPassword(params.get("password"));

        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(new UsernamePasswordToken(user.getUsername(), user.getPassword()));
        } catch (AuthenticationException ex) {
            System.out.println("登陆失败");
        } catch (Exception e) {

        }
        return new BaseResponse(ErrorCodeEnum.SUCCESS, "login");
    }
}
