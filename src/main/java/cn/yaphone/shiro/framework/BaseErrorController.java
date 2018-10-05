package cn.yaphone.shiro.framework;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;

/**
 * @author https://github.com/yaphone
 * @version 1.0
 * @date 2018/10/5 19:14
 */
@Controller
public class BaseErrorController implements ErrorController{
    @Override
    public String getErrorPath() {
        return null;
    }
}
