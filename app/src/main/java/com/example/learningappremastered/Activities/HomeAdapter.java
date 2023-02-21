package com.example.learningappremastered.Activities;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learningappremastered.Classes.ModelClass;
import com.example.learningappremastered.R;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeHolder> {

    private List<ModelClass> gameList;

    public HomeAdapter (List<ModelClass>gamelist) { this .gameList=gameList; }

    @NonNull
    @Override
    public HomeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.game_design,parent,false);
        return new HomeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeHolder holder, int position) {
        int game= gameList.get(position).getColorFind();

        holder.setdata(game);
    }

    @Override
    public int getItemCount() {
        return gameList.size();
    }

}
