package com.example.thopcinema.movies.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thopcinema.MainActivity;
import com.example.thopcinema.R;
import com.example.thopcinema.music.MusicActivity;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder>
{
    Context context;
    int[] image;
    String[] name;

    public ListAdapter(Context context, int[] image, String[] name) {
        this.context = context;
        this.image = image;
        this.name = name;
    }

    @NonNull
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_movie_image,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.textView.setText(""+name[position]);
        holder.imageView.setImageResource(image[position]);

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context , MusicActivity.class);
                intent.putExtra("image",image[position]);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return image.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.ivImage);
            textView = itemView.findViewById(R.id.tvName);
        }
    }
}
