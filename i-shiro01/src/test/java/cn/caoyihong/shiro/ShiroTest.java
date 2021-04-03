package cn.caoyihong.shiro;

import cn.caoyihong.shiro.util.MD5Util;
import cn.caoyihong.shiro.util.ShiroUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

public class ShiroTest {
    @Test
    public void test() {
        //1.初始化shiro的安全管理器
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        //2.设置用户的权限信息到安全管理器
        Realm realm = new IniRealm("classpath:shiro.ini");
        securityManager.setRealm(realm);
        //3.使用SecurityUtils将securityManager设置到运行环境中
        SecurityUtils.setSecurityManager(securityManager);
        //4.创建一个subject实例
        Subject subject = SecurityUtils.getSubject();
        //5.创建token令牌，记录用户认证的身份和凭证
        UsernamePasswordToken token = new UsernamePasswordToken("zhangsan","123456");
        //6. 主体登录
        subject.login(token);
        // 用户认证状态
        System.out.println("用户认证状态：" + subject.isAuthenticated());
        //7.检查角色授权状态
        System.out.println("是否拥有admin角色"+subject.hasRole("admin"));
        //8.检查权限的授权状态
        System.out.println("product:view "+subject.isPermitted("product:view"));
    }

    @Test
    public void test02() {
        Subject subject = ShiroUtil.login("admin","123456");
        System.out.println("admin权限： " + subject.hasRole("admin"));
        // 检查该用户是否拥有新增用户的权限
        System.out.println("是否拥有新增用户的权限："+subject.isPermitted("sys:user:create"));
        System.out.println("是否拥有新增角色的权限："+subject.isPermitted("sys:role:create"));
    }

    @Test
    public void test03() {
        //md5
        Md5Hash md5Hash = new Md5Hash("111111");
        System.out.println(md5Hash);

        Md5Hash md5Hash_salt = new Md5Hash("111111", "qazwsx");
        System.out.println(md5Hash_salt);

    }
    @Test
    public void test04() {
        // 模拟从客户端接收到用户登录的用户名和密码（明文）
        String username = "admin";
        String password = "123456";
        //密码加密
        password = MD5Util.md5(password,"ak47");

        Subject subject = ShiroUtil.login(username,password);
        System.out.println("admin权限： " + subject.hasRole("admin"));
        // 检查该用户是否拥有新增用户的权限
        System.out.println("是否拥有新增用户的权限："+subject.isPermitted("sys:user:create"));
        System.out.println("是否拥有新增角色的权限："+subject.isPermitted("sys:role:create"));
    }
}









