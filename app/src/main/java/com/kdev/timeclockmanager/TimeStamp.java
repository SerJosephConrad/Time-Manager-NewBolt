package com.kdev.timeclockmanager;

/**
 * Created by Ben on 8/4/2014.
 */
public class TimeStamp {

    public int mHour, mMinute, mSecond, mDay, mYear;
    public String mMonth;


    public TimeStamp(int mHour, int mMinute, int mSecond, int mDay, int mYear) {
        this.mHour = mHour;
        this.mMinute = mMinute;
        this.mSecond = mSecond;
        this.mDay = mDay;
        this.mYear = mYear;
    }

    public String toPrintableFormat(){

        String tempHour = String.valueOf(this.getHour());
        String tempMinute = String.valueOf(this.getMinute());
        String tempSecond = String.valueOf(this.getSecond());
        String tempDay = String.valueOf(this.getDay());
        String tempYear = String.valueOf(this.getYear());

        String printable = tempYear + " Years, " + tempDay + " Days, " + tempHour + " Hours, " + tempMinute + " Minutes, " + tempSecond + " Seconds";
        return printable;
    }

    public int getHour() {
        return mHour;
    }

    public void setHour(int mHour) {
        this.mHour = mHour;
    }

    public int getMinute() {
        return mMinute;
    }

    public void setMinute(int mMinute) {
        this.mMinute = mMinute;
    }

    public int getSecond() {
        return mSecond;
    }

    public void setSecond(int mSecond) {
        this.mSecond = mSecond;
    }

    public int getDay() {
        return mDay;
    }

    public void setDay(int mDay) {
        this.mDay = mDay;
    }

    public int getYear() {
        return mYear;
    }

    public void setYear(int mYear) {
        this.mYear = mYear;
    }
    public String getMonth(){
        return mMonth;
    }
    public void setMonth(String mMonth){
        this.mMonth = mMonth;
    }
}
