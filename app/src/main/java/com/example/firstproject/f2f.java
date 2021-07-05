package com.example.firstproject;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class f2f extends AppCompatActivity implements ListMenuFragment.Myinter {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f2f);
        /*FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_one,new DetailsFragment()).commit();*/

    }

    @Override
    public void getMmsg(String name) {
        DetailsFragment detailsFragment=(DetailsFragment)getFragmentManager().findFragmentById(R.id.fragment_two);
        detailsFragment.change(name);
    }
}