package cn.caoyihong.shiro.util;

import cn.caoyihong.shiro.model.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.HashSet;
import java.util.Set;

public class ShiroRealm extends AuthorizingRealm {

    /**
     * 登录认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        // 1.获取用户名
        String username = token.getUsername();
        // 2.获取用户输入的密码
        String password = new String(token.getPassword());
        // 3.根据用户名去数据库查询对应的用户信息
        User user = new User("admin","3726e127cf0bd1d90e8d624b8e7552ef",0);
        if (!user.getUsername().equals(username)) {
            throw new UnknownAccountException("用户名不存在");
        }
        if (user.getStatus() == 1) {
            throw new DisabledAccountException("账号被禁用");
        }
        if (user.getStatus() == 2) {
            throw new LockedAccountException("账号被锁定");
        }
        if (!user.getPassword().equals(password)){
            throw new CredentialsException("密码错误");
        }
        System.out.println("登录认证成功。。。");
        // 创建简单认证信息对象
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(token.getPrincipal(),token.getCredentials(),getName());
//        info.set
        return info;
    }

    /**
     * 授权:将认证通过的用户的角色和权限信息设置到对应用户主体上
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 用户名
        String username = (String) principalCollection.getPrimaryPrincipal();
        // 模拟从数据库中获取当前用户的角色
        Set<String> roleNameSet = new HashSet<>();
        roleNameSet.add("系统管理员");
        roleNameSet.add("系统运维");
        // 模拟从数据库获取当前用户的权限 通过用户名查询该用户拥有的权限名称
        Set<String> permissionNameSet = new HashSet<>();
        permissionNameSet.add("sys:user:list");
        permissionNameSet.add("sys:user:info");
        permissionNameSet.add("sys:user:create");
        permissionNameSet.add("sys:user:update");
        permissionNameSet.add("sys:user:delete");
        // 简单授权信息对象，包含用户的角色和权限信息
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRoles(roleNameSet);
        info.addStringPermissions(permissionNameSet);
        System.out.println("授权完成。。。");
        return null;
    }

}
