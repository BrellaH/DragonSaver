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

    public static int washMachineStartHour = 0;
    public static int washMachineStartMinute = 0;
    public static int tvStartHour = 0;
    public static int tvStartMinut = 0;
    public static int washEndMachineHour = 0;
    public static int washEndMachineMinute = 0;
    public static int tvEndHour = 0;
    public static int tvEndMinut = 0;

    public static boolean homeMode = false;
    public static boolean sleepMode = false;

    public static boolean customWM = false;
    public static boolean customTV = false;

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

    public static boolean isCustomWM() {
        return customWM;
    }

    public static void setCustomWM(boolean customWM) {
        DataBase.customWM = customWM;
    }

    public static boolean isCustomTV() {
        return customTV;
    }

    public static void setCustomTV(boolean customTV) {
        DataBase.customTV = customTV;
    }

    public static int getWashMachineStartHour() {
        return washMachineStartHour;
    }

    public static void setWashMachineStartHour(int washMachineStartHour) {
        DataBase.washMachineStartHour = washMachineStartHour;
    }

    public static int getWashMachineStartMinute() {
        return washMachineStartMinute;
    }

    public static void setWashMachineStartMinute(int washMachineStartMinute) {
        DataBase.washMachineStartMinute = washMachineStartMinute;
    }

    public static int getTvStartHour() {
        return tvStartHour;
    }

    public static void setTvStartHour(int tvStartHour) {
        DataBase.tvStartHour = tvStartHour;
    }

    public static int getTvStartMinut() {
        return tvStartMinut;
    }

    public static void setTvStartMinut(int tvStartMinut) {
        DataBase.tvStartMinut = tvStartMinut;
    }

    public static int getWashEndMachineHour() {
        return washEndMachineHour;
    }

    public static void setWashEndMachineHour(int washEndMachineHour) {
        DataBase.washEndMachineHour = washEndMachineHour;
    }

    public static int getWashEndMachineMinute() {
        return washEndMachineMinute;
    }

    public static void setWashEndMachineMinute(int washEndMachineMinute) {
        DataBase.washEndMachineMinute = washEndMachineMinute;
    }

    public static int getTvEndHour() {
        return tvEndHour;
    }

    public static void setTvEndHour(int tvEndHour) {
        DataBase.tvEndHour = tvEndHour;
    }

    public static int getTvEndMinut() {
        return tvEndMinut;
    }

    public static void setTvEndMinut(int tvEndMinut) {
        DataBase.tvEndMinut = tvEndMinut;
    }

}
