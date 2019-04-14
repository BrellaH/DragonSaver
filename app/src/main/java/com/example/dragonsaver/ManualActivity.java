package com.example.dragonsaver;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Switch;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class ManualActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual);


        final Switch select_all_switch = (Switch) findViewById(R.id.select_all_switch);
        final Switch wash_machine_switch = (Switch) findViewById(R.id.wash_machine_switch);
        final Switch tv_switch = (Switch) findViewById(R.id.tv_switch);


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference ref_washing_machine = database.getReference("tests/1/state");
        final DatabaseReference ref_tv = database.getReference("tests/2/state");


        select_all_switch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(select_all_switch.isChecked()){
                    wash_machine_switch.setChecked(true);
                    tv_switch.setChecked(true);
                    ref_washing_machine.setValue(1);
                    ref_tv.setValue(1);

                }
                else{
                    wash_machine_switch.setChecked(false);
                    tv_switch.setChecked(false);

                    ref_washing_machine.setValue(0);
                    ref_tv.setValue(0);
                }
            }
        });

        wash_machine_switch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(wash_machine_switch.isChecked()){
                    ref_washing_machine.setValue(0);
                }
                else{
                    ref_washing_machine.setValue(1);
                }
            }
        });

        tv_switch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tv_switch.isChecked()){
                    ref_tv.setValue(0);
                }
                else{
                    ref_tv.setValue(1);
                }
            }
        });
    }
}
