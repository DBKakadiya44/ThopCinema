package com.example.thopcinema.music;

import android.content.Intent;
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
    int[] image = {R.drawable.music3,R.drawable.music2,R.drawable.music1};
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
            holder.textView.setText("Pushpa: The Rise");
        }
        if(position==1){
            holder.textView.setText("Vikram");
        }
        if(position==2){
            holder.textView.setText("Yashoda");
        }
        holder.imageView.setImageResource(image[position]);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(musicActivity , MusicActivity.class);
                intent.putExtra("image",image[position]);
                musicActivity.startActivity(intent);
            }
        });
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
