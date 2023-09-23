package com.example.thopcinema;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.thopcinema.bollyholly.BollyHollyActivity;
import com.example.thopcinema.databinding.ActivityMainBinding;
import com.example.thopcinema.download.DownloadFragment;
import com.example.thopcinema.home.HomeFragment;
import com.example.thopcinema.live.LiveFragment;
import com.example.thopcinema.movies.MoviesFragment;
import com.example.thopcinema.tvshow.TvShowFragment;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        addFragment(new HomeFragment(MainActivity.this));

        binding.inc.ivToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    binding.drawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    binding.drawerLayout.openDrawer(GravityCompat.START);
                }
            }
        });

        binding.inc.ivHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                clearall();
                binding.inc.ivHome.setVisibility(View.INVISIBLE);
                binding.inc.iv2Home.setVisibility(View.VISIBLE);
                binding.inc.tvTitle.setText("ThopCinema");

                addFragment(new HomeFragment(MainActivity.this));
            }
        });
        binding.inc.ivMovies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearall();
                binding.inc.ivMovies.setVisibility(View.INVISIBLE);
                binding.inc.iv2Movies.setVisibility(View.VISIBLE);
                binding.inc.tvTitle.setText("Movies");

                addFragment(new MoviesFragment(MainActivity.this));
            }
        });
        binding.inc.ivLive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearall();
                binding.inc.ivLive.setVisibility(View.INVISIBLE);
                binding.inc.iv2Live.setVisibility(View.VISIBLE);
                binding.inc.tvTitle.setText("Live Tv");

                addFragment(new LiveFragment(MainActivity.this));
            }
        });
        binding.inc.ivTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearall();
                binding.inc.ivTv.setVisibility(View.INVISIBLE);
                binding.inc.iv2Tv.setVisibility(View.VISIBLE);
                binding.inc.tvTitle.setText("TV Shows");

                addFragment(new TvShowFragment(MainActivity.this));
            }
        });
        binding.inc.ivDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearall();
                binding.inc.ivDownload.setVisibility(View.INVISIBLE);
                binding.inc.iv2Download.setVisibility(View.VISIBLE);
                binding.inc.tvTitle.setText("Downloads");

                addFragment(new DownloadFragment(MainActivity.this));
            }
        });



        binding.menus.navHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addFragment(new HomeFragment(MainActivity.this));
                binding.drawerLayout.close();
            }
        });
        binding.menus.navFavorute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , BollyHollyActivity.class);
                intent.putExtra("pos","3");
                startActivity(intent);
            }
        });
        binding.menus.navMoreApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "More App", Toast.LENGTH_SHORT).show();
            }
        });
        binding.menus.navPrivacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Privacy Policy", Toast.LENGTH_SHORT).show();
            }
        });
        binding.menus.navShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Share", Toast.LENGTH_SHORT).show();
            }
        });
        binding.menus.navFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Feedback", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void clearall()
    {
        binding.inc.ivHome.setVisibility(View.VISIBLE);
        binding.inc.ivMovies.setVisibility(View.VISIBLE);
        binding.inc.ivLive.setVisibility(View.VISIBLE);
        binding.inc.ivTv.setVisibility(View.VISIBLE);
        binding.inc.ivDownload.setVisibility(View.VISIBLE);

        binding.inc.iv2Home.setVisibility(View.INVISIBLE);
        binding.inc.iv2Movies.setVisibility(View.INVISIBLE);
        binding.inc.iv2Live.setVisibility(View.INVISIBLE);
        binding.inc.iv2Tv.setVisibility(View.INVISIBLE);
        binding.inc.iv2Download.setVisibility(View.INVISIBLE);
    }

    private void addFragment(Fragment fragment)
    {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.flFrame,fragment);
        transaction.commit();
    }

}