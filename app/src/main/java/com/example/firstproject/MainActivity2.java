package com.example.firstproject;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.firstproject.adapter.MyAdapter;

public class MainActivity2 extends AppCompatActivity {
    ListView listView;
    String[] festivals = { "Diwali", "Holi", "Christmas", "Eid", "Baisakhi", "Halloween" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        listView=findViewById(R.id.list_items);
        MyAdapter myAdapter=new MyAdapter(this, festivals);
        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value=myAdapter.getItem(position).toString();
                Toast.makeText(getApplicationContext(),value,Toast.LENGTH_SHORT).show();
            }
        });

    }

}