package com.example.fragmentexample02;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class ListFragment extends Fragment {
    public void interface ImageSelectionCallback{
        public void onImageSelected(int position);
    }

    public ImageSelectionCallback callback;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof ImageSelectionCallback){
            callback = (ImageSelectionCallback) context;
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootview = (ViewGroup) inflater.inflate(R.layout.fragment_list, container, false);
    }
}