package cn.yaphone.shiro.framework;

import cn.yaphone.shiro.common.BaseResponse;
import cn.yaphone.shiro.common.ErrorCodeEnum;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author https://github.com/yaphone
 * @version 1.0
 * @date 2018/10/19 23:17
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = UnauthorizedException.class)
    public BaseResponse unauthorizedException() {
        return new BaseResponse(ErrorCodeEnum.NO_PERMISSION, null);
    }

    @ExceptionHandler(value = UnauthenticatedException.class)
    public BaseResponse unauthenticatedException() {
        return new BaseResponse(ErrorCodeEnum.UN_LOGIN, null);
    }

    @ExceptionHandler(value = UnknownAccountException.class)
    public BaseResponse unknownAccountException() {
        return new BaseResponse(ErrorCodeEnum.UNKOWN_ACCOUNT, null);
    }
}
