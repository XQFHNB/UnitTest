package com.xqf.test;

import com.xqf.test.utils.UtilCompute;
import com.xqf.test.utils.UtilLabel;
import com.xqf.test.utils.UtilString;
import com.xqf.test.utils.UtilTips;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 高级
 * Created by XQF on 2018/1/12.
 */
public class MyCalculatorAdvanced extends Frame {

    public static final String EMPTY = "";
    public static final int RAIDX = 16;

    public static final String BUTTON_DEC = "Dec";
    public static final String BUTTON_HEX = "Hex";
    public static final String BUTTON_CLC = "Clc";
    public static final String FONT = "宋体";
    public static final int TEXTFIELD_WIDTH = 30;
    public static final int GRID_GAP = 4;


    String[] names = new String[]{"+", "-", "*", "/"};
    Button[] buttons;
    JTextField textFieldNum1;
    JTextField textFieldNum2;
    JTextField textFieldResult;
    Boolean[] flags;
    JLabel jLabel;

    public MyCalculatorAdvanced(String string) {
        this.setTitle(string);
        Panel panelRight = new Panel();
        panelRight.setLayout(new BoxLayout(panelRight, BoxLayout.Y_AXIS));

        jLabel = new JLabel();
        jLabel.setHorizontalAlignment(JLabel.CENTER);
        UtilLabel.welcome(jLabel);
        jLabel.setForeground(Color.RED);
        panelRight.add(jLabel);

        textFieldNum1 = new JTextField(TEXTFIELD_WIDTH);
        customMyTextField(textFieldNum1);
        panelRight.add(textFieldNum1);


        Panel buttonsPanel = new Panel();
        buttonsPanel.setLayout(new GridLayout(1, 4, GRID_GAP, GRID_GAP));

        buttons = new Button[8];
        for (int i = 0; i < names.length; i++) {
            buttons[i] = new Button(names[i]);
            buttonsPanel.add(buttons[i]);
        }
        panelRight.add(buttonsPanel);


        textFieldNum2 = new JTextField(TEXTFIELD_WIDTH);
        customMyTextField(textFieldNum2);
        panelRight.add(textFieldNum2);

        Panel equalButtonPanel = new Panel();
        equalButtonPanel.setLayout(new GridLayout(1, 1, GRID_GAP, GRID_GAP));
        buttons[4] = new Button("=");
        equalButtonPanel.add(buttons[4]);
        panelRight.add(equalButtonPanel);

        textFieldResult = new JTextField(TEXTFIELD_WIDTH);
        customMyTextField(textFieldResult);
        panelRight.add(textFieldResult);


        this.add(panelRight, BorderLayout.CENTER);


        Panel panelLeft = new Panel();
        panelLeft.setLayout(new BoxLayout(panelLeft, BoxLayout.Y_AXIS));

        String[] namesL = new String[]{BUTTON_DEC, BUTTON_HEX, BUTTON_CLC};
        for (int i = 0; i < namesL.length; i++) {
            buttons[i + 5] = new Button(namesL[i]);
            panelLeft.add(buttons[i + 5]);
        }
        this.add(panelLeft, BorderLayout.WEST);


        flags = new Boolean[buttons.length];

        enableButtonsAndTextField();
        setupButtonsAndTextField();


        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);//关闭窗口处理关闭动作监听事件
            }
        });
        showCalculator();
    }

    private void customMyTextField(JTextField textFieldNum1) {
        textFieldNum1.setHorizontalAlignment(JTextField.CENTER);
        textFieldNum1.setForeground(Color.black);
        textFieldNum1.setFont(new Font(FONT, Font.BOLD, 16));
    }


    /**
     * 协调整个按钮控制组与显示的关系
     */
    private void setupButtonsAndTextField() {
        for (int i = 0; i < 4; i++) {
            buttons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Button button = (Button) e.getSource();
                    button.setBackground(Color.GREEN);
                    for (int j = 0; j < 4; j++) {
                        if (button.equals(buttons[j])) {
                            flags[j] = true;
                            break;
                        }
                    }
                    unableButtonFromTo(buttons, 0);
                }
            });
        }
        for (int i = 5; i <= 6; i++) {
            buttons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Button button = (Button) e.getSource();
                    button.setBackground(Color.GREEN);
                    for (int j = 5; j < 7; j++) {
                        if (button.equals(buttons[j])) {
                            flags[j] = true;
                            if (j == 5) {
                                UtilLabel.warnDec(jLabel);
                            } else {
                                UtilLabel.warnHex(jLabel);
                            }
                            break;
                        }
                    }
                    unableButtonFromTo(buttons, 1);
                }
            });
        }
        buttons[4].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyModel model = new MyModel();
                String num1 = textFieldNum1.getText().toString().trim();
                String num2 = textFieldNum2.getText().toString().trim();
                String op = "";
                for (int i = 0; i < 4; i++) {
                    if (flags[i]) {
                        op += names[i];
                        break;
                    }
                }
                if (op.length() == 0) {//提示选择计算操作符
                    UtilTips.tipsDontPressButton(textFieldResult, "operator");
                }
                if (flags[5] == true) {//十进制计算

                    //验证输入的正确性
                    if (UtilString.bothAreDecNum(num1, num2)) {
                        fillModel(model, num1, num2, op);
                        String result = UtilCompute.computeByDec(model);
                        textFieldResult.setText(result);
                    } else {
                        UtilTips.tipsEnterHasProblem(textFieldResult);
                    }
                } else if (flags[6] == true) {//十六进制计算
                    if (UtilString.bothAreHexNum(num1, num2)) {
                        Long num1Long = Long.valueOf(num1, RAIDX);
                        String num1String = num1Long.toString();
                        Long num2Long = Long.valueOf(num2, RAIDX);
                        String num2String = num2Long.toString();
                        fillModel(model, num1String, num2String, op);
                        String result = UtilCompute.computeByHex(model);
                        textFieldResult.setText(result);

                    } else {
                        UtilTips.tipsEnterHasProblem(textFieldResult);
                    }
                } else {//提示选择进制
                    UtilTips.tipsDontPressButton(textFieldResult, "scale");
                }

            }
        });

        //清零操作
        buttons[7].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enableButtonsAndTextField();
                UtilLabel.welcome(jLabel);
            }
        });
    }

    private void fillModel(MyModel model, String num1, String num2, String op) {
        model.setNum1(num1);
        model.setNum2(num2);
        model.setOp(op);
    }

    /**
     * 设置按钮不可用
     *
     * @param buttons 按钮数组
     * @param a       状态暗示，为0为第一部分，1为第二部分
     */
    private void unableButtonFromTo(Button[] buttons, int a) {
        if (a == 0) {
            for (int i = 0; i < 4; i++) {
                buttons[i].setEnabled(false);
            }
        } else {
            for (int i = 5; i < 7; i++) {
                buttons[i].setEnabled(false);
            }
        }
    }

    /**
     * 清零恢复状态
     */
    private void enableButtonsAndTextField() {
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setEnabled(true);
            buttons[i].setBackground(Color.GRAY);
            flags[i] = false;
        }
        textFieldNum1.setText(EMPTY);
        textFieldNum2.setText(EMPTY);
        textFieldResult.setText(EMPTY);
        customMyTextField(textFieldNum1);
        customMyTextField(textFieldNum2);
        customMyTextField(textFieldResult);
    }


    /**
     * 最后来展示计算器
     */
    public void showCalculator() {
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        MyCalculatorAdvanced myCalculatorSenior = new MyCalculatorAdvanced("XQF");
    }
}
