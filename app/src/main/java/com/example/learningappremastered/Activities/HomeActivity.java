package com.example.learningappremastered.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.learningappremastered.Classes.ModelClass;
import com.example.learningappremastered.R;

import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements SelectListener {

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    List<ModelClass>gameList;
    HomeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        
        initData();
        initRecyclerView();

    }

    private void goProfileActivity(View v){
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }

    private void goSettingActivity(View v){
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

    private void initData() {

        gameList = new ArrayList<>();

        gameList.add(new ModelClass(R.drawable.colorfind));

        gameList.add(new ModelClass(R.drawable.colorfind));

        gameList.add(new ModelClass(R.drawable.colorfind));

    }

    private void initRecyclerView() {

        recyclerView=findViewById(R.id.recViewGames);
        layoutManager= new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new HomeAdapter(gameList, this);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClicked(ModelClass ModelClass) {
        Toast.makeText(this, "Going to " + ModelClass.getResource(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }
}