package com.xqf.test.launch;

import com.xqf.test.MyCalculatorSimple;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 用户界面
 * Created by XQF on 2018/1/12.
 */
public class MyLaunch {
    public static void main(String[] args) {

        MyCalculatorSimple layoutSimple = new MyCalculatorSimple("XQF");

        Frame frame = new Frame("请选择");
        JButton buttonSimple = new JButton("Simple");
        buttonSimple.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                layoutSimple.showCalculator();
            }
        });
        JButton buttonAdvanced = new JButton("Advanced");
        buttonAdvanced.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
