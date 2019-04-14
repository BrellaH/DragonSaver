package com.example.dragonsaver;

import android.app.Activity;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.text.format.DateFormat;
import android.util.FloatProperty;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Date;

@RequiresApi(api = Build.VERSION_CODES.N)
public class DataBase {
    public static int washing_machine = 0;
    public static int tv = 0;


    public static int sleepHour = 0;
    public static int sleepMinute = 0;


    public static int wakeHour = 0;
    public static int wakeMinute = 0;

    public static boolean homeMode = false;
    public static boolean sleepMode = false;

    public static void setWashing_machine(int washing_machine) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref_washing_machine = database.getReference("tests/1/state");
        Log.d("test",String.valueOf(washing_machine));
        DataBase.washing_machine = washing_machine;
        ref_washing_machine.setValue(washing_machine);
    }
    public static void setTv(int tv){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref_tv = database.getReference("tests/2/state");
        Log.d("test",String.valueOf(tv));
        DataBase.tv = tv;
        ref_tv.setValue(tv);
    }

    public static int getWashing_machine(){
        return washing_machine;
    }

    public static int getTv(){
        return tv;
    }

    public static int getSleepHour() {
        return sleepHour;
    }

    public static void setSleepHour(int sleepHour) {
        DataBase.sleepHour = sleepHour;
    }

    public static int getSleepMinute() {
        return sleepMinute;
    }

    public static void setSleepMinute(int sleepMinute) {
        DataBase.sleepMinute = sleepMinute;
    }

    public static int getWakeHour() {
        return wakeHour;
    }

    public static void setWakeHour(int wakeHour) {
        DataBase.wakeHour = wakeHour;
    }

    public static int getWakeMinute() {
        return wakeMinute;
    }

    public static void setWakeMinute(int wakeMinute) {
        DataBase.wakeMinute = wakeMinute;
    }

    public static boolean getHomeMode() {
        return homeMode;
    }

    public static void setHomeMode(boolean homeMode) {
        DataBase.homeMode = homeMode;
    }

    public static boolean getSleepMode() {
        return sleepMode;
    }

    public static void setSleepMode(boolean sleepMode) {
        DataBase.sleepMode = sleepMode;
    }

}
