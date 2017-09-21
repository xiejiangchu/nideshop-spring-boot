package com.xie.utils;

import org.joda.time.DateTime;

import java.util.Random;

/**
 * @Author xie
 * @Date 17/2/22 下午5:39.
 */
public class StringUtils {
    private static final String ABC = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final String AB = "0123456789";
    private static Random rnd = new Random();

    public static String randomNumber(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }

    public static String randomString(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(ABC.charAt(rnd.nextInt(ABC.length())));
        return sb.toString();
    }

    public static String generateOrderNo() {
        String today = DateTime.now().toString("yyyyMMddhhMM");
        return today.concat(randomNumber(6));
    }

    public static String generateItemNo() {
        return "NO" + randomString(10);
    }

    public static String generateSessionId() {
        return randomString(20);
    }

}
