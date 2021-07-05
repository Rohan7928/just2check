import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.firstproject.R;

public class arya extends Fragment {
    View view;
    TextView textView;
    Button button;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.first_fragment,container,false);
        textView=view.findViewById(R.id.frg1_txt_name);
        button=view.findViewById(R.id.btn_click1);
       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Toast.makeText(getActivity(), "", Toast.LENGTH_SHORT).show();
           }
       });
        return view;
    }
}
