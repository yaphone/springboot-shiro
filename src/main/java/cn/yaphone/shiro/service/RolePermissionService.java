package cn.yaphone.shiro.service;

import cn.yaphone.shiro.model.Permission;
import cn.yaphone.shiro.model.Role;

import java.util.List;

/**
 * @author https://github.com/yaphone
 * @version 1.0
 * @date 2018/10/7 16:28
 */
public interface RolePermissionService {
    List<Permission> getPermissionsByRole(Role role);
}
