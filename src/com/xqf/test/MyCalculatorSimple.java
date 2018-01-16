package com.xqf.test;

import com.xqf.test.utils.UtilCompute;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 计算器的UI
 * Created by XQF on 2018/1/12.
 */
public class MyCalculatorSimple extends Frame {

    public static final int INDEX_CLEAR = 0;
    public static final int INDEX_EQUAL = 1;

    public static final int BUTTONS_SUM = 17;
    public static final int BUTTONS_ROW = 3;
    public static final int BUTTONS_COL = 5;

    public static final int BUTTONS_GAP = 4;

    public static final String BUTTONS_CLC = "Clear";
    public static final String BUTTONS_EQUAL = "=";
    public static final String BUTTONS_PLUS = "+";
    public static final String BUTTONS_SUB = "-";
    public static final String BUTTONS_MUT = "*";
    public static final String BUTTONS_DIV = "/";
    public static final String BUTTONS_POINT = ".";
    public static final String BUTTONS_ZERO = "0";


    public MyCalculatorSimple(String title) {
        this.setTitle(title);
        JTextField textField = addTextField();
        Button[] buttons = addKeyBoard();
        MyModel model = new MyModel();

        dealTextAndButtons(textField, buttons, model);

//        showCalculator();
        //在窗体事件源上添加带有处理事件的监听器。
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);//关闭窗口处理关闭动作监听事件
            }
        });
    }


    /**
     * 将显示一栏和按钮绑定操作
     *
     * @param textField 显示栏
     * @param buttons   按钮
     */
    private void dealTextAndButtons(JTextField textField, Button[] buttons, MyModel model) {
        model.clear();
        textField.setText("");
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String buttonPressed = e.getActionCommand();
                    if (buttonPressed.equals(BUTTONS_CLC)) {
                        clearTextField(textField);
                        model.clear();
                    } else if (buttonPressed.equals(BUTTONS_ZERO)) {
                        dealZeroAndPoint(textField, "0");
                    } else if (buttonPressed.equals(BUTTONS_POINT)) {
                        dealZeroAndPoint(textField, ".");
                    } else if (buttonPressed.equals(BUTTONS_EQUAL)) {
                        String num2 = textField.getText().toString().trim();
                        model.setNum2(num2);
                        String result = compute(model);
                        textField.setText(result);
                    } else if (isNotZeroDigit(buttonPressed)) {
                        String tempNum = textField.getText().toString().trim();
                        tempNum += buttonPressed;
                        textField.setText(tempNum);
                    } else if (model.getEmpty() && !model.getNum1Ok()) {
                        String num1 = textField.getText().toString().trim();
                        model.setNum1(num1);
                        model.setOp(buttonPressed);
                        model.setNum1Ok(true);
                        clearTextField(textField);
                    }
                }
            });
        }
    }


    /**
     * 解决数字按钮不是0的常规情况
     *
     * @param str
     * @return
     */
    private Boolean isNotZeroDigit(String str) {
        char c = str.charAt(0);
        if (c >= '1' && c <= '9') {
            return true;
        }
        return false;
    }

    /**
     * 计算的主角
     *
     * @param model
     * @return
     */
    private String compute(MyModel model) {
        return UtilCompute.compute(model);
    }


    /**
     * 解决字符0和.的特殊情况就是看看编辑栏是不是为空
     *
     * @param textField
     * @param str
     */
    private void dealZeroAndPoint(JTextField textField, String str) {
        String tempNum = textField.getText().toString().trim();
        if (tempNum.length() != 0) {
            tempNum += str;
            textField.setText(tempNum);
        }
    }

    /**
     * 清空编辑栏的显示
     *
     * @param textField
     */
    private void clearTextField(JTextField textField) {
        textField.setText("");
    }


    /**
     * 添加计算编辑栏
     *
     * @return text编辑对象
     */
    private JTextField addTextField() {
        JTextField text = new JTextField(30);
        text.setHorizontalAlignment(JTextField.RIGHT);
        Panel p1 = new Panel();
        p1.add(text);
        this.add(p1, BorderLayout.NORTH);
        return text;
    }


    /**
     * 添加按钮
     *
     * @return 按钮对象引用
     */
    private Button[] addKeyBoard() {
        Button[] result = new Button[BUTTONS_SUM];
        //添加第一行按钮
        Panel p2 = new Panel();
        p2.setLayout(new GridLayout(1, 2, BUTTONS_GAP, BUTTONS_GAP));
        result[INDEX_CLEAR] = new Button("Clear");
        result[INDEX_EQUAL] = new Button("=");
        p2.add(result[INDEX_CLEAR]);
        p2.add(result[INDEX_EQUAL]);
        this.add(p2);

        //添加排列比较规矩的按钮
        Panel p1 = new Panel();
        p1.setLayout(new GridLayout(3, 5, BUTTONS_GAP, BUTTONS_GAP));
        String[] name = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
                "+", "-", "*", "/", "."};
        for (int i = 0; i < name.length; i++) {
            Button button = new Button(name[i]);
            result[i + 2] = button;
            p1.add(button);
        }
        this.add(p1, BorderLayout.SOUTH);
        return result;
    }

    /**
     * 最后来展示计算器
     */
    public void showCalculator() {
        this.pack();
        this.setVisible(true);
    }
}
