package com.example.ali.calculator;

/**
 * Created by ali on 1/7/2017.
 */
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FifthFragment extends Fragment {
    public FifthFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fifth, container, false);//generate view
        final Button conversion = (Button) view.findViewById(R.id.conversionBt);
        conversion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView2 =(TextView)getActivity().findViewById(R.id.input_main);
                textView2.setText(conversion.getText().toString());
            }
        });
        return view;
    }
}
