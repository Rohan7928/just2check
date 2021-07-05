package com.example.firstproject;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;


public class ListMenuFragment extends Fragment {
public  interface  Myinter{
    void getMmsg(String name);
}

    EditText name;
    Button location;
   Myinter myinter;
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        myinter=(Myinter)activity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.listitems_info, container, false);
        name = (EditText)view.findViewById(R.id.Name);
        location = (Button) view.findViewById(R.id.btn_Location);
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name.getText().toString().equals("")){
                    Toast.makeText(getActivity(), "User input value must be filled",
                            Toast.LENGTH_LONG).show();
                    return;
                }
                String text=name.getText().toString();
                myinter.getMmsg(text);
                /*if(myinter!=null)
                {
                    myinter.getMmsg(text);
                }*/
                /*//myinter.getMmsg(text);
                DetailsFragment detailsFragment=new DetailsFragment();
                Bundle arg=new Bundle();
                arg.putString("Name",text);
                detailsFragment.setArguments(arg);
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.txt_Name, detailsFragment)
                        .commit();
                //Toast.makeText(getActivity(), text, Toast.LENGTH_SHORT).show();
               // getFragmentManager().beginTransaction().add(R.id.txt_Name,arg).commit();
               // DetailsFragment detailsFragment=getFragmentManager().beginTransaction().*/
            }
        });
        return view;
    }
    @Override
    public void onDetach() {
        super.onDetach();
        myinter = null;
    }

}
