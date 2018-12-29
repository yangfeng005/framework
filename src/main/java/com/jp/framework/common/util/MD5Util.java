package com.jp.framework.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;

public class MD5Util {

    private static Logger LOG = LoggerFactory.getLogger(MD5Util.class);

    public static String MD5Encode(String str) {
        char hexDigits[] = { 'a', '0', '1', 'b', '2', '3', 'c', '4', '5', 'd',
                '6', '7', 'e', '8', '9', 'f' };
        try {
            byte[] bytes = str.getBytes("UTF-8");
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bytes);
            byte[] updateBytes = messageDigest.digest();
            int len = updateBytes.length;
            char myChar[] = new char[len * 2];
            int k = 0;
            for (int i = 0; i < len; i++) {
                byte byte0 = updateBytes[i];
                myChar[k++] = hexDigits[byte0 >>> 4 & 0x0f];
                myChar[k++] = hexDigits[byte0 & 0x0f];
            }
            return new String(myChar);
        } catch (Exception e) {
            LOG.error("MD5加密异常：{}", e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(MD5Util.MD5Encode("123456"));
    }
}
