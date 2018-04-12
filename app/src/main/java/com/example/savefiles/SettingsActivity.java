package com.example.savefiles;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Switch;

public class SettingsActivity extends AppCompatActivity {

    public static final String settings_name = "mysettings";
    public static final String settings_inplane = "Inplane"; // В самолете
    public static final String settings_wifi = "Wifi"; // WIFI
    public static final String settings_bluetooth = "Bluetooth"; // Bluetooth
    Boolean isChecked_inplane;
    Boolean isChecked_wifi;
    Boolean isChecked_bluetooth;
    SharedPreferences mSettings;
    private Button back_btn;
    private Switch switch_inplane;
    private Switch switch_wifi;
    private RadioButton radio_bluetooth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        back_btn = findViewById(R.id.as_back_btn);
        back_btn.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        });


//        ///////////////////////////////////////////////
        switch_inplane = findViewById(R.id.as_inplane_switch);
        switch_wifi = findViewById(R.id.as_wifi_switch);
        radio_bluetooth = findViewById(R.id.as_bluetooth_radio);

//        /////////////////////////////////////////////////////

        switch_inplane.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                isChecked_inplane = switch_inplane.isChecked();
                SavePreferences("key_inplane", isChecked_inplane);
            }
        });

        switch_wifi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                isChecked_wifi = switch_wifi.isChecked();
                SavePreferences("key_wifi", isChecked_wifi);
            }
        });

        radio_bluetooth.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                isChecked_bluetooth = radio_bluetooth.isChecked();
                SavePreferences("key_bluetooth", isChecked_bluetooth);
            }
        });


        //        //////////////////////////////////////////////

        LoadPreferences();
    }

    private void SavePreferences(String key, boolean value) {
        SharedPreferences sharedPreferences = getSharedPreferences(
                settings_name, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.putBoolean(key, value);
        editor.putBoolean(key, value);
        editor.apply();
    }

    private void LoadPreferences() {
        SharedPreferences sharedPreferences = getSharedPreferences(settings_name, MODE_PRIVATE);
        Boolean saved_airplane = sharedPreferences.getBoolean("key_inplane", false);
        Boolean saved_wifi = sharedPreferences.getBoolean("key_wifi", false);
        Boolean saved_bluetooth = sharedPreferences.getBoolean("key_bluetooth", false);
        switch_inplane.setChecked(saved_airplane);
        switch_wifi.setChecked(saved_wifi);
        radio_bluetooth.setChecked(saved_bluetooth);
    }
}
