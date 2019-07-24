package com.example.ali.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.ali.calculator.History.DatabaseHandler;
import com.example.ali.calculator.History.History;

public class temparature extends AppCompatActivity {
    Spinner spinner1,spinner2;
    ArrayAdapter<CharSequence> adapter;
    String name;
    double from=1,to=1,a,b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temparature);
        TextView message =(TextView)findViewById(R.id.message);
        message.setText("Enter From");

        spinner1=(Spinner)findViewById(R.id.spinner1);
        adapter=ArrayAdapter.createFromResource(this,R.array.temparature_name_from,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                name=parent.getItemAtPosition(position).toString();
                if(name.matches("Celsius")){
                    from=1;
                }
                else if(name.matches("Kelvin")){
                    from=2;
                }
                else if(name.matches("Farenheit")){
                    from=3;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner2=(Spinner)findViewById(R.id.spinner2);
        adapter=ArrayAdapter.createFromResource(this,R.array.temparature_name_from,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter);

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                name=parent.getItemAtPosition(position).toString();
                if(name.matches("Celsius")){
                    to=1;
                }
                else if(name.matches("Kelvin")){
                    to=2;
                }
                else if(name.matches("Farenheit")){
                    to=3;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    String string="";
    String string1="";
    int count=1;
    public void onClick1(View v){
        TextView textView =(TextView)findViewById(R.id.textView);
        TextView textView2 =(TextView)findViewById(R.id.from);
        TextView textView3 =(TextView)findViewById(R.id.to);
        TextView textView4 =(TextView)findViewById(R.id.message);
        Button button =(Button) v;
        string=(String) button.getText().toString();
        string1=(String) button.getText().toString();
        if(count==1) {
            textView2.setText(textView2.getText().toString() + string);
        }
    }
    public void ce(View v){
        TextView textView =(TextView)findViewById(R.id.textView);
        TextView textView2 =(TextView)findViewById(R.id.from);
        TextView textView3 =(TextView)findViewById(R.id.to);
        TextView textView4 =(TextView)findViewById(R.id.message);
        textView2.setText("");
        textView3.setText("");
        textView4.setText("Enter From");
        count=1;
    }
    public void equal(View v) {

        TextView textView = (TextView) findViewById(R.id.textView);
        TextView textView2 = (TextView) findViewById(R.id.from);
        TextView textView3 = (TextView) findViewById(R.id.to);
        TextView textView4 = (TextView) findViewById(R.id.message);
        count++;
        if (count >= 2) {
            a = Double.parseDouble(textView2.getText().toString());
            if (from == 1 && to == 1) {
                textView3.setText("" + a);
                DatabaseHandler db = new DatabaseHandler(this);
                db.addHistory(new History(0,textView2.getText().toString()+"C",textView3.getText().toString()+"C"));
            }
            if (from == 1 && to == 2) {
                a = a + 274.15;
                textView3.setText("" + a);
                DatabaseHandler db = new DatabaseHandler(this);
                db.addHistory(new History(0,textView2.getText().toString()+"C",textView3.getText().toString()+"K"));
            }
            if (from == 1 && to == 3) {
                a = a *1.8+32;
                textView3.setText("" + a);
                DatabaseHandler db = new DatabaseHandler(this);
                db.addHistory(new History(0,textView2.getText().toString()+"C",textView3.getText().toString()+"F"));
            }
            if (from == 2 && to == 1) {
                a = a -274.15;
                textView3.setText("" + a);
                DatabaseHandler db = new DatabaseHandler(this);
                db.addHistory(new History(0,textView2.getText().toString()+"K",textView3.getText().toString()+"C"));

            }
            if (from == 2 && to == 2) {
                textView3.setText("" + a);
                DatabaseHandler db = new DatabaseHandler(this);
                db.addHistory(new History(0,textView2.getText().toString()+"K",textView3.getText().toString()+"K"));
            }
            if (from == 2 && to == 3) {
                a = 1.8*(a-274.15) +32;
                textView3.setText("" + a);
                DatabaseHandler db = new DatabaseHandler(this);
                db.addHistory(new History(0,textView2.getText().toString()+"K",textView3.getText().toString()+"F"));
            }
            if (from == 3 && to == 1) {
                a = .5556*(a-32);
                textView3.setText("" + a);
                DatabaseHandler db = new DatabaseHandler(this);
                db.addHistory(new History(0,textView2.getText().toString()+"F",textView3.getText().toString()+"C"));
            }
            if (from == 3 && to == 2) {
                a = .5556*(a-32) +274.15;
                textView3.setText("" + a);
                DatabaseHandler db = new DatabaseHandler(this);
                db.addHistory(new History(0,textView2.getText().toString()+"F",textView3.getText().toString()+"K"));
            }
            if (from == 3 && to == 3) {
                textView3.setText("" + a);
                DatabaseHandler db = new DatabaseHandler(this);
                db.addHistory(new History(0,textView2.getText().toString()+"F",textView3.getText().toString()+"F"));
            }
            }
        }
    }

