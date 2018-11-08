package cn.yaphone.shiro.controller.service.impl;

import cn.yaphone.shiro.controller.service.TestService;
import org.springframework.stereotype.Service;

/**
 * @author https://github.com/yaphone
 * @version 1.0
 * @date 2018/10/22 23:27
 */
@Service
public class TestServiceImpl implements TestService{
    @Override
    public String sayHello() {
        return "Hello World";
    }
}
