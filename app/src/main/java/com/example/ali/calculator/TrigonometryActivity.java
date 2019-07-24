package com.example.ali.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TrigonometryActivity extends AppCompatActivity {

    public Button button1,button2;
    public void init(){
        button1=(Button)findViewById(R.id.button1);
        button2=(Button)findViewById(R.id.button2);

        button1.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                Intent formula =new Intent(TrigonometryActivity.this,FormulaActivity.class);
                startActivity(formula);
            }
        });

        button2.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                Intent formula =new Intent(TrigonometryActivity.this,TriCalculationActivity.class);
                startActivity(formula);
            }
        });
    }
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trigonometry);
        init();
    }
}
