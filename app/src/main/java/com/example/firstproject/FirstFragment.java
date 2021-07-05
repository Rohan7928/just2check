package com.example.firstproject;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


public class FirstFragment extends Fragment {
    View view;
    TextView textView;
    Button button;
    Testing testing=new Testing();
    public interface DataInterface
    {
        void getMessage(String message);
    }

    DataInterface dataInterface;

    @Nullable
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        dataInterface=(DataInterface)context;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       // String string=getArguments().getString("Name");

        view=inflater.inflate(R.layout.first_fragment,container,false);
        textView=view.findViewById(R.id.frg1_txt_name);
        button=view.findViewById(R.id.btn_click1);
        String welcome=testing.user();
        //textView.setText(string);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataInterface.getMessage("Rohan");
            }
        });
        textView.setText(welcome);
        return view;
    }


}
