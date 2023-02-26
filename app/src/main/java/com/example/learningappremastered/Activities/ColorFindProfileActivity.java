package com.example.learningappremastered.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.example.learningappremastered.Classes.UserSettings;
import com.example.learningappremastered.R;

public class ColorFindProfileActivity extends AppCompatActivity{
    private UserSettings settings;
    Switch colorFindSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_find_profile);
        colorFindSwitch = findViewById(R.id.colorFindSwitch);
        settings = (UserSettings) getApplication();

        loadSharedPreferences();
        initSwitchListener();
        updateView();

    }

    private void loadSharedPreferences(){
        SharedPreferences sharedPreferences = getSharedPreferences(UserSettings.PREFERENCES_C, MODE_PRIVATE);
        String visibility = sharedPreferences.getString(UserSettings.CUSTOM_VISIBILITY_C, UserSettings.VISIBILITY_TRUE_C);
        settings.setCustomVisibilityC(visibility);
    }

    private void initSwitchListener(){
        colorFindSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(ColorFindProfileActivity.this, "Switch State=" + ""+isChecked, Toast.LENGTH_SHORT).show();
                if(!isChecked) {
                    settings.setCustomVisibilityC(UserSettings.VISIBILITY_FALSE_C);
                }else{
                    settings.setCustomVisibilityC(UserSettings.VISIBILITY_TRUE_C);
                    }
                SharedPreferences.Editor editor = getSharedPreferences(UserSettings.PREFERENCES_C,MODE_PRIVATE).edit();
                editor.putString(UserSettings.CUSTOM_VISIBILITY_C, settings.getCustomVisibilityC());
                editor.apply();
                updateView();
            }
        });
    }
    private void updateView() {
        if(settings.getCustomVisibilityC() == UserSettings.VISIBILITY_FALSE_C){
            colorFindSwitch.setChecked(false);
        } else {
            colorFindSwitch.setChecked(true);
        }
    }

    public void goHome(View v){
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

}