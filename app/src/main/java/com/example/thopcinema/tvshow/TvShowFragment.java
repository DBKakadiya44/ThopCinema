package com.example.thopcinema.tvshow;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thopcinema.MainActivity;
import com.example.thopcinema.R;
import com.example.thopcinema.databinding.FragmentHomeBinding;
import com.example.thopcinema.databinding.FragmentMoviesBinding;
import com.example.thopcinema.databinding.FragmentTvShowBinding;
import com.example.thopcinema.movies.MoviesFragment;
import com.example.thopcinema.movies.adapter.ListAdapter;

public class TvShowFragment extends Fragment {

    FragmentTvShowBinding binding;
    MainActivity mainActivity;
    public TvShowFragment(MainActivity mainActivity) {
        this.mainActivity=mainActivity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentTvShowBinding.inflate(inflater,container,false);

        ListAdapter adapter = new ListAdapter(mainActivity, MoviesFragment.image, MoviesFragment.name);
        RecyclerView.LayoutManager manager = new GridLayoutManager(mainActivity,3);
        binding.rvHome.setLayoutManager(manager);
        binding.rvHome.setAdapter(adapter);

        return binding.getRoot();
    }
}