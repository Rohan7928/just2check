package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText edtUserNAme,edtPassword;
    Button btnlogin;
    RadioGroup gender_selection;
    RadioButton selectedgender;
    Intent intent=getIntent();
//  String name=intent.getStringExtra("User_name");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtUserNAme=findViewById(R.id.edt_UserPassword);
        edtUserNAme=findViewById(R.id.edt_UserName);
        btnlogin=findViewById(R.id.btn_login);
        gender_selection=findViewById(R.id.gender);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selection=gender_selection.getCheckedRadioButtonId();
                selectedgender=findViewById(selection);

                if(selection ==-1)
                {
                    Toast.makeText(MainActivity.this, "Nothing", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, selectedgender.getText(), Toast.LENGTH_SHORT).show();
                }
                Intent intent=new Intent(getApplicationContext(),login.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),"working",Toast.LENGTH_SHORT).show();
            }
        });

    }

}