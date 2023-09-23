package com.example.thopcinema.home.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thopcinema.MainActivity;
import com.example.thopcinema.R;

public class AppsAdapter extends RecyclerView.Adapter<AppsAdapter.ViewHolder>
{
    MainActivity mainActivity;
    public AppsAdapter(MainActivity mainActivity) {
        this.mainActivity=mainActivity;
    }

    @NonNull
    @Override
    public AppsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mainActivity).inflate(R.layout.item_netflix,parent,false);
        return new AppsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AppsAdapter.ViewHolder holder, int position) {

        int[] image = {R.drawable.netflix,R.drawable.amazon,R.drawable.disney,R.drawable.zee};
            holder.imageView.setImageResource(image[position]);

    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.ivNetflix);
        }
    }
}
