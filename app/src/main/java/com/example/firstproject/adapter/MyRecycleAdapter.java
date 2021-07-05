package com.example.firstproject.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firstproject.Hero;
import com.example.firstproject.R;

import java.util.ArrayList;

public class MyRecycleAdapter extends RecyclerView.Adapter<MyRecycleAdapter.ViewHolder>
{
    Context context;
    ArrayList<Hero> heroes;
    AlertDialog.Builder builder;
    MyRecycleAdapter(Context context, ArrayList<Hero> heroes)
    {
        this.context=context;
        this.heroes=heroes;
    }

    @NonNull
    @Override
    public MyRecycleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecycleAdapter.ViewHolder holder, int position) {
        builder = new AlertDialog.Builder(context);
        addItem(position,holder);
        holder.btndelete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        builder.setCancelable(false);
                        builder.setMessage("Do you want to delete this item ?");
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        heroes.remove(position);
                                        notifyItemRemoved(position);
                                        notifyItemRangeChanged(position,heroes.size());                                    }
                                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        //  Action for 'NO' Button
                                        dialog.cancel();
                                        Toast.makeText(context,"you choose no action for alertbox",
                                                Toast.LENGTH_SHORT).show();
                                    }
                                });
                        //Creating dialog box
                        AlertDialog alert = builder.create();
                        alert.setTitle("Are you sure");
                        alert.show();

                    }
                }
        );
        //holder.imageView.setImageDrawable(context.getResources().getDrawable(hero.getImage()));
    }


    private void addItem(int position, ViewHolder holder) {
        Hero hero = heroes.get(position);
        holder.txtname.setText(hero.getName());
        holder.txtteam.setText(hero.getTeam());
//        notifyItemInserted(position);
//        notifyItemRangeChanged(position, heroes.size());
    }

    @Override
    public int getItemCount() {
        return heroes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView txtname;
        public TextView txtteam;
        public Button btndelete;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imageView = (ImageView) itemView.findViewById(R.id.img_listItem);
            this.txtname = (TextView) itemView.findViewById(R.id.txt_listname);
            this.txtteam = (TextView) itemView.findViewById(R.id.txt_listteam);
            this.btndelete = (Button) itemView.findViewById(R.id.btn_delete);
        }

    }
}
