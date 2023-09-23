package com.example.thopcinema.download;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thopcinema.MainActivity;
import com.example.thopcinema.R;
import com.example.thopcinema.databinding.FragmentDownloadBinding;
import com.example.thopcinema.databinding.FragmentHomeBinding;
import com.example.thopcinema.databinding.FragmentMoviesBinding;

public class DownloadFragment extends Fragment {

    FragmentDownloadBinding binding;
    MainActivity mainActivity;
    public DownloadFragment(MainActivity mainActivity) {
        this.mainActivity=mainActivity;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentDownloadBinding.inflate(inflater,container,false);

        return binding.getRoot();
    }
}