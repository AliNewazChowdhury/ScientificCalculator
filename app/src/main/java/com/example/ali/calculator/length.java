package com.example.ali.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ali.calculator.History.DatabaseHandler;
import com.example.ali.calculator.History.History;

public class length extends AppCompatActivity {
    Spinner spinner1,spinner2;
    ArrayAdapter<CharSequence> adapter;
    String name;
    double from=1,to=1,a,b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length);
        TextView message =(TextView)findViewById(R.id.message);
        message.setText("Enter From");

        spinner1=(Spinner)findViewById(R.id.spinner1);
        adapter=ArrayAdapter.createFromResource(this,R.array.length_name_from,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                name=parent.getItemAtPosition(position).toString();
                if(name.matches("Kilometer")){
                    from=1;
                }
                else if(name.matches("Centimeter")){
                    from=2;
                }
                else if(name.matches("Millimeter")){
                    from=3;
                }
                else if(name.matches("Mile")){
                    from=4;
                }
                else if(name.matches("Foot")){
                    from=5;
                }
                else if(name.matches("Inch")){
                    from=6;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        spinner2=(Spinner)findViewById(R.id.spinner2);
        adapter=ArrayAdapter.createFromResource(this,R.array.length_name_from,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter);

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                name=parent.getItemAtPosition(position).toString();
                if(name.matches("Kilometer")){
                    to=1;
                }
                else if(name.matches("Centimeter")){
                    to=2;
                }
                else if(name.matches("Millimeter")){
                    to=3;
                }
                else if(name.matches("Mile")){
                    to=4;
                }
                else if(name.matches("Foot")){
                    to=5;
                }
                else if(name.matches("Inch")){
                    to=6;
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
                db.addHistory(new History(0,textView2.getText().toString()+"km",textView3.getText().toString()+"km"));
            }
            if (from == 1 && to == 2) {
                a = a * 100000;
                textView3.setText("" + a);
                DatabaseHandler db = new DatabaseHandler(this);
                db.addHistory(new History(0,textView2.getText().toString()+"km",textView3.getText().toString()+"cm"));
            }
            if (from == 1 && to == 3) {
                a = a * 1000000;
                textView3.setText("" + a);
                DatabaseHandler db = new DatabaseHandler(this);
                db.addHistory(new History(0,textView2.getText().toString()+"km",textView3.getText().toString()+"mm"));
            }
            if (from == 1 && to == 4) {
                a = a * 0.6213688756;
                textView3.setText("" + a);
                DatabaseHandler db = new DatabaseHandler(this);
                db.addHistory(new History(0,textView2.getText().toString()+"km",textView3.getText().toString()+"mile"));
            }
            if (from == 1 && to == 5) {
                a = a * 3280.839895;
                textView3.setText("" + a);
                DatabaseHandler db = new DatabaseHandler(this);
                db.addHistory(new History(0,textView2.getText().toString()+"km",textView3.getText().toString()+"foot"));
            }
            if (from == 1 && to == 6) {
                a = a * 39370.07874;
                textView3.setText("" + a);
                DatabaseHandler db = new DatabaseHandler(this);
                db.addHistory(new History(0,textView2.getText().toString()+"km",textView3.getText().toString()+"inch"));
            }

            if (from == 2 && to == 1) {
                a = a * .00001;
                textView3.setText("" + a);
                DatabaseHandler db = new DatabaseHandler(this);
                db.addHistory(new History(0,textView2.getText().toString()+"cm",textView3.getText().toString()+"km"));
            }

            if (from == 2 && to == 2) {
                textView3.setText("" + a);
                DatabaseHandler db = new DatabaseHandler(this);
                db.addHistory(new History(0,textView2.getText().toString()+"cm",textView3.getText().toString()+"cm"));
            }
            if (from == 2 && to == 3) {
                a = a * 10;
                textView3.setText("" + a);
                DatabaseHandler db = new DatabaseHandler(this);
                db.addHistory(new History(0,textView2.getText().toString()+"cm",textView3.getText().toString()+"mm"));
            }
            if (from == 2 && to == 4) {
                a = a * 0.0000062137;
                textView3.setText("" + a);
                DatabaseHandler db = new DatabaseHandler(this);
                db.addHistory(new History(0,textView2.getText().toString()+"cm",textView3.getText().toString()+"mile"));
            }
            if (from == 2 && to == 5) {
                a = a * 0.032808399;
                textView3.setText("" + a);
                DatabaseHandler db = new DatabaseHandler(this);
                db.addHistory(new History(0,textView2.getText().toString()+"cm",textView3.getText().toString()+"foot"));
            }
            if (from == 2 && to == 6) {
                a = a * 0.3937007874;
                textView3.setText("" + a);
                DatabaseHandler db = new DatabaseHandler(this);
                db.addHistory(new History(0,textView2.getText().toString()+"cm",textView3.getText().toString()+"inch"));
            }
            if (from == 3 && to == 1) {
                a = a * 0.000001;
                textView3.setText("" + a);
                DatabaseHandler db = new DatabaseHandler(this);
                db.addHistory(new History(0,textView2.getText().toString()+"mm",textView3.getText().toString()+"km"));
            }

            if (from == 3 && to == 2) {
                a=a*.1;
                textView3.setText("" + a);
                DatabaseHandler db = new DatabaseHandler(this);
                db.addHistory(new History(0,textView2.getText().toString()+"mm",textView3.getText().toString()+"cm"));
            }
            if (from == 3 && to == 3) {
                textView3.setText("" + a);
                DatabaseHandler db = new DatabaseHandler(this);
                db.addHistory(new History(0,textView2.getText().toString()+"mm",textView3.getText().toString()+"mm"));
            }
            if (from == 3 && to == 4) {
                a = a * 6.213688756E-7;
                textView3.setText("" + a);
                DatabaseHandler db = new DatabaseHandler(this);
                db.addHistory(new History(0,textView2.getText().toString()+"mm",textView3.getText().toString()+"mile"));
            }
            if (from == 3 && to == 5) {
                a = a * 0.0032808399;
                textView3.setText("" + a);
                DatabaseHandler db = new DatabaseHandler(this);
                db.addHistory(new History(0,textView2.getText().toString()+"mm",textView3.getText().toString()+"foot"));
            }
            if (from == 3 && to == 6) {
                a = a * 0.03937007874;
                textView3.setText("" + a);
                DatabaseHandler db = new DatabaseHandler(this);
                db.addHistory(new History(0,textView2.getText().toString()+"mm",textView3.getText().toString()+"inch"));
            }
            if (from == 4 && to == 1) {
                a = a * 1.60935;
                textView3.setText("" + a);
                DatabaseHandler db = new DatabaseHandler(this);
                db.addHistory(new History(0,textView2.getText().toString()+"mile",textView3.getText().toString()+"km"));
            }

            if (from == 4 && to == 2) {
                a=a*160935;
                textView3.setText("" + a);
                DatabaseHandler db = new DatabaseHandler(this);
                db.addHistory(new History(0,textView2.getText().toString()+"mile",textView3.getText().toString()+"cm"));
            }
            if (from == 4 && to == 3) {
                a=a*1609350;
                textView3.setText("" + a);
                DatabaseHandler db = new DatabaseHandler(this);
                db.addHistory(new History(0,textView2.getText().toString()+"mile",textView3.getText().toString()+"mm"));
            }
            if (from == 4 && to == 4) {
                textView3.setText("" + a);
                DatabaseHandler db = new DatabaseHandler(this);
                db.addHistory(new History(0,textView2.getText().toString()+"mile",textView3.getText().toString()+"mile"));
            }
            if (from == 4 && to == 5) {
                a = a * 5280.019685;
                textView3.setText("" + a);
                DatabaseHandler db = new DatabaseHandler(this);
                db.addHistory(new History(0,textView2.getText().toString()+"mile",textView3.getText().toString()+"foot"));
            }
            if (from == 4 && to == 6) {
                a = a * 63360.23622;
                textView3.setText("" + a);
                DatabaseHandler db = new DatabaseHandler(this);
                db.addHistory(new History(0,textView2.getText().toString()+"mile",textView3.getText().toString()+"inch"));
            }
            if (from == 5 && to == 1) {
                a = a * 0.0003048;
                textView3.setText("" + a);
                DatabaseHandler db = new DatabaseHandler(this);
                db.addHistory(new History(0,textView2.getText().toString()+"foor",textView3.getText().toString()+"km"));
            }
            if (from == 5 && to == 2) {
                a=a*30.48;
                textView3.setText("" + a);
                DatabaseHandler db = new DatabaseHandler(this);
                db.addHistory(new History(0,textView2.getText().toString()+"foor",textView3.getText().toString()+"cm"));
            }
            if (from == 5 && to == 3) {
                a=a*304.8;
                textView3.setText("" + a);
                DatabaseHandler db = new DatabaseHandler(this);
                db.addHistory(new History(0,textView2.getText().toString()+"foor",textView3.getText().toString()+"mm"));
            }
            if (from == 5 && to == 4) {
                a = a * 0.0001893932;
                textView3.setText("" + a);
                DatabaseHandler db = new DatabaseHandler(this);
                db.addHistory(new History(0,textView2.getText().toString()+"foor",textView3.getText().toString()+"mile"));
            }
            if (from == 5 && to == 5) {
                textView3.setText("" + a);
                DatabaseHandler db = new DatabaseHandler(this);
                db.addHistory(new History(0,textView2.getText().toString()+"foor",textView3.getText().toString()+"foot"));
            }
            if (from == 5 && to == 6) {
                a = a * 12;
                textView3.setText("" + a);
                DatabaseHandler db = new DatabaseHandler(this);
                db.addHistory(new History(0,textView2.getText().toString()+"foor",textView3.getText().toString()+"inch"));
            }
            if (from == 6 && to == 1) {
                a = a * 0.0000254;
                textView3.setText("" + a);
                DatabaseHandler db = new DatabaseHandler(this);
                db.addHistory(new History(0,textView2.getText().toString()+"inch",textView3.getText().toString()+"km"));
            }
            if (from == 6 && to == 2) {
                a=a*2.54;
                textView3.setText("" + a);
                DatabaseHandler db = new DatabaseHandler(this);
                db.addHistory(new History(0,textView2.getText().toString()+"inch",textView3.getText().toString()+"cm"));
            }
            if (from == 6 && to == 3) {
                a=a*25.4;
                textView3.setText("" + a);
                DatabaseHandler db = new DatabaseHandler(this);
                db.addHistory(new History(0,textView2.getText().toString()+"inch",textView3.getText().toString()+"mm"));
            }
            if (from == 6 && to == 4) {
                a = a * 0.0000157828;
                textView3.setText("" + a);
                DatabaseHandler db = new DatabaseHandler(this);
                db.addHistory(new History(0,textView2.getText().toString()+"inch",textView3.getText().toString()+"mile"));
            }
            if (from == 6 && to == 5) {
                a = a * 0.0833333333;
                textView3.setText("" + a);
                DatabaseHandler db = new DatabaseHandler(this);
                db.addHistory(new History(0,textView2.getText().toString()+"inch",textView3.getText().toString()+"foot"));
            }
            if (from == 6 && to == 6) {
                textView3.setText("" + a);
                DatabaseHandler db = new DatabaseHandler(this);
                db.addHistory(new History(0,textView2.getText().toString()+"inch",textView3.getText().toString()+"inch"));
            }
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
}
