package com.xqf.test.utils;

import javax.swing.*;
import java.awt.*;

/**
 * 提示工具
 * Created by XQF on 2018/1/13.
 */
public class UtilTips {
    public static final String FONT = "宋体";

    public static void tipsEnterHasProblem(JTextField textFieldResult) {
        textFieldResult.setText("Your enter has problem,please check");
        textFieldResult.setFont(new Font(FONT, Font.BOLD, 10));
        textFieldResult.setForeground(Color.red);
    }

    public static void tipsDontPressButton(JTextField textField, String str) {
        textField.setText("You haven't press " + str + ",Please  Clc and retype");
        textField.setFont(new Font(FONT, Font.BOLD, 8));
        textField.setForeground(Color.red);
    }

}
