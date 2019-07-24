package com.example.ali.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class StandAloneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stand_alone);
    }

    ArrayList<String> arrayList=new ArrayList<String>();
    String string ="";
    String string1="";
    int option=1;
    int check=0;
    int val;
    public void onClick1(View v){

        TextView textView2 =(TextView)findViewById(R.id.textView2);
        TextView textView1=(TextView)findViewById(R.id.textView);
        Button button =(Button) v;
        string=(String) button.getText().toString();
        if(string.contains("Dec")) {
            option = 1;
            /*if(!arrayList.isEmpty())
            {
                if(check==2)
                    textView1.setText(Integer.toBinaryString(val));

            }*/

            //textView2.setText(""+option);
        }
        else if(string.contains("Bin")) {
            option = 2;
            if(check==1 || check==3 || check==4)
                textView1.setText(Integer.toBinaryString(val));
            //textView2.setText(""+option);
        }
        else if(string.contains("Oct")) {
            option = 3;
            if(check==1 || check==2 || check==4)
                textView1.setText(Integer.toOctalString(val));
            //textView2.setText(""+option);
        }
        else if(string.contains("Hex")) {
            option = 4;
            if(check==1 || check==2 || check==3)
                textView1.setText(Integer.toHexString(val));
            //textView2.setText(""+option);
        }
        else {
            if (!string.contains("+") && !string.contains("-") && !string.contains("*") && !string.contains("/")) {
                string1 = string1 + string;
                if (arrayList.size() > 0) {
                    arrayList.remove((arrayList.size() - 1));
                }
                arrayList.add(string1);
            } else {
                arrayList.add(string);
                arrayList.add(string);
                string1 = "";
            }
            textView2.setText(textView2.getText().toString() + string);
        }
        //textView2.setText(arrayList.toString());

    }
    public void onClick(View v){
        TextView textView1=(TextView)findViewById(R.id.textView);
        TextView textView3=(TextView)findViewById(R.id.textView3);
        double cal=0;
        int cal2=0;
        int c=arrayList.size();
        if(option==1) {
            try {
                while (c != 1) {
                    if (c > 3) {
                        if (arrayList.get(3).contains("*") || arrayList.get(3).contains("/")) {


                            if (arrayList.get(3).contains("*")) {
                                cal = Double.parseDouble(arrayList.get(2)) * Double.parseDouble(arrayList.get(4));
                            }
                            if (arrayList.get(3).contains("/")) {
                                cal = Double.parseDouble(arrayList.get(2)) / Double.parseDouble(arrayList.get(4));
                            }

                            arrayList.remove(2);
                            arrayList.remove(2);
                            arrayList.remove(2);
                            arrayList.add(2, Double.toString(cal));
                            c = arrayList.size();
                        } else {
                            if (arrayList.get(1).contains("+")) {
                                cal = Double.parseDouble(arrayList.get(0)) + Double.parseDouble(arrayList.get(2));
                            }
                            if (arrayList.get(1).contains("-")) {
                                cal = Double.parseDouble(arrayList.get(0)) - Double.parseDouble(arrayList.get(2));
                            }
                            if (arrayList.get(1).contains("*")) {
                                cal = Double.parseDouble(arrayList.get(0)) * Double.parseDouble(arrayList.get(2));
                            }
                            if (arrayList.get(1).contains("/")) {
                                cal = Double.parseDouble(arrayList.get(0)) / Double.parseDouble(arrayList.get(2));
                            }
                            arrayList.remove(0);
                            arrayList.remove(0);
                            arrayList.remove(0);
                            arrayList.add(0, Double.toString(cal));
                            c = arrayList.size();

                        }
                    } else {
                        if (arrayList.get(1).contains("+")) {
                            cal = Double.parseDouble(arrayList.get(0)) + Double.parseDouble(arrayList.get(2));
                        }
                        if (arrayList.get(1).contains("-")) {
                            cal = Double.parseDouble(arrayList.get(0)) - Double.parseDouble(arrayList.get(2));
                        }
                        if (arrayList.get(1).contains("*")) {
                            cal = Double.parseDouble(arrayList.get(0)) * Double.parseDouble(arrayList.get(2));
                        }
                        if (arrayList.get(1).contains("/")) {
                            cal = Double.parseDouble(arrayList.get(0)) / Double.parseDouble(arrayList.get(2));
                        }
                        arrayList.remove(0);
                        arrayList.remove(0);
                        arrayList.remove(0);
                        arrayList.add(0, Double.toString(cal));
                        c = arrayList.size();
                    }
                }
                val=(int)cal;
                textView1.setText(Double.toString(cal));
                check=1;
            }
            catch(NumberFormatException e){
                textView3.setText("Invalid Input");
            }
        }
        if(option==2) {
            try {
                while (c != 1) {
                    if (c > 3) {
                        if (arrayList.get(3).contains("*") || arrayList.get(3).contains("/")) {


                            if (arrayList.get(3).contains("*")) {
                                cal2 = Integer.parseInt(arrayList.get(2), 2) * Integer.parseInt(arrayList.get(4), 2);
                            }
                            if (arrayList.get(3).contains("/")) {
                                cal2 = Integer.parseInt(arrayList.get(2), 2) / Integer.parseInt(arrayList.get(4), 2);
                            }
                            arrayList.remove(2);
                            arrayList.remove(2);
                            arrayList.remove(2);
                            arrayList.add(2, Double.toString(cal));
                            c = arrayList.size();
                        } else {
                            if (arrayList.get(1).contains("+")) {
                                cal2 = Integer.parseInt(arrayList.get(0), 2) + Integer.parseInt(arrayList.get(2), 2);
                            }
                            if (arrayList.get(1).contains("-")) {
                                cal2 = Integer.parseInt(arrayList.get(0), 2) - Integer.parseInt(arrayList.get(2), 2);
                            }
                            if (arrayList.get(1).contains("*")) {
                                cal2 = Integer.parseInt(arrayList.get(0), 2) * Integer.parseInt(arrayList.get(2), 2);
                            }
                            if (arrayList.get(1).contains("/")) {
                                cal2 = Integer.parseInt(arrayList.get(0), 2) / Integer.parseInt(arrayList.get(2), 2);
                            }
                            arrayList.remove(0);
                            arrayList.remove(0);
                            arrayList.remove(0);
                            arrayList.add(0, Integer.toString(cal2));
                            c = arrayList.size();

                        }
                    } else {
                        if (arrayList.get(1).contains("+")) {
                            cal2 = Integer.parseInt(arrayList.get(0), 2) + Integer.parseInt(arrayList.get(2), 2);
                        }
                        if (arrayList.get(1).contains("-")) {
                            cal2 = Integer.parseInt(arrayList.get(0), 2) - Integer.parseInt(arrayList.get(2), 2);
                        }
                        if (arrayList.get(1).contains("*")) {
                            cal2 = Integer.parseInt(arrayList.get(0), 2) * Integer.parseInt(arrayList.get(2), 2);
                        }
                        if (arrayList.get(1).contains("/")) {
                            cal2 = Integer.parseInt(arrayList.get(0), 2) / Integer.parseInt(arrayList.get(2), 2);
                        }
                        arrayList.remove(0);
                        arrayList.remove(0);
                        arrayList.remove(0);
                        arrayList.add(0, Integer.toString(cal2));
                        c = arrayList.size();
                    }
                }
                val=cal2;
                textView1.setText(Integer.toBinaryString(cal2));
                check=2;
            }
            catch(NumberFormatException e){
                textView3.setText("Invalid Input");
            }
        }
        if(option==3) {
            try {
                while (c != 1) {
                    if (c > 3) {
                        if (arrayList.get(3).contains("*") || arrayList.get(3).contains("/")) {


                            if (arrayList.get(3).contains("*")) {
                                cal2 = Integer.parseInt(arrayList.get(2), 8) * Integer.parseInt(arrayList.get(4), 8);
                            }
                            if (arrayList.get(3).contains("/")) {
                                cal2 = Integer.parseInt(arrayList.get(2), 8) / Integer.parseInt(arrayList.get(4), 8);
                            }
                            arrayList.remove(2);
                            arrayList.remove(2);
                            arrayList.remove(2);
                            arrayList.add(2, Double.toString(cal));
                            c = arrayList.size();
                        } else {
                            if (arrayList.get(1).contains("+")) {
                                cal2 = Integer.parseInt(arrayList.get(0), 8) + Integer.parseInt(arrayList.get(2), 8);
                            }
                            if (arrayList.get(1).contains("-")) {
                                cal2 = Integer.parseInt(arrayList.get(0), 8) - Integer.parseInt(arrayList.get(2), 8);
                            }
                            if (arrayList.get(1).contains("*")) {
                                cal2 = Integer.parseInt(arrayList.get(0), 8) * Integer.parseInt(arrayList.get(2), 8);
                            }
                            if (arrayList.get(1).contains("/")) {
                                cal2 = Integer.parseInt(arrayList.get(0), 8) / Integer.parseInt(arrayList.get(2), 8);
                            }
                            arrayList.remove(0);
                            arrayList.remove(0);
                            arrayList.remove(0);
                            arrayList.add(0, Integer.toString(cal2));
                            c = arrayList.size();

                        }
                    } else {
                        if (arrayList.get(1).contains("+")) {
                            cal2 = Integer.parseInt(arrayList.get(0), 8) + Integer.parseInt(arrayList.get(2), 8);
                        }
                        if (arrayList.get(1).contains("-")) {
                            cal2 = Integer.parseInt(arrayList.get(0), 8) - Integer.parseInt(arrayList.get(2), 8);
                        }
                        if (arrayList.get(1).contains("*")) {
                            cal2 = Integer.parseInt(arrayList.get(0), 8) * Integer.parseInt(arrayList.get(2), 8);
                        }
                        if (arrayList.get(1).contains("/")) {
                            cal2 = Integer.parseInt(arrayList.get(0), 8) / Integer.parseInt(arrayList.get(2), 8);
                        }
                        arrayList.remove(0);
                        arrayList.remove(0);
                        arrayList.remove(0);
                        arrayList.add(0, Integer.toString(cal2));
                        c = arrayList.size();
                    }
                }
                val=cal2;
                textView1.setText(Integer.toOctalString(cal2));
                check=3;
            }
            catch(NumberFormatException e){
                textView3.setText("Invalid Input");
            }
        }
        if(option==4) {
            try {
                while (c != 1) {
                    if (c > 3) {
                        if (arrayList.get(3).contains("*") || arrayList.get(3).contains("/")) {


                            if (arrayList.get(3).contains("*")) {
                                cal2 = Integer.parseInt(arrayList.get(2), 16) * Integer.parseInt(arrayList.get(4), 16);
                            }
                            if (arrayList.get(3).contains("/")) {
                                cal2 = Integer.parseInt(arrayList.get(2), 16) / Integer.parseInt(arrayList.get(4), 16);
                            }
                            arrayList.remove(2);
                            arrayList.remove(2);
                            arrayList.remove(2);
                            arrayList.add(2, Double.toString(cal));
                            c = arrayList.size();
                        } else {
                            if (arrayList.get(1).contains("+")) {
                                cal2 = Integer.parseInt(arrayList.get(0), 16) + Integer.parseInt(arrayList.get(2), 16);
                            }
                            if (arrayList.get(1).contains("-")) {
                                cal2 = Integer.parseInt(arrayList.get(0), 16) - Integer.parseInt(arrayList.get(2), 16);
                            }
                            if (arrayList.get(1).contains("*")) {
                                cal2 = Integer.parseInt(arrayList.get(0), 16) * Integer.parseInt(arrayList.get(2), 16);
                            }
                            if (arrayList.get(1).contains("/")) {
                                cal2 = Integer.parseInt(arrayList.get(0), 16) / Integer.parseInt(arrayList.get(2), 16);
                            }
                            arrayList.remove(0);
                            arrayList.remove(0);
                            arrayList.remove(0);
                            arrayList.add(0, Integer.toString(cal2));
                            c = arrayList.size();

                        }
                    } else {
                        if (arrayList.get(1).contains("+")) {
                            cal2 = Integer.parseInt(arrayList.get(0), 16) + Integer.parseInt(arrayList.get(2), 16);
                        }
                        if (arrayList.get(1).contains("-")) {
                            cal2 = Integer.parseInt(arrayList.get(0), 16) - Integer.parseInt(arrayList.get(2), 16);
                        }
                        if (arrayList.get(1).contains("*")) {
                            cal2 = Integer.parseInt(arrayList.get(0), 16) * Integer.parseInt(arrayList.get(2), 16);
                        }
                        if (arrayList.get(1).contains("/")) {
                            cal2 = Integer.parseInt(arrayList.get(0), 16) / Integer.parseInt(arrayList.get(2), 16);
                        }
                        arrayList.remove(0);
                        arrayList.remove(0);
                        arrayList.remove(0);
                        arrayList.add(0, Integer.toString(cal2));
                        c = arrayList.size();
                    }
                }
                val=cal2;
                textView1.setText(Integer.toHexString(cal2));
                check=4;
            }
            catch(NumberFormatException e){
                textView3.setText("Invalid Input");
            }
        }
    }
    public void clear(View v){
        TextView textView1=(TextView)findViewById(R.id.textView);
        TextView textView2=(TextView)findViewById(R.id.textView2);

        string1="";
        string="";
        textView1.setText("0");
        textView2.setText("");
        arrayList.clear();
        option=1;
        check=0;

    }
}
