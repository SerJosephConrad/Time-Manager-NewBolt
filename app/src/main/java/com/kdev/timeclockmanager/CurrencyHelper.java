package com.kdev.timeclockmanager;


import java.text.DecimalFormat;

public class CurrencyHelper {

    public static String toTwoDecimalPlaces(Double x){

        DecimalFormat df = new DecimalFormat("###,##0,00");


        return df.format(x);
    }
}
