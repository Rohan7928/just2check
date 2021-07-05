package com.example.firstproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firstproject.R;
import com.example.firstproject.UserModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Recycle extends RecyclerView.Adapter<Recycle.MyHolder>
{
    private ArrayList<UserModel> userModalArrayList;
    private Context context;

    public Recycle(ArrayList<UserModel> userModalArrayList, Context context) {
        this.userModalArrayList = userModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public Recycle.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.user_rv_item, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Recycle.MyHolder holder, int position) {
        UserModel userModal = userModalArrayList.get(position);

        // on below line we are setting data to our text view.
        holder.firstNameTV.setText(userModal.getFirst_name());
        holder.lastNameTV.setText(userModal.getLast_name());
        holder.emailTV.setText(userModal.getEmail());

        // on below line we are loading our image
        // from url in our image view using picasso.
        Picasso.get().load(userModal.getAvatar()).into(holder.userIV);
    }

    @Override
    public int getItemCount() {
        return userModalArrayList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        private TextView firstNameTV, lastNameTV, emailTV;
        private ImageView userIV;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            firstNameTV = itemView.findViewById(R.id.idTVFirstName);
            lastNameTV = itemView.findViewById(R.id.idTVLastName);
            emailTV = itemView.findViewById(R.id.idTVEmail);
            userIV = itemView.findViewById(R.id.idIVUser);
        }
    }
}
