package com.xqf.test.utils;

import javax.swing.*;
import java.awt.*;

/**
 * Created by XQF on 2018/1/13.
 */
public class UtilLabel {

    public static void welcome(JLabel label) {
        label.setText("Welocme");
    }

    public static void warnDec(JLabel label) {
        label.setText("Only Dec Integer Or Decimal");
    }

    public static void warnHex(JLabel label) {
        label.setText("Only Hex Long Integer");
    }
}
