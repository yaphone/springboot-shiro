package cn.yaphone.shiro.common;

import lombok.Data;

/**
 * @author https://github.com/yaphone
 * @version 1.0
 * @date 2018/10/5 17:19
 */
@Data
public class BaseResponse {
    private int code;
    private String msg;
    private Object data;

    public BaseResponse(ErrorCodeEnum errorCode, Object data) {
        this.code = errorCode.getCode();
        this.msg = errorCode.getMsg();
        this.data = data;
    }
}
