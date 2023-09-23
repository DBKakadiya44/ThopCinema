package com.example.thopcinema.home.adapter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thopcinema.MainActivity;
import com.example.thopcinema.R;
import com.example.thopcinema.music.MusicActivity;
import com.google.android.material.imageview.ShapeableImageView;

public class UpcomigAdapter extends RecyclerView.Adapter<UpcomigAdapter.ViewHolder> {

    MainActivity mainActivity;
    int[] image;
    public UpcomigAdapter(MainActivity mainActivity, int[] image) {
        this.mainActivity=mainActivity;
        this.image=image;
    }

    @NonNull
    @Override
    public UpcomigAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mainActivity).inflate(R.layout.item_upcoming,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UpcomigAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.imageView.setImageResource(image[position]);

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mainActivity , MusicActivity.class);
                intent.putExtra("image",image[position]);
                mainActivity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return image.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ShapeableImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.ivUpcoming);
        }
    }
}
