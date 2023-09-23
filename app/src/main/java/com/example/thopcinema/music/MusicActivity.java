package com.example.thopcinema.music;

import android.os.Bundle;

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

        MusicAdapter adapter = new MusicAdapter(MusicActivity.this);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(MusicActivity.this,LinearLayoutManager.HORIZONTAL,false);
        binding.rvMusic.setLayoutManager(manager);
        binding.rvMusic.setAdapter(adapter);

    }
}
