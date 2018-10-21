package cn.yaphone.shiro.realm;

import cn.yaphone.shiro.model.Permission;
import cn.yaphone.shiro.model.Role;
import cn.yaphone.shiro.model.User;
import cn.yaphone.shiro.service.RolePermissionService;
import cn.yaphone.shiro.service.RoleService;
import cn.yaphone.shiro.service.UserRoleService;
import cn.yaphone.shiro.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author https://github.com/yaphone
 * @version 1.0
 * @date 2018/10/7 0:51
 */
@Component
public class BaseRealm extends JdbcRealm {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private RolePermissionService rolePermissionService;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取用户的输入账号
        String username = (String)token.getPrincipal();
        //通过username从数据库中查找User对象
        //实际项目中可能需要做缓存，如果不做，shiro自己也有刷新机制，2分钟内不会重复执行此方法
        User user = userService.getUserByUsername(username);
        if (user == null) {
            return null;
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user,
                user.getPassword(),
                ByteSource.Util.bytes(user.getSalt()),
                getName()
        );
        return authenticationInfo;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        User user = (User) principals.getPrimaryPrincipal();
        List<Role> roles = userRoleService.getRolesByUser(user);
        for(Role role: roles) {
            authorizationInfo.addRole(role.getRoleName());
            List<Permission> permissions =  rolePermissionService.getPermissionsByRole(role);
            for (Permission permission: permissions) {
                if (permission != null) {
                    authorizationInfo.addStringPermission(permission.getPermissionCode());
                }
            }
        }
        return authorizationInfo;
    }
}
