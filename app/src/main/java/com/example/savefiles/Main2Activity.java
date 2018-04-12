package com.example.savefiles;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        SharedPreferences sharedPreferences = getSharedPreferences("MyApplication", Context.MODE_PRIVATE);
        String data = sharedPreferences.getString("key", "default value");

        TextView textView = findViewById(R.id.am2_text_view);
        textView.setText(data);
    }
}
