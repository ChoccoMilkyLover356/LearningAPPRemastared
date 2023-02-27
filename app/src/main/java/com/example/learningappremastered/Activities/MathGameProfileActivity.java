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

public class MathGameProfileActivity extends AppCompatActivity{
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
        SharedPreferences sharedPreferences = getSharedPreferences(UserSettings.PREFERENCES_M, MODE_PRIVATE);
        String visibility = sharedPreferences.getString(UserSettings.CUSTOM_VISIBILITY_M, UserSettings.VISIBILITY_TRUE_M);
        settings.setCustomVisibilityM(visibility);
    }

    private void initSwitchListener(){
        colorFindSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(MathGameProfileActivity.this, "Switch State=" + ""+isChecked, Toast.LENGTH_SHORT).show();
                if(!isChecked) {
                    settings.setCustomVisibilityM(UserSettings.VISIBILITY_FALSE_M);
                }else{
                    settings.setCustomVisibilityM(UserSettings.VISIBILITY_TRUE_M);
                }
                SharedPreferences.Editor editor = getSharedPreferences(UserSettings.PREFERENCES_M,MODE_PRIVATE).edit();
                editor.putString(UserSettings.CUSTOM_VISIBILITY_M, settings.getCustomVisibilityM());
                editor.apply();
                updateView();
            }
        });
    }
    private void updateView() {
        if(settings.getCustomVisibilityM() == UserSettings.VISIBILITY_FALSE_M){
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