/**
 * @FileName: Md5Utils
 * @Author: fusheng
 * @Date: 2020/3/11 11:59
 * Description: MD5加密工具类
 */
package xyz.fusheng.blog.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Utils {
    @SuppressWarnings("all")
    public static String toMD5(String plainText) {
        byte[] secretBytes = null;
        try {
            secretBytes = MessageDigest.getInstance("md5").digest(plainText.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("加密失败！");
        }
        StringBuilder md5code = new StringBuilder(new BigInteger(1, secretBytes).toString(16));
        for (int i = 0; i < 32 - md5code.length(); i++) {
            md5code = md5code.append(0);
        }
        return md5code.toString();
    }
}
