package com.xqf.test.utils;

import com.xqf.test.MyModel;

import java.math.BigDecimal;

/**
 * 简易计算器
 * Created by XQF on 2018/1/12.
 */
public class UtilCompute {
    public static String compute(MyModel model) {
        BigDecimal result = null;
        String op = model.getOp();
        BigDecimal num1 = new BigDecimal(model.getNum1());
        BigDecimal num2 = new BigDecimal(model.getNum2());

        if(model.getNum2().equals("0")||model.getNum2().equals("0.0")){
            return "0 can't be molecular!";
        }
        switch (op) {
            case "+":
                result = num1.add(num2);
                break;
            case "-":
                result = num1.subtract(num2);
                break;
            case "*":
                result = num1.multiply(num2);
                break;
            case "/":
                result = num1.divide(num2);
                break;
            default:
                break;
        }
        return result.toPlainString();
    }

    /**
     * 十进制计算，正负数没问题,小数也是没问题的
     *
     * @param model
     * @return
     */
    public static String computeByDec(MyModel model) {
        return compute(model);
    }

    /**
     * 十六进制计算
     *
     * @param model
     * @return
     */

    public static String computeByHex(MyModel model) {
        return compute(model);
    }


    public static void main(String[] args) throws Exception {
        MyModel model = new MyModel();
        model.setNum1("11.3");
        model.setNum2("-2");
        model.setOp("+");
        System.out.println(UtilCompute.compute(model));
    }
}
