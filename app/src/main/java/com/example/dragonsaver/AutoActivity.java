package com.example.dragonsaver;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class AutoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto);

        Button sleep_mode = (Button) findViewById(R.id.sleep_button);
        Button home_mode = (Button) findViewById(R.id.home_button);
        Button custom_mode = (Button) findViewById(R.id.custom_button);

        sleep_mode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AutoActivity.this, SleepModeActivity.class));
            }
        });
        home_mode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AutoActivity.this, HomeModeActivity.class));
            }
        });
        custom_mode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AutoActivity.this, CustomModeActivity.class));
            }
        });
    }
}
