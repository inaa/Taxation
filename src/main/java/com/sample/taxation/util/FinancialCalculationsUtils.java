package com.sample.taxation.util;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class FinancialCalculationsUtils {
    
    private static final int DECIMAL_PLACES = 2;

    public static double percentToDecimal(double percentage) {
        return percentage / 100.0;
    }

    public static double decimalToPercent(double decimal) {
        return decimal * 100.0;
    }

    public static double roundToTwoDecimalPlaces(double amount) {
        BigDecimal bd = new BigDecimal(amount);
        bd = bd.setScale(DECIMAL_PLACES, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

}