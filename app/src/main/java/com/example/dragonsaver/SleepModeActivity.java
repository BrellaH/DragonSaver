package com.example.dragonsaver;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v4.widget.CompoundButtonCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SleepModeActivity extends AppCompatActivity {




    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep_mode);

        final TextView wakeTime1 = findViewById(R.id.wake_time_text);
        final TextView wakeTime2= findViewById(R.id.wake_time_textView);
        final TextView sleepTime1 = findViewById(R.id.bed_time_text);
        final TextView sleepTime2 = findViewById(R.id.bed_time_textView);
        final TextView washMachineT = findViewById(R.id.wash_machine_text);
        final TextView tvT = findViewById(R.id.tv_text);
        final CheckBox washMachineCB = findViewById(R.id.wash_machine_checkBox);
        final CheckBox tvCB = findViewById(R.id.tv_checkBox);
        int states[][] = {{android.R.attr.state_checked},{-android.R.attr.state_checked}};
        int mute_colors[] = {Color.parseColor("#aaaaaa"),Color.parseColor("#aaaaaa")};
        final ColorStateList muted_checkBoxColorState = new ColorStateList(states, mute_colors);
        int colors[] = {getResources().getColor(R.color.orange5),getResources().getColor(R.color.orange5)};
        final ColorStateList unmuted_checkBoxColorState = new ColorStateList(states, colors);
        final Switch sleep_mode_switch = findViewById(R.id.sleep_mode_switch);


        Calendar c = android.icu.util.Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date(Calendar.YEAR, Calendar.MONTH, Calendar.DAY_OF_MONTH, DataBase.getSleepHour(), DataBase.getSleepMinute());
        String dateResult = dateFormat.format(date);

        TextView bedTimeText = (TextView) findViewById(R.id.bed_time_textView);
        bedTimeText.setText(dateResult);
        Log.d("time",dateResult);
        TextView wakeTimeText = (TextView) findViewById(R.id.wake_time_textView);

        date = new Date(Calendar.YEAR, Calendar.MONTH, Calendar.DAY_OF_MONTH, DataBase.getWakeHour(), DataBase.getWakeMinute());
        wakeTimeText.setText(dateFormat.format(date));


        if(DataBase.getSleepMode()){
            turnOnSleepMode();

        }else{
            turnOffSleepMode();
        }


        sleep_mode_switch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sleep_mode_switch.isChecked()){
                    turnOnSleepMode();
                }
                else{
                    turnOffSleepMode();
                }
            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void turnOffSleepMode() {
        final TextView wakeTime1 = findViewById(R.id.wake_time_text);
        final TextView wakeTime2= findViewById(R.id.wake_time_textView);
        final TextView sleepTime1 = findViewById(R.id.bed_time_text);
        final TextView sleepTime2 = findViewById(R.id.bed_time_textView);
        final TextView washMachineT = findViewById(R.id.wash_machine_text);
        final TextView tvT = findViewById(R.id.tv_text);
        final CheckBox washMachineCB = findViewById(R.id.wash_machine_checkBox);
        final CheckBox tvCB = findViewById(R.id.tv_checkBox);
        int states[][] = {{android.R.attr.state_checked},{-android.R.attr.state_checked}};
        int mute_colors[] = {Color.parseColor("#aaaaaa"),Color.parseColor("#aaaaaa")};
        final ColorStateList muted_checkBoxColorState = new ColorStateList(states, mute_colors);
        int colors[] = {getResources().getColor(R.color.orange5),getResources().getColor(R.color.orange5)};
        final Switch sleep_mode_switch = findViewById(R.id.sleep_mode_switch);

        DataBase.setSleepMode(false);
        sleep_mode_switch.setChecked(false);
        wakeTime1.setTextColor(Color.parseColor("#aaaaaa"));
        wakeTime2.setTextColor(Color.parseColor("#aaaaaa"));
        sleepTime1.setTextColor(Color.parseColor("#aaaaaa"));
        sleepTime2.setTextColor(Color.parseColor("#aaaaaa"));
        washMachineT.setTextColor(Color.parseColor("#aaaaaa"));
        tvT.setTextColor(Color.parseColor("#aaaaaa"));
        CompoundButtonCompat.setButtonTintList(washMachineCB,muted_checkBoxColorState);
        CompoundButtonCompat.setButtonTintList(tvCB,muted_checkBoxColorState);
        wakeTime2.setClickable(false);
        sleepTime2.setClickable(false);
        washMachineCB.setClickable(false);
        tvCB.setClickable(false);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void turnOnSleepMode(){
        final TextView wakeTime1 = findViewById(R.id.wake_time_text);
        final TextView wakeTime2= findViewById(R.id.wake_time_textView);
        final TextView sleepTime1 = findViewById(R.id.bed_time_text);
        final TextView sleepTime2 = findViewById(R.id.bed_time_textView);
        final TextView washMachineT = findViewById(R.id.wash_machine_text);
        final TextView tvT = findViewById(R.id.tv_text);
        final CheckBox washMachineCB = findViewById(R.id.wash_machine_checkBox);
        final CheckBox tvCB = findViewById(R.id.tv_checkBox);
        int states[][] = {{android.R.attr.state_checked},{-android.R.attr.state_checked}};
        int colors[] = {getResources().getColor(R.color.orange5),getResources().getColor(R.color.orange5)};
        final ColorStateList unmuted_checkBoxColorState = new ColorStateList(states, colors);
        final Switch sleep_mode_switch = findViewById(R.id.sleep_mode_switch);
        DataBase.setSleepMode(true);
        sleep_mode_switch.setChecked(true);
        wakeTime1.setTextColor(getResources().getColor(R.color.orange1));
        wakeTime2.setTextColor(getResources().getColor(R.color.orange1));
        sleepTime1.setTextColor(getResources().getColor(R.color.orange1));
        sleepTime2.setTextColor(getResources().getColor(R.color.orange1));
        washMachineT.setTextColor(getResources().getColor(R.color.orange5));
        tvT.setTextColor(getResources().getColor(R.color.orange5));
        CompoundButtonCompat.setButtonTintList(washMachineCB,unmuted_checkBoxColorState);
        CompoundButtonCompat.setButtonTintList(tvCB,unmuted_checkBoxColorState);
        wakeTime2.setClickable(true);
        sleepTime2.setClickable(true);
        washMachineCB.setClickable(true);
        tvCB.setClickable(true);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void showTimePickerDialog(View v) {
        Bundle args = new Bundle();
        args.putInt("id",v.getId());
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.setArguments(args);
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }

}

