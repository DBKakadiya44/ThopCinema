package com.example.thopcinema.live;

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
import com.example.thopcinema.databinding.FragmentLiveBinding;
import com.example.thopcinema.databinding.FragmentMoviesBinding;
import com.example.thopcinema.movies.MoviesFragment;
import com.example.thopcinema.movies.adapter.ListAdapter;

public class LiveFragment extends Fragment {

    FragmentLiveBinding binding;
    MainActivity mainActivity;
    public LiveFragment(MainActivity mainActivity) {
        this.mainActivity=mainActivity;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentLiveBinding.inflate(inflater,container,false);

        ListAdapter adapter = new ListAdapter(mainActivity, MoviesFragment.image, MoviesFragment.name);
        RecyclerView.LayoutManager manager = new GridLayoutManager(mainActivity,3);
        binding.rvHome.setLayoutManager(manager);
        binding.rvHome.setAdapter(adapter);

        return binding.getRoot();
    }
}