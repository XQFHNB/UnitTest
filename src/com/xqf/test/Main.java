package com.xqf.test;

/**
 * Created by XQF on 2018/1/13.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("----start---");
        boolean isOpen = false;
        assert isOpen = true;             //如果开启了断言，会将isOpen的值改为true
        System.out.println("是否开启了断言" + isOpen);  //打印是否开启了断言
        if (isOpen) {
            int value = -1;
            assert 0 < value : "value=" + value;
        }
        System.out.println("----end----");
    }
}
