package com.xqf.test.launch;

import com.xqf.test.MyCalculatorAdvanced;
import com.xqf.test.MyCalculatorSimple;

/**
 * 用户界面
 * Created by XQF on 2018/1/12.
 */
public class MyLaunch {
    public static void main(String[] args) {


        MyCalculatorSimple myCalculatorSimple = new MyCalculatorSimple("XQF Simple");
        myCalculatorSimple.showCalculator();
        MyCalculatorAdvanced myCalculatorAdvanced = new MyCalculatorAdvanced("XQF Advanced");
        myCalculatorAdvanced.showCalculator();
    }
}
