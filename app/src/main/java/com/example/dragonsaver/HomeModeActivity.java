package com.example.dragonsaver;

import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;


public class HomeModeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_mode);

        final Switch home_mode_switch = (Switch) findViewById(R.id.home_mode_switch);
        final TextView wash_machine_text = findViewById(R.id.wash_machine_text);
        final TextView tv_text = findViewById(R.id.tv_text);
        final Switch wash_machine_switch = findViewById(R.id.wash_machine_switch);
        final Switch tv_switch = findViewById(R.id.tv_switch);

        home_mode_switch.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                if(home_mode_switch.isChecked()){
                    wash_machine_text.setTextColor(getResources().getColor(R.color.orange5));
                    tv_text.setTextColor(getResources().getColor(R.color.orange5));
                    wash_machine_switch.setTextColor(getResources().getColor(R.color.orange5));
                    tv_switch.setTextColor(getResources().getColor(R.color.orange5));
                }
                else{
                    wash_machine_text.setTextColor(Color.parseColor("#aaaaaa"));
                    tv_text.setTextColor(Color.parseColor("#aaaaaa"));
                    wash_machine_switch.setTextColor(Color.parseColor("#aaaaaa"));
                    tv_switch.setTextColor(Color.parseColor("#aaaaaa"));
                }
            }
        });
    }
}
