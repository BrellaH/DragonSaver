package com.example.dragonsaver;

import android.util.FloatProperty;
import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DataBase {
    public static int washing_machine = 0;
    public static int tv = 0;


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

    public static int get_tv(){
        return tv;
    }
}
