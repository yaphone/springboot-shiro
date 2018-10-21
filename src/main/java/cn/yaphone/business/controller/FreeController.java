package cn.yaphone.business.controller;

import cn.yaphone.shiro.common.BaseResponse;
import cn.yaphone.shiro.common.ErrorCodeEnum;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author https://github.com/yaphone
 * @version 1.0
 * @date 2018/10/19 23:49
 */
@RestController
@RequestMapping("freeController")
public class FreeController {

    @RequiresPermissions("ip:search")
    @RequestMapping("/ipSearch")
    public BaseResponse ipSearch() {
        Map<String, String> data = new HashMap<>();
        data.put("country", "中国");
        return new BaseResponse(ErrorCodeEnum.SUCCESS, data);
    }
}
