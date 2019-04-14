package com.example.dragonsaver;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Switch;


public class ManualActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual);


        final Switch select_all_switch = (Switch) findViewById(R.id.select_all_switch);
        final Switch wash_machine_switch = (Switch) findViewById(R.id.wash_machine_switch);
        final Switch tv_switch = (Switch) findViewById(R.id.tv_switch);

        if(DataBase.get_tv() == 0){
            tv_switch.setChecked(false);
        }
        else{
            tv_switch.setChecked(true);
        }
        if(DataBase.getWashing_machine() == 0){
            wash_machine_switch.setChecked(false);
        }
        else{
            wash_machine_switch.setChecked(true);
        }

        select_all_switch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(select_all_switch.isChecked()){
                    wash_machine_switch.setChecked(true);
                    tv_switch.setChecked(true);
                    DataBase.setWashing_machine(1);
                    DataBase.setTv(1);

                }
                else{
                    wash_machine_switch.setChecked(false);
                    tv_switch.setChecked(false);
                    DataBase.setTv(0);
                    DataBase.setWashing_machine(0);
                }
            }
        });

        wash_machine_switch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(wash_machine_switch.isChecked()){
                    DataBase.setWashing_machine(1);
                }
                else{
                    DataBase.setWashing_machine(0);
                }
            }
        });

        tv_switch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tv_switch.isChecked()){
                    DataBase.setTv(1);
                }
                else{
                    DataBase.setTv(0);
                }
            }
        });
    }
}
