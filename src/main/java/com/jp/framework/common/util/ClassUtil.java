package com.jp.framework.common.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.security.MessageDigest;

public class ClassUtil {
    private static final char[] hexDigits = "0123456789abcdef".toCharArray();

    public ClassUtil() {
    }

    public static Class<?> getGenericType(Class<?> clazz, int index) {
        ParameterizedType genType = null;
        Type loopType = clazz.getGenericSuperclass();

        while(loopType != null) {
            if(loopType instanceof ParameterizedType) {
                genType = (ParameterizedType)loopType;
                break;
            }

            if(genType == null) {
                if(!(loopType instanceof Class)) {
                    break;
                }

                Class params = (Class)loopType;
                loopType = params.getGenericSuperclass();
            }
        }

        if(genType != null && genType instanceof ParameterizedType) {
            Type[] params1 = genType.getActualTypeArguments();
            if(index < params1.length && index >= 0) {
                Type res = params1[index];
                if(res instanceof Class) {
                    return (Class)params1[index];
                }
            }
        }

        return null;
    }

    public static String md5(String origin) {
        Object resultString = null;

        try {
            MessageDigest ex = MessageDigest.getInstance("MD5");
            byte[] byteArray = ex.digest(origin.getBytes());
            return byteArray2String(byteArray);
        } catch (Exception var4) {
            return null;
        }
    }

    public static String byteArray2String(byte[] byteArray) {
        StringBuffer resultSb = new StringBuffer(33);

        for(int i = 0; i < byteArray.length; ++i) {
            int value = byteArray[i];
            if(value < 0) {
                value += 256;
            }

            int d1 = value / 16;
            int d2 = value % 16;
            resultSb.append(hexDigits[d1]).append(hexDigits[d2]);
        }

        return resultSb.toString();
    }
}
