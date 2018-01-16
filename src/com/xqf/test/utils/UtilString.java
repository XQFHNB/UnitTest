package com.xqf.test.utils;

/**
 * String相关的工具
 * Created by XQF on 2018/1/13.
 */
public class UtilString {

    /**
     * 看两个数是不是都是合乎条件的十进制数
     *
     * @param str1 第一个数字
     * @param str2 第二个数字
     * @return 结果
     */
    public static boolean bothAreDecNum(String str1, String str2) {
        return strIsDecNum(str1) && strIsDecNum(str2);
    }

    /**
     * 单独检验一个数是不是十进制数
     *
     * @param str 数字
     * @return 结果
     */

    public static boolean strIsDecNum(String str) {
        boolean result = true;
        if (str.length() == 0) {
            result = false;
            return result;
        }
        if (str.length() == 1 && str.charAt(0) == '.') {
            result = false;
            return result;
        }
        if (str.charAt(0) == '-') {
            str = str.substring(1);
        }
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '.') {
                if (chars[i] < '0' || chars[i] >= '9') {
                    result = false;
                    break;
                }
            }

        }
        return result;
    }

    /**
     * 检验输入的两个数是不是都是十六进制数字（忽略大小写）
     *
     * @param str1 第一个数
     * @param str2 第二个数
     * @return 结果
     */
    public static boolean bothAreHexNum(String str1, String str2) {
        return strIsHexNum(str1) && strIsHexNum(str2);
    }

    /**
     * 单独检验一个数字是不是十六进制数
     *
     * @param str 数字
     * @return 结果
     */
    public static boolean strIsHexNum(String str) {
        boolean result = true;
        if (str.charAt(0) == '-') {
            str = str.substring(1);
        }
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if ((chars[i] <= '0' && chars[i] >= '9') || (chars[i] <= 'A' && chars[i] >= 'F') || (chars[i] <= 'a' && chars[i] >= 'f')) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(strIsDecNum("12.1"));
    }
}
