package com.example.thopcinema.music;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thopcinema.databinding.ActivityMusicBinding;

public class MusicActivity extends AppCompatActivity
{
    ActivityMusicBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMusicBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        
        int image = getIntent().getIntExtra("image",0);
        
        binding.ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        
        binding.imageView.setImageResource(image);

        MusicAdapter adapter = new MusicAdapter(MusicActivity.this);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(MusicActivity.this,LinearLayoutManager.HORIZONTAL,false);
        binding.rvMusic.setLayoutManager(manager);
        binding.rvMusic.setAdapter(adapter);

    }
}
