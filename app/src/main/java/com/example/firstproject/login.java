package com.example.firstproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class login extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    TextView txtname;
    EditText edtname,edtpassword;
    Button btnsubmit;
    Button btnpopup;
    CheckBox ischeck;
    Spinner spinner;
    String[] country = { "India", "USA", "China", "Japan", "Other"};
    dbhelper helper;
    String name;
    String email;
    FirebaseFirestore firestore;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        auth=FirebaseAuth.getInstance();
        edtname=findViewById(R.id.edt_name);
        edtpassword=findViewById(R.id.edt_password);
        btnsubmit=findViewById(R.id.btn_submit);
        btnpopup=findViewById(R.id.btn_popup);
        txtname=findViewById(R.id.txt_output);
        ischeck=findViewById(R.id.is_check);
        spinner = findViewById(R.id.spinnerid);
        helper= new dbhelper(this);
        firestore=FirebaseFirestore.getInstance();
        Boolean checking=ischeck.isChecked();
        if(checking)
        {
            btnsubmit.setVisibility(View.VISIBLE);
        }
        else{
            btnsubmit.setVisibility(View.INVISIBLE);
        }
        // List view adapter
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,country);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spinner.setAdapter(aa);

            firestore.collection("users").document("Yes").get()
                    .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
           @Override
           public void onSuccess(DocumentSnapshot documentSnapshot) {
               UserDataR userDataR = documentSnapshot.toObject(UserDataR.class);
               name=userDataR.getFname();
               email = userDataR.getEmail();
               Toast.makeText(getApplicationContext(), name+email, Toast.LENGTH_SHORT).show();

           }
       }).addOnFailureListener(new OnFailureListener() {
           @Override
           public void onFailure(@NonNull Exception e) {
               Toast.makeText(login.this, e.getMessage(), Toast.LENGTH_SHORT).show();
           }
       });

        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=edtname.getText().toString();
                String password=edtpassword.getText().toString();
                auth.signInWithEmailAndPassword(name,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Intent intent=new Intent(getApplicationContext(),contactlist.class);
                            startActivity(intent);
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(login.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
               /* Boolean insert=helper.insertuser(name,password);
                if(insert)
                {
                    Toast.makeText(login.this, "", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(login.this, "", Toast.LENGTH_SHORT).show();
                }
                txtname.setText("Name "+name +"\n"+"Password " +password);
               Toast.makeText(getApplicationContext(),name + password ,Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(getApplicationContext(),MainActivity3.class);
                //intent.putExtra("User_name",name);
                //intent.putExtra("Password",password);
                startActivity(intent);
                edtname.setText(name);
                edtpassword.setText(email);*/
            }
        });
        //Pop button
        btnpopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*PopupMenu popupMenu=new PopupMenu(getApplicationContext(),v);
                popupMenu.inflate(R.menu.menu_items);
                popupMenu.setOnMenuItemClickListener(login.this);
                popupMenu.show();*/
                auth.signOut();
                startActivity(new Intent(new Intent(getApplicationContext(),splash_screen.class)));
            }
        });
    }
//Option menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_items,menu);
        return true;
    }
// Option menu click listener
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.menu_add:
                startActivity(new Intent(getApplicationContext(),contactlist.class));
                return true;
            case R.id.menu_delete:
                Toast.makeText(this, "Delete", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_cancel:
                Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
//Pop menu click listener
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.menu_add:
                Toast.makeText(this, "Add", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_delete:
                Toast.makeText(this, "Delete", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_cancel:
                Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return false;
        }
    }
}