package com.example.thopcinema.movies;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thopcinema.MainActivity;
import com.example.thopcinema.R;
import com.example.thopcinema.databinding.FragmentHomeBinding;
import com.example.thopcinema.databinding.FragmentMoviesBinding;
import com.example.thopcinema.movies.adapter.ListAdapter;
import com.example.thopcinema.music.MusicActivity;

public class MoviesFragment extends Fragment {

    FragmentMoviesBinding binding;
    MainActivity mainActivity;
    public static int[] image = {R.drawable.i1,R.drawable.i2,R.drawable.i3,R.drawable.i4,R.drawable.i5,R.drawable.i6,
            R.drawable.i7,R.drawable.i8,R.drawable.i9,R.drawable.i10,R.drawable.i11,R.drawable.i12,
            R.drawable.i13,R.drawable.i14,R.drawable.i15,R.drawable.i16,R.drawable.i1,R.drawable.i2};

    public static String[] name = {"Black Adam","Liger","Top Gun: Maverick","Ponniyin Selvan: I","Bullet Train","Uncharted",
            "Pushpa: The Rise","Vikram","Yashoda","Black Adam","Liger","Top Gun: Maverick","Ponniyin Selvan: I",
            "Bullet Train","Uncharted","Pushpa: The Rise","Black Adam","Liger"};
    public MoviesFragment(MainActivity mainActivity) {
        this.mainActivity=mainActivity;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentMoviesBinding.inflate(inflater,container,false);


        ListAdapter adapter = new ListAdapter(mainActivity, image, name);
        RecyclerView.LayoutManager manager = new GridLayoutManager(mainActivity,3);
        binding.rvHome.setLayoutManager(manager);
        binding.rvHome.setAdapter(adapter);

        return binding.getRoot();
    }
}