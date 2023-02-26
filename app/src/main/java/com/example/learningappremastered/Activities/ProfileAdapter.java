package com.example.learningappremastered.Activities;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learningappremastered.Classes.Game;
import com.example.learningappremastered.Classes.ModelClass;
import com.example.learningappremastered.R;

import java.util.List;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileHolder> {

    private List<Game> gameList;
    private SelectListener listener;

    public ProfileAdapter(List<Game>gameList, SelectListener listener) {
        this .gameList=gameList;
        this .listener=listener;
    }

    @NonNull
    @Override
    public ProfileHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.game_design,parent,false);
        return new ProfileHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ProfileHolder holder, @SuppressLint("RecyclerView") int position) {
        int game = gameList.get(position).getResource();

        holder.setdata(game);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    listener.onItemClicked(gameList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return gameList.size();
    }

}
