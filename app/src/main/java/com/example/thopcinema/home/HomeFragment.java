package com.example.thopcinema.home;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thopcinema.MainActivity;
import com.example.thopcinema.R;
import com.example.thopcinema.SliderItems;
import com.example.thopcinema.bollyholly.BollyHollyActivity;
import com.example.thopcinema.databinding.FragmentHomeBinding;
import com.example.thopcinema.home.adapter.AppsAdapter;
import com.example.thopcinema.home.adapter.UpcomigAdapter;
import com.example.thopcinema.home.adapter.ViewPagerAdapter;
import com.example.thopcinema.movies.MoviesFragment;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    FragmentHomeBinding binding;
    MainActivity mainActivity;
    private Handler sliderHandler = new Handler();
    public HomeFragment(MainActivity mainActivity) {
        this.mainActivity=mainActivity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater,container,false);

        viewpagercode();
        appadapterdata();
        upcominddata();

        binding.ivbolly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mainActivity, BollyHollyActivity.class);
                intent.putExtra("pos","Bollywood");
                startActivity(intent);
            }
        });

        binding.ivholly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mainActivity, BollyHollyActivity.class);
                intent.putExtra("pos","Hollywood");
                startActivity(intent);
            }
        });

        binding.ivsouth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mainActivity, BollyHollyActivity.class);
                intent.putExtra("pos","South Indian");
                startActivity(intent);
            }
        });
        binding.ivaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mainActivity, BollyHollyActivity.class);
                intent.putExtra("pos","Action");
                startActivity(intent);
            }
        });
        binding.ivadvanture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mainActivity, BollyHollyActivity.class);
                intent.putExtra("pos","Adventure");
                startActivity(intent);
            }
        });
        binding.ivcomedy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mainActivity, BollyHollyActivity.class);
                intent.putExtra("pos","Comedy");
                startActivity(intent);
            }
        });
        binding.ivdrama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mainActivity, BollyHollyActivity.class);
                intent.putExtra("pos","Drama");
                startActivity(intent);
            }
        });
        binding.ivfantasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mainActivity, BollyHollyActivity.class);
                intent.putExtra("pos","Fantasy");
                startActivity(intent);
            }
        });
        binding.ivhorror.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mainActivity, BollyHollyActivity.class);
                intent.putExtra("pos","Horror");
                startActivity(intent);
            }
        });
        binding.ivromance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mainActivity, BollyHollyActivity.class);
                intent.putExtra("pos","Romance");
                startActivity(intent);
            }
        });
        binding.ivscience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mainActivity, BollyHollyActivity.class);
                intent.putExtra("pos","Sc-fi Fantasy");
                startActivity(intent);
            }
        });
        binding.ivthriller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mainActivity, BollyHollyActivity.class);
                intent.putExtra("pos","Thriller");
                startActivity(intent);
            }
        });

        return binding.getRoot();
    }

    private void upcominddata()
    {
        UpcomigAdapter adapter = new UpcomigAdapter(mainActivity, MoviesFragment.image);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(mainActivity,RecyclerView.HORIZONTAL,false);
        binding.rvUpcoming.setLayoutManager(manager);
        binding.rvUpcoming.setAdapter(adapter);
    }

    private void appadapterdata()
    {
        AppsAdapter adapter = new AppsAdapter(mainActivity);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(mainActivity,RecyclerView.HORIZONTAL,false);
        binding.rvNetflix.setLayoutManager(manager);
        binding.rvNetflix.setAdapter(adapter);
    }


    private void viewpagercode() {
        List<SliderItems> sliderItems = new ArrayList<>();
        sliderItems.add(new SliderItems(R.drawable.vp1));
        sliderItems.add(new SliderItems(R.drawable.vp2));
        sliderItems.add(new SliderItems(R.drawable.vp3));

        binding.viewPagerImageSlider.setAdapter(new ViewPagerAdapter(sliderItems,binding.viewPagerImageSlider));

        binding.viewPagerImageSlider.setClipToPadding(false);
        binding.viewPagerImageSlider.setClipChildren(false);
        binding.viewPagerImageSlider.setOffscreenPageLimit(150);
        binding.viewPagerImageSlider.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(30));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.85f + r * 0.15f);
            }
        });

        binding.viewPagerImageSlider.setPageTransformer(compositePageTransformer);

        binding.viewPagerImageSlider.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                sliderHandler.removeCallbacks(sliderRunnable);
                sliderHandler.postDelayed(sliderRunnable, 3000);

//                if (position%3 == 0) {
//                    binding.ivdot1.setBackgroundResource(R.drawable.dot_white);
//                    binding.ivdot2.setBackgroundResource(R.drawable.dot_grey);
//                    binding.ivdot3.setBackgroundResource(R.drawable.dot_grey);
//                }
//                if (position%4 == 0) {
//                    binding.ivdot1.setBackgroundResource(R.drawable.dot_grey);
//                    binding.ivdot2.setBackgroundResource(R.drawable.dot_white);
//                    binding.ivdot3.setBackgroundResource(R.drawable.dot_grey);
//                }
//                if (position%5 == 0) {
//                    binding.ivdot1.setBackgroundResource(R.drawable.dot_grey);
//                    binding.ivdot2.setBackgroundResource(R.drawable.dot_grey);
//                    binding.ivdot3.setBackgroundResource(R.drawable.dot_white);
//                }
            }
        });

    }

    private Runnable sliderRunnable = new Runnable() {
        @Override
        public void run() {
            binding.viewPagerImageSlider.setCurrentItem(binding.viewPagerImageSlider.getCurrentItem() + 1);
        }
    };

    @Override
    public void onPause() {
        super.onPause();
        sliderHandler.removeCallbacks(sliderRunnable);
    }

    @Override
    public void onResume() {
        super.onResume();
        sliderHandler.postDelayed(sliderRunnable, 2000);
    }
}