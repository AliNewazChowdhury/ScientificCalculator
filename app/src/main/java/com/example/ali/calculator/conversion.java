package com.example.ali.calculator;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class conversion extends Activity {
    public Button button1,button2,button3,button4;
    public void init(){
        button1=(Button)findViewById(R.id.button1);
        button2=(Button)findViewById(R.id.button2);
        button3=(Button)findViewById(R.id.button3);
        button4=(Button)findViewById(R.id.button4);

        button1.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                Intent formula =new Intent(conversion.this,length.class);
                startActivity(formula);
            }
        });

        button2.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                Intent formula =new Intent(conversion.this,temparature.class);
                startActivity(formula);
            }
        });
        button3.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                Intent formula =new Intent(conversion.this,area.class);
                startActivity(formula);
            }
        });

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion);
        init();


    }
}
