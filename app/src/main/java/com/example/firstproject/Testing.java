package com.example.firstproject;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Testing extends AppCompatActivity implements FirstFragment.DataInterface {
    EditText edtName;
   Button frgfirst,frgsecond;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing);
        edtName=findViewById(R.id.edt_name);
        frgfirst=findViewById(R.id.frg_first);
        frgsecond=findViewById(R.id.frg_second);
        frgfirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=edtName.getText().toString();
                loadFragment(new FirstFragment(),name);
            }
        });
        frgsecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=edtName.getText().toString();
                loadFragment(new SecondFragment(),name);
            }
        });
    }

   /* @Override
    public void onClick(View v) {
        int id=v.getId();
        switch(id)
        {
            case R.id.frg_first:

                break;
             case R.id.frg_second:

                break;
            default:
                frgfirst.setError("Nothing is there");
        }
    }*/

    private void loadFragment(Fragment fragment,String name) {
        FragmentManager fm=getFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();

        Bundle bundle=new Bundle();
        bundle.putString("Name",name);
        bundle.putString("Bro",name);
        fragment.setArguments(bundle);

        ft.replace(R.id.frameLayout,fragment);
        ft.commit();

    }

    public  String user()
    {
        return "Hnji";
    }

    @Override
    public void getMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    /*private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }*/
}