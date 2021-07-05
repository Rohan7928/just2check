package com.example.firstproject;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.firstproject.adapter.Recycle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class contactlist extends AppCompatActivity {
    //ListView listView;
    private ArrayList<UserModel> userModalArrayList;
    private ProgressBar loadingPB;
    RecyclerView recyclerView;
    EditText edthero,edtteam;
    //ArrayList<Hero> heroes;
    Button btnupdate;
    Recycle myRecycleAdapter;
    int page = 0, limit = 2;
    //String[] festivals = { "Diwali", "Holi", "Christmas", "Eid", "Baisakhi", "Halloween" ,"Lohri"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactlist);
        //listView=findViewById(R.id.contact_items);
        recyclerView=findViewById(R.id.Recycler_view);
        edthero=findViewById(R.id.edt_hero);
        edtteam=findViewById(R.id.edt_team);
        btnupdate=findViewById(R.id.btn_update);
        userModalArrayList = new ArrayList<>();
        loadingPB = findViewById(R.id.idPBLoading);

        getDataFromAPI(page, limit);
        /*heroes=new ArrayList<>();

        heroes.add(new Hero(R.drawable.spiderman,"SpiderMan","Avengers"));
        heroes.add(new Hero(R.drawable.ironman,"IronMan","Avengers"));
        heroes.add(new Hero(R.drawable.captain,"Captain America","Avengers"));
        heroes.add(new Hero(R.drawable.thor,"Thor","Avengers"));*/
        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*String hero=edthero.getText().toString();
                String team=edtteam.getText().toString();
                heroes.add(new Hero(hero,team));
                myRecycleAdapter.notifyDataSetChanged();*/
            }
        });


        //ArrayAdapter arrayAdapter=new ArrayAdapter(this,R.layout.list_item,R.id.txt_listItem,festivals);

        //MyContactAdapter myContactAdapter=new MyContactAdapter(this,heroes);
        //listView.setAdapter(myContactAdapter);

       // myRecycleAdapter=new MyRecycleAdapter(this,heroes);
        //myRecycleAdapter=new Recycle(this,heroes);
        //recyclerView.setHasFixedSize(true);
        //LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);

        //GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),3,LinearLayoutManager.HORIZONTAL,false);
        /*StaggeredGridLayoutManager staggeredGridLayoutManager =
                new StaggeredGridLayoutManager(3, LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(staggeredGridLayoutManager);


        recyclerView.setAdapter(myRecycleAdapter);*/
        /*listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String value=festivals[position];
                Toast.makeText(contactlist.this, value, Toast.LENGTH_SHORT).show();
            }
        });
*/
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
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
                return super.onOptionsItemSelected(item);
        }
    }

    private void getDataFromAPI(int page, int limit) {
        if (page > limit) {
            // checking if the page number is greater than limit.
            // displaying toast message in this case when page>limit.
            Toast.makeText(this, "That's all the data..", Toast.LENGTH_SHORT).show();

            // hiding our progress bar.
            loadingPB.setVisibility(View.GONE);
            return;
        }
        // creating a string variable for url .
        String url = "https://reqres.in/api/users?page=" + page;

        // creating a new variable for our request queue
        RequestQueue queue = Volley.newRequestQueue(contactlist.this);

        // creating a variable for our json object request and passing our url to it.
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {

                    // on below line we are extracting data from our json array.
                    JSONArray dataArray = response.getJSONArray("data");

                    // passing data from our json array in our array list.
                    for (int i = 0; i < dataArray.length(); i++) {
                        JSONObject jsonObject = dataArray.getJSONObject(i);

                        // on below line we are extracting data from our json object.
                        userModalArrayList.add(new UserModel(jsonObject.getString("first_name"), jsonObject.getString("last_name"), jsonObject.getString("email"), jsonObject.getString("avatar")));

                        // passing array list to our adapter class.
                        myRecycleAdapter = new Recycle(userModalArrayList, contactlist.this);

                        // setting layout manager to our recycler view.
                        recyclerView.setLayoutManager(new LinearLayoutManager(contactlist.this));

                        // setting adapter to our recycler view.
                        recyclerView.setAdapter(myRecycleAdapter);
                        registerForContextMenu(recyclerView);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(contactlist.this, "Fail to get data..", Toast.LENGTH_SHORT).show();

            }

        });
        // calling a request queue method
        // and passing our json object
        queue.add(jsonObjectRequest);
    }
}