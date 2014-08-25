package com.kdev.timeclockmanager;

import android.util.Log;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class TimeUtils {


    /**
     * Returns the difference in time between the two parameters
     *
     * @param currTime The Later Time
     * @param prevTime The Earlier Time
     * @return Number of hours between
     */

    public static double getDifferenceHours(long currTime, long prevTime) {


        //TODO: Fix rounding errors associated with seconds and subsequent calculations
        long x = currTime - prevTime;
        Log.d("getDifferenceHours", "currTime: " + currTime);
        Log.d("getDifferenceHours", "prevTime: " + prevTime);

        Log.d("getDifferenceHours", "diff: " + Long.toString(x));
        double y = x / 1000;
        Log.d("getDifferenceHours", "y: " + y);
        double z = y / 60;
        Log.d("getDifferenceHours", "z: " + z);
        double c = z / 60;
        Log.d("getDifferenceHours", "c: " + c);
        return c;
    }


    /**
     * Turns all of the parameters into a single string which can be parsed by the SimpleDateFormat of "MM/dd/yyyy HH:mm:ss".
     *
     * @param hour   The 24 hour time
     * @param minute The Minute of the hour
     * @param second The Second of the minute
     * @param month  The Month as an integer
     * @param day    The Day of the month
     * @param year   The year
     * @return SimpleDateFormat parsable string
     */
    public static String getDateString(int hour, int minute, int second, int month, int day, int year) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(month);
        stringBuilder.append("/");
        stringBuilder.append(day);
        stringBuilder.append("/");
        stringBuilder.append(year);
        stringBuilder.append(" ");
        stringBuilder.append(hour);
        stringBuilder.append(":");
        stringBuilder.append(minute);
        stringBuilder.append(":");
        stringBuilder.append(second);
        return stringBuilder.toString();

    }


}
