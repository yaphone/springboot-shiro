package cn.yaphone.shiro.service;

import cn.yaphone.shiro.model.Permission;

/**
 * @author https://github.com/yaphone
 * @version 1.0
 * @date 2018/10/7 16:21
 */
public interface PermissionService {
    Permission getPermissionByPermissionId(String permissionId);
}
