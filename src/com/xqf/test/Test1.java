package com.xqf.test;

import javax.swing.*;

/**
 * Created by XQF on 2018/1/13.
 */
public class Test1 {

    public static void test1() {
        Long num1 = Long.valueOf("1A", 16);
        System.out.println("nums to String :" + num1.toString());
        Long num2 = Long.valueOf("2", 16);
        Long sum = num1 / num2;
        System.out.println(Long.toHexString(sum));

    }

    public static void main(String[] args) {
        String str = "123a";
        System.out.println(str.toUpperCase());

    }
}
