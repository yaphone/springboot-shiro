package cn.yaphone.shiro.common;

/**
 * @author https://github.com/yaphone
 * @version 1.0
 * @date 2018/10/5 17:23
 */
public enum ErrorCodeEnum {
    SUCCESS(200, "success"),

    //权限相关
    UN_LOGIN(601, "未登陆"),
    UN_AUTH(602, "未认证"),
    NO_PERMISSION(603, "无权限");

    int code;
    String msg;

    ErrorCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }
}
