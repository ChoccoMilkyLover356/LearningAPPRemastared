package com.example.learningappremastered.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.learningappremastered.R;

public class MathGameActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_game2);
    }
    public void goHome(View v){
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    public void goNext(View v){
        Intent intent = new Intent(this, ColorFindActivity2.class);
        startActivity(intent);
    }
}