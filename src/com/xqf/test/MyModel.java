package com.xqf.test;

/**
 * 一次计算的数据结构
 * Created by XQF on 2018/1/12.
 */
public class MyModel {

    private String num1;//第一个数字
    private String num2;//第二个数字
    private String op;//中间的操作符
    private Boolean isOk;//是否填装完成
    private Boolean isNum1Ok;//第一个数字是不是好了
    private Boolean isEmpty;//是不是为空


    public Boolean getNum1Ok() {
        if (num1.length() == 0) {
            return false;
        } else {
            return true;
        }
    }

    public void setNum1Ok(Boolean num1Ok) {
        isNum1Ok = num1Ok;
    }



    public Boolean getEmpty() {
        return isEmpty;
    }

    public void setEmpty(Boolean empty) {
        isEmpty = empty;
    }

    public Boolean getOk() {
        if (num1.length() != 0 && num2.length() != 0) {
            return true;
        } else {
            return false;
        }

    }

    public void setOk(Boolean ok) {
        isOk = ok;
    }

    public String getNum1() {
        return num1;
    }

    public void setNum1(String num1) {
        this.num1 = num1;
    }

    public String getNum2() {

        return num2;
    }

    public void setNum2(String num2) {
        this.num2 = num2;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public void clear() {
        num1 = "";
        num2 = "";
        op = "";
        isNum1Ok = false;
        isEmpty = true;
        isOk = false;
    }
}
