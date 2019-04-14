package com.example.dragonsaver;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.widget.CompoundButtonCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
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

        final CheckBox wash_machine_checkBox = (CheckBox) findViewById(R.id.wash_machine_checkBox);
        final CheckBox tv_checkBox = (CheckBox) findViewById(R.id.tv_checkBox);


        int states[][] = {{android.R.attr.state_checked},{-android.R.attr.state_checked}};
        int mute_colors[] = {Color.parseColor("#aaaaaa"),Color.parseColor("#aaaaaa")};
        final ColorStateList muted_checkBoxColorState = new ColorStateList(states, mute_colors);
        int colors[] = {getResources().getColor(R.color.orange5),getResources().getColor(R.color.orange5)};
        final ColorStateList unmuted_checkBoxColorState = new ColorStateList(states, colors);


        if(home_mode_switch.isChecked()){
            wash_machine_text.setTextColor(getResources().getColor(R.color.orange5));
            tv_text.setTextColor(getResources().getColor(R.color.orange5));

            CompoundButtonCompat.setButtonTintList(wash_machine_checkBox, unmuted_checkBoxColorState);
            CompoundButtonCompat.setButtonTintList(tv_checkBox, unmuted_checkBoxColorState);
        }
        else{
            wash_machine_text.setTextColor(Color.parseColor("#aaaaaa"));
            tv_text.setTextColor(Color.parseColor("#aaaaaa"));
            wash_machine_checkBox.setClickable(false);
            tv_checkBox.setClickable(false);

            CompoundButtonCompat.setButtonTintList(wash_machine_checkBox, muted_checkBoxColorState);
            CompoundButtonCompat.setButtonTintList(tv_checkBox, muted_checkBoxColorState);
        }
        home_mode_switch.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.P)
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                if(home_mode_switch.isChecked()){
                    wash_machine_text.setTextColor(getResources().getColor(R.color.orange5));
                    tv_text.setTextColor(getResources().getColor(R.color.orange5));
                    wash_machine_checkBox.setTextColor(getResources().getColor(R.color.orange5));
                    tv_checkBox.setTextColor(getResources().getColor(R.color.orange5));

                    CompoundButtonCompat.setButtonTintList(wash_machine_checkBox, unmuted_checkBoxColorState);
                    CompoundButtonCompat.setButtonTintList(tv_checkBox, unmuted_checkBoxColorState);

                    wash_machine_checkBox.setClickable(true);
                    tv_checkBox.setClickable(true);
                }
                else{
                    wash_machine_text.setTextColor(Color.parseColor("#aaaaaa"));
                    tv_text.setTextColor(Color.parseColor("#aaaaaa"));

                    CompoundButtonCompat.setButtonTintList(wash_machine_checkBox, muted_checkBoxColorState);
                    CompoundButtonCompat.setButtonTintList(tv_checkBox, muted_checkBoxColorState);

                    wash_machine_checkBox.setClickable(false);
                    tv_checkBox.setClickable(false);
                }
            }
        });
    }
}
