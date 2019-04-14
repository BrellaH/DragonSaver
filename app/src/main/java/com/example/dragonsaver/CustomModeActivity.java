package com.example.dragonsaver;

import android.graphics.Color;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomModeActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_mode);

        TextView washMachineText = findViewById(R.id.wash_machine_text);
        TextView tvText = findViewById(R.id.tv_text);
        final CheckBox washMachineCB = findViewById(R.id.wash_machine_checkBox);
        final CheckBox tvCB = findViewById(R.id.tv_checkBox);
        TextView tvStart = findViewById(R.id.tv_start_time);
        TextView tvEnd = findViewById(R.id.tv_end_time);
        TextView wmStart = findViewById(R.id.wash_machine_start_time);
        TextView wmEnd = findViewById(R.id.wash_machine_end_time);

        Calendar c = android.icu.util.Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date(Calendar.YEAR, Calendar.MONTH, Calendar.DAY_OF_MONTH, DataBase.getWashMachineStartHour(), DataBase.getWashMachineStartMinute());
        String dateResult = dateFormat.format(date);
        wmStart.setText(dateResult);

        date = new Date(Calendar.YEAR, Calendar.MONTH, Calendar.DAY_OF_MONTH, DataBase.getWashEndMachineHour(), DataBase.getWashEndMachineMinute());
        wmEnd.setText(dateFormat.format(date));

        date = new Date(Calendar.YEAR, Calendar.MONTH, Calendar.DAY_OF_MONTH, DataBase.getTvStartHour(), DataBase.getTvStartMinut());
        tvStart.setText(dateFormat.format(date));

        date = new Date(Calendar.YEAR, Calendar.MONTH, Calendar.DAY_OF_MONTH, DataBase.getTvEndHour(), DataBase.getTvEndMinut());
        tvEnd.setText(dateFormat.format(date));


        if(DataBase.isCustomWM()){
            turnOnWashMachineCustom();
        }
        else{
            turnOffWashMachineCustom();
        }
        if(DataBase.isCustomTV()){
            turnOnTVCustom();
        }
        else{
            turnOffTVCustom();
        }

        washMachineCB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (washMachineCB.isChecked()) {
                    turnOnWashMachineCustom();
                }
                else{
                    turnOffWashMachineCustom();
                }
            }

        });
        tvCB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tvCB.isChecked()){
                    turnOnTVCustom();
                }
                else{
                    turnOffTVCustom();
                }
            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void turnOffTVCustom() {
        TextView washMachineText = findViewById(R.id.wash_machine_text);
        TextView tvText = findViewById(R.id.tv_text);
        final CheckBox washMachineCB = findViewById(R.id.wash_machine_checkBox);
        CheckBox tvCB = findViewById(R.id.tv_checkBox);
        TextView tvStart = findViewById(R.id.tv_start_time);
        TextView tvEnd = findViewById(R.id.tv_end_time);

        DataBase.setCustomTV(false);
        tvCB.setChecked(false);
        tvText.setTextColor(Color.parseColor("#aaaaaa"));
        tvStart.setClickable(false);
        tvEnd.setClickable(false);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void turnOnTVCustom() {
        Log.d("test","hello?");
        TextView washMachineText = findViewById(R.id.wash_machine_text);
        TextView tvText = findViewById(R.id.tv_text);
        final CheckBox washMachineCB = findViewById(R.id.wash_machine_checkBox);
        CheckBox tvCB = findViewById(R.id.tv_checkBox);
        TextView tvStart = findViewById(R.id.tv_start_time);
        TextView tvEnd = findViewById(R.id.tv_end_time);

        DataBase.setCustomTV(true);
        tvCB.setChecked(true);
        tvText.setTextColor(getResources().getColor(R.color.orange5));
        tvStart.setClickable(true);
        tvEnd.setClickable(true);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void turnOffWashMachineCustom() {
        TextView washMachineText = findViewById(R.id.wash_machine_text);
        TextView tvText = findViewById(R.id.tv_text);
        final CheckBox washMachineCB = findViewById(R.id.wash_machine_checkBox);
        CheckBox tvCB = findViewById(R.id.tv_checkBox);
        TextView washStart = findViewById(R.id.wash_machine_start_time);
        TextView washEnd = findViewById(R.id.wash_machine_end_time);

        DataBase.setCustomWM(false);
        washMachineCB.setChecked(false);
        washMachineText.setTextColor(Color.parseColor("#aaaaaa"));
        washStart.setClickable(false);
        washEnd.setClickable(false);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void turnOnWashMachineCustom() {
        TextView washMachineText = findViewById(R.id.wash_machine_text);
        TextView tvText = findViewById(R.id.tv_text);
        final CheckBox washMachineCB = findViewById(R.id.wash_machine_checkBox);
        CheckBox tvCB = findViewById(R.id.tv_checkBox);
        TextView washStart = findViewById(R.id.wash_machine_start_time);
        TextView washEnd = findViewById(R.id.wash_machine_end_time);

        DataBase.setCustomWM(true);
        washMachineCB.setChecked(true);
        washMachineText.setTextColor(getResources().getColor(R.color.orange5));
        washStart.setClickable(true);
        washEnd.setClickable(true);
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
