package com.example.learningappremastered.Activities;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learningappremastered.R;

public class HomeHolder extends RecyclerView.ViewHolder {

    private ImageView resource;

    private boolean visible;
    protected CardView cardView;

    public HomeHolder(@NonNull View itemView) {
        super(itemView);

        resource = itemView.findViewById(R.id.ColorFind);
        cardView = itemView.findViewById(R.id.imageview);

    }

    public void setdata(int game) {
        resource.setImageResource(game);
    }
}
