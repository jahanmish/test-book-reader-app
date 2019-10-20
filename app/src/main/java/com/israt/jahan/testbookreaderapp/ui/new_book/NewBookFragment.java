package com.israt.jahan.testbookreaderapp.ui.new_book;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.israt.jahan.testbookreaderapp.R;

public class NewBookFragment extends Fragment {

    private NewBookViewModel newBookViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        newBookViewModel =
                ViewModelProviders.of(this).get(NewBookViewModel.class);
        View root = inflater.inflate(R.layout.fragment_new_book, container, false);
        final TextView textView = root.findViewById(R.id.text_new_book);
        newBookViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}