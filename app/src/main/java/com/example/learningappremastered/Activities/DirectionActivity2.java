package com.example.learningappremastered.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.learningappremastered.R;

public class DirectionActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_direction2);
    }
    public void goHome(View v){
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}