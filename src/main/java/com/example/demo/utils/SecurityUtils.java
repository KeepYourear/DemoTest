package com.example.demo.utils;
// MD5机密算法
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SecurityUtils {
    /**
     * MD5加密
     * @param password 密码
     * @return 加密后的密码
     */
    public static String encodePassword(String password) {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");

            byte[] bytes = md.digest(password.getBytes());

            StringBuilder sb = new StringBuilder();
            for (byte aByte : bytes) {
                sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }

    /**
     * 判断是否匹配
     * @param rawPassword 密码
     * @param encodedPassword 加密后的密码
     * @return 匹配返回true，否则返回false
     */
    public static boolean matchPassword(String rawPassword, String encodedPassword) {
        String rawPasswordEncode = encodePassword(rawPassword);
        return rawPasswordEncode.equals(encodedPassword);
    }
}
