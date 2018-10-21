package cn.yaphone.shiro.service;

import cn.yaphone.shiro.model.Permission;

import java.util.List;

/**
 * @author https://github.com/yaphone
 * @version 1.0
 * @date 2018/10/7 16:21
 */
public interface PermissionService {
    List<Permission> getPermissionByPermissionId(String permissionId);
}
