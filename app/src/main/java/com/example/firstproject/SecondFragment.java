package com.example.firstproject;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class SecondFragment extends Fragment {
    View view;
    TextView textView;
    Button firstbutton;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        String string=getArguments().getString("Bro");
        view=inflater.inflate(R.layout.second_fragment,container,false);
        textView=view.findViewById(R.id.frg2_txt_name);
        textView.setText(string);
        return view;
    }
}
