package com.example.thopcinema.music;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thopcinema.R;

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.ViewHolder>
{
    MusicActivity musicActivity;
    public MusicAdapter(MusicActivity musicActivity) {
        this.musicActivity=musicActivity;
    }

    @NonNull
    @Override
    public MusicAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(musicActivity).inflate(R.layout.item_music,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MusicAdapter.ViewHolder holder, int position) {
        if(position==0){
            holder.imageView.setImageResource(R.drawable.music3);
            holder.textView.setText("Pushpa: The Rise");
        }
        if(position==1){
            holder.imageView.setImageResource(R.drawable.music2);
            holder.textView.setText("Vikram");
        }
        if(position==2){
            holder.imageView.setImageResource(R.drawable.music1);
            holder.textView.setText("Yashoda");
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.musicImage);
            textView = itemView.findViewById(R.id.musicText);
        }
    }
}
