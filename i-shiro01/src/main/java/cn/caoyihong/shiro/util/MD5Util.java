package cn.caoyihong.shiro.util;

import org.apache.shiro.crypto.hash.Md5Hash;

public class MD5Util {
    // 散列次数
    private static int hashIterations = 3;

    public static String md5(String source, String salt) {
        return new Md5Hash(source,salt,hashIterations).toString();
    }

    public static void main(String[] args) {
        String password = MD5Util.md5("123456","ak47");
        System.out.println(password);
    }
}
