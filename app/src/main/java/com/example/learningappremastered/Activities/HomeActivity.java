package com.example.learningappremastered.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.learningappremastered.Classes.ModelClass;
import com.example.learningappremastered.R;

import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    List<ModelClass>gameList;
    HomeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        
        initData();
        initRectlerView();

    }

    private void initData() {

        gameList = new ArrayList<>();

        gameList.add(new ModelClass(R.drawable.colorFind));

        gameList.add(new ModelClass(R.drawable.colorFind));

        gameList.add(new ModelClass(R.drawable.colorFind));

    }

    private void initRectlerView() {

        recyclerView=findViewById(R.id.recViewGames);
        layoutManager= new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        adapter=new HomeAdapter(gameList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

}