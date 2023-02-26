package com.example.learningappremastered.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.learningappremastered.Classes.Game;
import com.example.learningappremastered.Classes.UserSettings;
import com.example.learningappremastered.R;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements SelectListener {

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    List<Game>gameList;
    HomeAdapter adapter;

    private UserSettings settings;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        settings = (UserSettings) getApplication();

        initData();
        initRecyclerView();
    }

    protected void onResume() {
        super.onResume();
        updateGameList();
    }

    private void updateGameList() {
        if(settings.getCustomVisibilityC() == UserSettings.VISIBILITY_FALSE_C){
            gameList.set(0,new Game("ColorFindActivity", R.drawable.colorfind, false));
        } else {
            gameList.set(0,new Game("ColorFindActivity", R.drawable.colorfind, true));
        }

        if(settings.getCustomVisibilityM() == UserSettings.VISIBILITY_FALSE_M){
            gameList.add(1,new Game("MathGameActivity", R.drawable.mathgame, false));
        } else {
            gameList.add(1,new Game("MathGameActivity", R.drawable.mathgame, true));
        }

        if(settings.getCustomVisibilityD() == UserSettings.VISIBILITY_FALSE_D){
            gameList.add(2,new Game("DirectionActivity", R.drawable.directions, false));
        } else {
            gameList.add(2,new Game("DirectionActivity", R.drawable.directions, true));
        }
    }

    public void goProfileActivity(View v){
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }

    public void goSettingActivity(View v){
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

    private void initData() {

        gameList = new ArrayList<>();

        gameList.add(new Game("ColorFindActivity", R.drawable.colorfind, true));

        gameList.add(new Game("MathGameActivity", R.drawable.mathgame, true));

        gameList.add(new Game("DirectionActivity", R.drawable.directions, true));


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
    public void onItemClicked(Game Game) {
        Toast.makeText(this, "Going to " + Game.getName(), Toast.LENGTH_SHORT).show();
        String goTo = Game.getName();
        Intent intent = null;
        if(goTo.equals("ColorFindActivity")) {
            intent = new Intent(this, ColorFindActivity.class);
        }
        if(goTo.equals("MathGameActivity")) {
            intent = new Intent(this, MathGameActivity.class);
        }
        if(goTo.equals("DirectionActivity")) {
            intent = new Intent(this, DirectionActivity.class);
        }
        startActivity(intent);
    }

}