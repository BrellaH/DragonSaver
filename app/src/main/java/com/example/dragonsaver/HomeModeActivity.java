package com.example.dragonsaver;

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
        TextView wash_machine_text = findViewById(R.id.wash_machine_text);
        TextView tv_text = findViewById(R.id.tv_text);
        final Switch wash_machine_switch = findViewById(R.id.wash_machine_switch);
        Switch tv_switch = findViewById(R.id.tv_switch);

        home_mode_switch.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                if(home_mode_switch.isChecked()){

                }
                else{
                }
            }
        });
    }
}
