package com.example.dragonsaver;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

        select_all_switch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(select_all_switch.isChecked()){
                    wash_machine_switch.setChecked(true);
                    tv_switch.setChecked(true);

                }
                else{
                    wash_machine_switch.setChecked(false);
                    tv_switch.setChecked(false);

                }
            }
        });
    }
}
