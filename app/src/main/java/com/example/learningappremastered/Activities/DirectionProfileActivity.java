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

public class DirectionProfileActivity extends AppCompatActivity{
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


    }

    private void loadSharedPreferences(){
        SharedPreferences sharedPreferences = getSharedPreferences(UserSettings.PREFERENCES_D, MODE_PRIVATE);
        String visibility = sharedPreferences.getString(UserSettings.CUSTOM_VISIBILITY_D, UserSettings.VISIBILITY_TRUE_D);
        settings.setCustomVisibilityD(visibility);
    }

    private void initSwitchListener(){
        colorFindSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(DirectionProfileActivity.this, "Switch State=" + ""+isChecked, Toast.LENGTH_SHORT).show();
                if(isChecked) {
                    settings.setCustomVisibilityD(UserSettings.VISIBILITY_FALSE_D);
                }else{
                    settings.setCustomVisibilityD(UserSettings.VISIBILITY_TRUE_D);
                }
                SharedPreferences.Editor editor = getSharedPreferences(UserSettings.PREFERENCES_D,MODE_PRIVATE).edit();
                editor.putString(UserSettings.CUSTOM_VISIBILITY_D, settings.getCustomVisibilityD());
                editor.apply();
                updateView();
            }
        });
    }
    private void updateView() {
        if(settings.getCustomVisibilityD() == UserSettings.VISIBILITY_FALSE_D){
            colorFindSwitch.setChecked(true);
        } else {
            colorFindSwitch.setChecked(false);
        }
    }

    public void goHome(View v){
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

}