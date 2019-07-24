package com.example.ali.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.tonmo.calculator.History.DatabaseHandler;
import com.example.tonmo.calculator.History.History;

public class area extends AppCompatActivity {
    Spinner spinner1,spinner2;
    ArrayAdapter<CharSequence> adapter;
    String name;
    double from=1,to=1,a,b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area);
        TextView message =(TextView)findViewById(R.id.message);
        message.setText("Enter From");

        spinner1=(Spinner)findViewById(R.id.spinner1);
        adapter=ArrayAdapter.createFromResource(this,R.array.area_name_from,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                name=parent.getItemAtPosition(position).toString();
                if(name.matches("Square Meter")){
                    from=1;
                }
                else if(name.matches("Square Kilometer")){
                    from=2;
                }
                else if(name.matches("Square Foot")){
                    from=3;
                }
                else if(name.matches("Hectare")){
                    from=4;
                }
                else if(name.matches("Acre")){
                    from=5;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        spinner2=(Spinner)findViewById(R.id.spinner2);
        adapter=ArrayAdapter.createFromResource(this,R.array.area_name_from,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter);

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                name=parent.getItemAtPosition(position).toString();
                if(name.matches("Square Meter")){
                    to=1;
                }
                else if(name.matches("Square Kilometer")){
                    to=2;
                }
                else if(name.matches("Square Foot")){
                    to=3;
                }
                else if(name.matches("Hectare")){
                    to=4;
                }
                else if(name.matches("Acre")){
                    to=5;
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
                db.addHistory(new History(0,textView2.getText().toString()+"sq.m",textView3.getText().toString()+"sq.m"));
            }
            if (from == 1 && to == 2) {
                a = a * 0.000001;
                textView3.setText("" + a);
                DatabaseHandler db = new DatabaseHandler(this);
                db.addHistory(new History(0,textView2.getText().toString()+"sq.m",textView3.getText().toString()+"sq.km"));
            }
            if (from == 1 && to == 3) {
                a = a * 10.763910417;
                textView3.setText("" + a);
                DatabaseHandler db = new DatabaseHandler(this);
                db.addHistory(new History(0,textView2.getText().toString()+"sq.m",textView3.getText().toString()+"sq.foot"));
            }
            if (from == 1 && to == 4) {
                a = a * 0.0001;
                textView3.setText("" + a);
                DatabaseHandler db = new DatabaseHandler(this);
                db.addHistory(new History(0,textView2.getText().toString()+"sq.m",textView3.getText().toString()+"hectare"));
            }
            if (from == 1 && to == 5) {
                a = a * 0.0002471054;
                textView3.setText("" + a);
                DatabaseHandler db = new DatabaseHandler(this);
                db.addHistory(new History(0,textView2.getText().toString()+"sq.m",textView3.getText().toString()+"acre"));
            }
            if (from == 2 && to == 1) {
                a = a * 1000000;
                textView3.setText("" + a);
                DatabaseHandler db = new DatabaseHandler(this);
                db.addHistory(new History(0,textView2.getText().toString()+"sq.km",textView3.getText().toString()+"sq.m"));
            }

            if (from == 2 && to == 2) {
                textView3.setText("" + a);
                DatabaseHandler db = new DatabaseHandler(this);
                db.addHistory(new History(0,textView2.getText().toString()+"sq.km",textView3.getText().toString()+"sq.km"));
            }
            if (from == 2 && to == 3) {
                a = a * 10763910.417;
                textView3.setText("" + a);
                DatabaseHandler db = new DatabaseHandler(this);
                db.addHistory(new History(0,textView2.getText().toString()+"sq.km",textView3.getText().toString()+"sq.foot"));
            }
            if (from == 2 && to == 4) {
                a = a * 100;
                textView3.setText("" + a);
                DatabaseHandler db = new DatabaseHandler(this);
                db.addHistory(new History(0,textView2.getText().toString()+"sq.km",textView3.getText().toString()+"hectare"));
            }
            if (from == 2 && to == 5) {
                a = a * 247.10538147;
                textView3.setText("" + a);
                DatabaseHandler db = new DatabaseHandler(this);
                db.addHistory(new History(0,textView2.getText().toString()+"sq.km",textView3.getText().toString()+"acre"));
            }
            if (from == 3 && to == 1) {
                a = a * 0.09290304;
                textView3.setText("" + a);
                DatabaseHandler db = new DatabaseHandler(this);
                db.addHistory(new History(0,textView2.getText().toString()+"sq.foot",textView3.getText().toString()+"sq.m"));
            }

            if (from == 3 && to == 2) {
                a=a*9.290304E-8;
                textView3.setText("" + a);
                DatabaseHandler db = new DatabaseHandler(this);
                db.addHistory(new History(0,textView2.getText().toString()+"sq.foot",textView3.getText().toString()+"sq.km"));
            }
            if (from == 3 && to == 3) {
                textView3.setText("" + a);
                DatabaseHandler db = new DatabaseHandler(this);
                db.addHistory(new History(0,textView2.getText().toString()+"sq.foot",textView3.getText().toString()+"sq.foot"));
            }
            if (from == 3 && to == 4) {
                a = a * 0.0000092903;
                textView3.setText("" + a);
                DatabaseHandler db = new DatabaseHandler(this);
                db.addHistory(new History(0,textView2.getText().toString()+"sq.foot",textView3.getText().toString()+"hectare"));
            }
            if (from == 3 && to == 5) {
                a = a * 0.0000229568;
                textView3.setText("" + a);
                DatabaseHandler db = new DatabaseHandler(this);
                db.addHistory(new History(0,textView2.getText().toString()+"sq.foot",textView3.getText().toString()+"acre"));
            }
            if (from == 4 && to == 1) {
                a = a * 10000;
                textView3.setText("" + a);
                DatabaseHandler db = new DatabaseHandler(this);
                db.addHistory(new History(0,textView2.getText().toString()+"hectare",textView3.getText().toString()+"sq.m"));
            }

            if (from == 4 && to == 2) {
                a=a*0.01;
                textView3.setText("" + a);
                DatabaseHandler db = new DatabaseHandler(this);
                db.addHistory(new History(0,textView2.getText().toString()+"hectare",textView3.getText().toString()+"sq.km"));
            }
            if (from == 4 && to == 3) {
                a=a*107639.10417;
                textView3.setText("" + a);
                DatabaseHandler db = new DatabaseHandler(this);
                db.addHistory(new History(0,textView2.getText().toString()+"hectare",textView3.getText().toString()+"sq.foot"));
            }
            if (from == 4 && to == 4) {
                textView3.setText("" + a);
                DatabaseHandler db = new DatabaseHandler(this);
                db.addHistory(new History(0,textView2.getText().toString()+"hectare",textView3.getText().toString()+"hectare"));
            }
            if (from == 4 && to == 5) {
                a = a * 2.4710538147;
                textView3.setText("" + a);
                DatabaseHandler db = new DatabaseHandler(this);
                db.addHistory(new History(0,textView2.getText().toString()+"hectare",textView3.getText().toString()+"acre"));
            }
            if (from == 5 && to == 1) {
                a = a * 4046.8564224;
                textView3.setText("" + a);
                DatabaseHandler db = new DatabaseHandler(this);
                db.addHistory(new History(0,textView2.getText().toString()+"acre",textView3.getText().toString()+"sq.m"));
            }

            if (from == 5 && to == 2) {
                a=a*0.0040468564;
                textView3.setText("" + a);
                DatabaseHandler db = new DatabaseHandler(this);
                db.addHistory(new History(0,textView2.getText().toString()+"acre",textView3.getText().toString()+"sq.km"));
            }
            if (from == 5 && to == 3) {
                a=a*43560;
                textView3.setText("" + a);
                DatabaseHandler db = new DatabaseHandler(this);
                db.addHistory(new History(0,textView2.getText().toString()+"acre",textView3.getText().toString()+"sq.foot"));
            }
            if (from == 5 && to == 4) {
                a = a * 0.4046856422;
                textView3.setText("" + a);
                DatabaseHandler db = new DatabaseHandler(this);
                db.addHistory(new History(0,textView2.getText().toString()+"acre",textView3.getText().toString()+"hectare"));
            }
            if (from == 5 && to == 5) {
                textView3.setText("" + a);
                DatabaseHandler db = new DatabaseHandler(this);
                db.addHistory(new History(0,textView2.getText().toString()+"acre",textView3.getText().toString()+"acre"));
            }
        }
    }
}
