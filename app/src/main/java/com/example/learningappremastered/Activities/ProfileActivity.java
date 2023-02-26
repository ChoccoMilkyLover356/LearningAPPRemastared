package com.example.learningappremastered.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.learningappremastered.Classes.Game;
import com.example.learningappremastered.Classes.ModelClass;
import com.example.learningappremastered.R;

import java.util.ArrayList;
import java.util.List;

public class ProfileActivity extends AppCompatActivity implements SelectListener {

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    List<Game> gameList;
    ProfileAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        initData();
        initRecyclerView();

    }

    private void initData() {

        gameList = new ArrayList<>();

        gameList.add(new Game("ColorFindActivity", R.drawable.colorfind, true));

        gameList.add(new Game("MathGameActivity", R.drawable.mathgame, true));

        gameList.add(new Game("DirectionActivity", R.drawable.directions, true));

    }

    private void initRecyclerView() {

        recyclerView=findViewById(R.id.recyclerViewProfile);
        layoutManager= new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new ProfileAdapter(gameList, this);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClicked(Game Game) {
        Toast.makeText(this, "Going to " + Game.getName(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, ColorFindProfileActivity.class);
        startActivity(intent);
    }

}