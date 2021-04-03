package cn.caoyihong.shiro.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;

public class ShiroUtil {
    static {
        //1.初始化shiro的安全管理器
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        //2.设置用户的权限信息到安全管理器
//        Realm realm = new IniRealm("classpath:shiro.ini");
        Realm realm = new ShiroRealm();
        securityManager.setRealm(realm);
        //3.设置缓存管理器
        CacheManager cacheManager = new MemoryConstrainedCacheManager();
//        CacheManager cacheManager = new EhCacheManager();
        securityManager.setCacheManager(cacheManager);
        //4.使用SecurityUtils将securityManager设置到运行环境中
        SecurityUtils.setSecurityManager(securityManager);
    }

    public static Subject login(String username, String password) {
        //4.创建一个subject实例
        Subject subject = SecurityUtils.getSubject();
        //5.创建token令牌，记录用户认证的身份和凭证
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        //6. 主体登录
        subject.login(token);
        // 用户认证状态
        System.out.println("用户认证状态：" + subject.isAuthenticated());
        return subject;
    }

}
