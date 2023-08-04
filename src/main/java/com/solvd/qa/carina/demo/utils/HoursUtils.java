package com.solvd.qa.carina.demo.utils;

public class HoursUtils {
    public static int addHoursCheck(int base, int hour) {
        if ((base + hour) > 12) {
            return base + hour - 12;
        }
        return base + hour;
    }
}
