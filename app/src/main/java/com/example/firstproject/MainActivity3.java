package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import com.example.firstproject.adapter.MyAdapter;

public class MainActivity3 extends AppCompatActivity {
    GridView coursesGV;
    String[] festivals = { "Diwali", "Holi", "Christmas", "Eid", "Baisakhi", "Halloween" ,"Lohri"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        coursesGV = findViewById(R.id.idGVcourses);
        MyAdapter myAdapter=new MyAdapter(this,festivals);
        coursesGV.setAdapter(myAdapter);
    }
}