package com.example.thopcinema.bollyholly;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.thopcinema.R;
import com.example.thopcinema.databinding.ActivityBollyHollyBinding;
import com.example.thopcinema.movies.MoviesFragment;
import com.example.thopcinema.movies.adapter.ListAdapter;

public class BollyHollyActivity extends AppCompatActivity {

    ActivityBollyHollyBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBollyHollyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String pos = getIntent().getStringExtra("pos");

            binding.bollyholly.setText(""+pos);


        binding.ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


        ListAdapter adapter = new ListAdapter(BollyHollyActivity.this, MoviesFragment.image, MoviesFragment.name);
        RecyclerView.LayoutManager manager = new GridLayoutManager(BollyHollyActivity.this,3);
        binding.rvbollyholly.setLayoutManager(manager);
        binding.rvbollyholly.setAdapter(adapter);


    }
}