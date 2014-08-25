package com.kdev.timeclockmanager;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//TODO: Convert a hourly pay setting to the "earned per shift" value
public class MainScreen extends ActionBarActivity {

    Button clockButton;
    TextView textTimeDiff;
    public boolean clockedIn = false;
    SharedPreferences sprefs;
    SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    long defaultValue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        clockButton = (Button)findViewById(R.id.clock);
        textTimeDiff = (TextView)findViewById(R.id.timeDifference);
        sprefs = getSharedPreferences(getString(R.string.accessKey), MODE_PRIVATE);
        setListeners();

    }

    private void setListeners() {
        clockButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                Log.d("Working", "OnClick");



                /*Calendar c = Calendar.getInstance();
                int hour = c.get(Calendar.HOUR);
                int minute = c.get(Calendar.MINUTE);
                int second = c.get(Calendar.SECOND);
                int day = c.get(Calendar.DAY_OF_MONTH);
                int month = c.get(Calendar.MONTH);
                int year = c.get(Calendar.YEAR);

                //Debug
                Log.d("Debug", "" + hour);
                Log.d("Debug", "" + minute);
                Log.d("Debug", "" + second);
                Log.d("Debug", "" + day);
                Log.d("Debug", "" + year);

                ///////////////////////////

                String timeString = TimeUtils.getDateString(hour, minute, second, month, day, year);*/



                /*Clocking Out*/
                if(clockedIn){

                    //TODO: Set up recall of SharedPreferences previous time
                    clockButton.setBackgroundColor(Color.parseColor("#479030"));

                    long prevTime = sprefs.getLong(getString(R.string.PrefsAccessKey), defaultValue);
                    long currTime = System.nanoTime() / 1000000;
                    double timeDifference = TimeUtils.getDifferenceHours(currTime, prevTime);
                    textTimeDiff.setText("Hours Passed: " + CurrencyHelper.toTwoDecimalPlaces(timeDifference));


                }
                /*Clocking In*/
                else{
                    //TODO: Set up SharedPreferences to save for later recall
                    clockButton.setBackgroundColor(Color.parseColor("#a23645"));

                    long time = System.nanoTime();

                    SharedPreferences.Editor editor = sprefs.edit();
                    editor.putLong(getString(R.string.PrefsAccessKey), time/1000000);
                    editor.commit();



                }
                clockedIn = !clockedIn;
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
