package com.example.learningappremastered.Activities;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learningappremastered.R;

public class HomeHolder extends RecyclerView.ViewHolder {

    private ImageView colorFind;

    public HomeHolder(@NonNull View itemView) {
        super(itemView);

        colorFind=itemView.findViewById(R.id.ColorFind);

    }

    public void setdata(int game) {
        colorFind.setImageResource(game);
    }
}
