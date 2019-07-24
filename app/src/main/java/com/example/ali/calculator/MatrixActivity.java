package com.example.ali.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MatrixActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matrix);
        TextView textView2 =(TextView)findViewById(R.id.textView2);
        TextView textView5 =(TextView)findViewById(R.id.textView5);
        textView2.setText("Enter number of Row");
        textView5.setText(" Matrix A");
    }
    String string ="";
    public int a=1,row1,column1,row2,column2,i=1,j=1,check=1,sum=0,k;
    int first[][] = new int[10][10];
    int second[][] = new int[10][10];
    int Addition[][] = new int[10][10];
    int Subtraction[][] = new int[10][10];
    int Multiplication[][] = new int[10][10];


    public void onClick(View v){
        TextView textView2 =(TextView)findViewById(R.id.textView2);
        TextView textView3 =(TextView)findViewById(R.id.textView3);
        TextView textView5 =(TextView)findViewById(R.id.textView5);
        Button button =(Button) v;
        string=(String) button.getText().toString();
        textView3.setText(textView3.getText().toString()+string);

    }
    public void equal(View v){
        TextView textView2 =(TextView)findViewById(R.id.textView2);
        TextView textView3 =(TextView)findViewById(R.id.textView3);
        TextView textView5 =(TextView)findViewById(R.id.textView5);
        if(a==6){
            if(check==1) {
                second[i][j] = Integer.parseInt(textView3.getText().toString());
                j++;
                if (j > column2) {
                    i++;
                    j = 1;
                }
                if (i > row2) {
                    a++;
                    textView2.setText("");
                    textView3.setText("");
                } else if (i <= row2) {
                    textView2.setText("Enter position " + i + j);
                    textView3.setText("");
                }
            }

        }
        if(a==5){
            if(check==1) {
                first[i][j] = Integer.parseInt(textView3.getText().toString());
                j++;
                if (j > column1) {
                    i++;
                    j = 1;
                }
                if (i > row1) {
                    a++;
                    i = 1;
                    j = 1;
                    textView5.setText(" Matrix B");
                }
                textView2.setText("Enter position " + i + j);
                textView3.setText("");
            }
        }
        if(a==4) {
            column2 = Integer.parseInt(textView3.getText().toString());
            a++;
            textView5.setText(" Matrix A");
            if(column1==row2) {
                textView2.setText("Enter position 11");
                textView3.setText("");
            }
            else{
                textView2.setText("Column1 should be equal to row2");
                textView3.setText("");
                check=0;
            }
        }
        if(a==3) {
            row2 = Integer.parseInt(textView3.getText().toString());
            a++;
            textView2.setText("Enter number of Column");
            textView3.setText("");
        }
        if(a==2) {
            column1 = Integer.parseInt(textView3.getText().toString());
            a++;
            textView2.setText("Enter number of Row");
            textView3.setText("");
            textView5.setText(" Matrix B");
        }
        if(a==1){
            row1=Integer.parseInt(textView3.getText().toString());
            textView2.setText("Enter number of Column");
            textView3.setText("");
            a++;
        }

    }
    public void Clear(View v){
        TextView textView2 =(TextView)findViewById(R.id.textView2);
        TextView textView3 =(TextView)findViewById(R.id.textView3);
        TextView textView5 =(TextView)findViewById(R.id.textView5);

        TextView result1 = (TextView) findViewById(R.id.result1);
        TextView result2 = (TextView) findViewById(R.id.result2);
        TextView result3 = (TextView) findViewById(R.id.result3);
        TextView result4 = (TextView) findViewById(R.id.result4);
        TextView result5 = (TextView) findViewById(R.id.result5);
        TextView result6 = (TextView) findViewById(R.id.result6);
        TextView result7 = (TextView) findViewById(R.id.result7);
        TextView result8 = (TextView) findViewById(R.id.result8);
        TextView result9 = (TextView) findViewById(R.id.result9);

        textView2.setText("Enter number of Row");
        textView3.setText("");
        result1.setText("");
        result2.setText("");
        result3.setText("");
        result4.setText("");
        result5.setText("");
        result6.setText("");
        result7.setText("");
        result8.setText("");
        result9.setText("");

        textView5.setText(" Matrix A");
        a=1;
        row1=0;
        column1=0;
        row2=0;
        column2=0;
        i=1;
        j=1;
        check=1;

    }
    public void Addition(View v){
        int count=1;
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        TextView textView3 = (TextView) findViewById(R.id.textView3);
        TextView textView5 = (TextView) findViewById(R.id.textView5);

        TextView result1 = (TextView) findViewById(R.id.result1);
        TextView result2 = (TextView) findViewById(R.id.result2);
        TextView result3 = (TextView) findViewById(R.id.result3);
        TextView result4 = (TextView) findViewById(R.id.result4);
        TextView result5 = (TextView) findViewById(R.id.result5);
        TextView result6 = (TextView) findViewById(R.id.result6);
        TextView result7 = (TextView) findViewById(R.id.result7);
        TextView result8 = (TextView) findViewById(R.id.result8);
        TextView result9 = (TextView) findViewById(R.id.result9);
        if((row1==row2) && (column1==column2)) {

            textView5.setText("  A+B");
            for (i = 1; i <= row1; i++) {
                if(i==2)
                    count=4;
                if(i==3)
                    count=7;
                for (j = 1; j <= column1; j++) {
                    Addition[i][j] = first[i][j] + second[i][j];
                    if(count==9){
                        result9.setText(""+Addition[i][j]);
                        count++;
                    }
                    if(count==8){
                        result8.setText(""+Addition[i][j]);
                        count++;
                    }
                    if(count==7){
                        result7.setText(""+Addition[i][j]);
                        count++;
                    }
                    if(count==6){
                        result6.setText(""+Addition[i][j]);
                        count++;
                    }
                    if(count==5){
                        result5.setText(""+Addition[i][j]);
                        count++;
                    }
                    if(count==4){
                        result4.setText(""+Addition[i][j]);
                        count++;
                    }
                    if(count==3){
                        result3.setText(""+Addition[i][j]);
                        count++;
                    }
                    if(count==2){
                        result2.setText(""+Addition[i][j]);
                        count++;
                    }
                    if(count==1){
                        result1.setText(""+Addition[i][j]);
                        count++;
                    }
                }

            }
        }
        else{
            textView2.setText("Order Must be Same");
        }
    }

    public void Subtraction(View v){
        int count=1;
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        TextView textView3 = (TextView) findViewById(R.id.textView3);
        TextView textView5 = (TextView) findViewById(R.id.textView5);

        TextView result1 = (TextView) findViewById(R.id.result1);
        TextView result2 = (TextView) findViewById(R.id.result2);
        TextView result3 = (TextView) findViewById(R.id.result3);
        TextView result4 = (TextView) findViewById(R.id.result4);
        TextView result5 = (TextView) findViewById(R.id.result5);
        TextView result6 = (TextView) findViewById(R.id.result6);
        TextView result7 = (TextView) findViewById(R.id.result7);
        TextView result8 = (TextView) findViewById(R.id.result8);
        TextView result9 = (TextView) findViewById(R.id.result9);
        if((row1==row2) && (column1==column2)) {

            textView5.setText("  A-B");
            for (i = 1; i <= row1; i++) {
                if(i==2)
                    count=4;
                if(i==3)
                    count=7;
                for (j = 1; j <= column1; j++) {
                    Addition[i][j] = first[i][j] - second[i][j];
                    if(count==9){
                        result9.setText(""+Addition[i][j]);
                        count++;
                    }
                    if(count==8){
                        result8.setText(""+Addition[i][j]);
                        count++;
                    }
                    if(count==7){
                        result7.setText(""+Addition[i][j]);
                        count++;
                    }
                    if(count==6){
                        result6.setText(""+Addition[i][j]);
                        count++;
                    }
                    if(count==5){
                        result5.setText(""+Addition[i][j]);
                        count++;
                    }
                    if(count==4){
                        result4.setText(""+Addition[i][j]);
                        count++;
                    }
                    if(count==3){
                        result3.setText(""+Addition[i][j]);
                        count++;
                    }
                    if(count==2){
                        result2.setText(""+Addition[i][j]);
                        count++;
                    }
                    if(count==1){
                        result1.setText(""+Addition[i][j]);
                        count++;
                    }
                }

            }
        }
        else{
            textView2.setText("Order Must be Same");
        }
    }
    public void Multiplication(View v){
        int count=1;
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        TextView textView3 = (TextView) findViewById(R.id.textView3);
        TextView textView5 = (TextView) findViewById(R.id.textView5);

        TextView result1 = (TextView) findViewById(R.id.result1);
        TextView result2 = (TextView) findViewById(R.id.result2);
        TextView result3 = (TextView) findViewById(R.id.result3);
        TextView result4 = (TextView) findViewById(R.id.result4);
        TextView result5 = (TextView) findViewById(R.id.result5);
        TextView result6 = (TextView) findViewById(R.id.result6);
        TextView result7 = (TextView) findViewById(R.id.result7);
        TextView result8 = (TextView) findViewById(R.id.result8);
        TextView result9 = (TextView) findViewById(R.id.result9);
        if(column1==row2) {

            textView5.setText("  A*B");
            for ( i = 1 ; i <= row1 ; i++ )
            {
                for ( j = 1 ; j <= column2 ; j++ )
                {
                    for ( k = 1 ; k <= row2 ; k++ )
                    {
                        sum= sum + first[i][k]*second[k][j];
                    }
                    Multiplication[i][j] = sum;
                    sum = 0;
                }

            }
            count=1;
            for(i=1;i<=row1;i++){
                if(i==2)
                    count=4;
                if(i==3)
                    count=7;
                for(j=1;j<=column2;j++){
                    if(count==9){
                        result9.setText(""+Multiplication[i][j]);
                        count++;
                    }
                    if(count==8){
                        result8.setText(""+Multiplication[i][j]);
                        count++;
                    }
                    if(count==7){
                        result7.setText(""+Multiplication[i][j]);
                        count++;
                    }
                    if(count==6){
                        result6.setText(""+Multiplication[i][j]);
                        count++;
                    }
                    if(count==5){
                        result5.setText(""+Multiplication[i][j]);
                        count++;
                    }
                    if(count==4){
                        result4.setText(""+Multiplication[i][j]);
                        count++;
                    }
                    if(count==3){
                        result3.setText(""+Multiplication[i][j]);
                        count++;
                    }
                    if(count==2){
                        result2.setText(""+Multiplication[i][j]);
                        count++;
                    }
                    if(count==1){
                        result1.setText(""+Multiplication[i][j]);
                        count++;
                    }
                }
            }

        }
        else{
            textView2.setText("Order Must be Same");
        }
    }
    public void detA(View v){
        double det;
        TextView textView4 = (TextView) findViewById(R.id.textView3);
        TextView textView5 = (TextView) findViewById(R.id.textView5);
        if(row1==column1){
            if(row1==1){
                det=first[1][1];
                textView4.setText(""+det);
            }
            if(row1==2){
                det=(first[1][1]*first[2][2])-(first[1][2]*first[2][1]);
                textView4.setText(""+det);
            }
            if(row1==3){
                det=first[1][1]*( ((first[2][2])*first[3][3])-((first[2][3])*first[3][2]) ) - first[1][2]*( ((first[2][1])*first[3][3])-((first[2][3])*first[3][1]) )+first[1][3]*( ((first[2][1])*first[3][2])-((first[2][2])*first[3][1]) );
                textView4.setText(""+det);
            }
        }
        else{
            textView4.setText("Not a Square Matrix");
        }
    }
    public void detB(View v){
        double det;
        TextView textView4 = (TextView) findViewById(R.id.textView3);
        TextView textView5 = (TextView) findViewById(R.id.textView5);
        if(row1==column1){
            if(row1==1){
                det=second[1][1];
                textView4.setText(""+det);
            }
            if(row1==2){
                det=(second[1][1]*second[2][2])-(second[1][2]*second[2][1]);
                textView4.setText(""+det);
            }
            if(row1==3){
                det=second[1][1]*( ((second[2][2])*second[3][3])-((second[2][3])*second[3][2]) ) - second[1][2]*( ((second[2][1])*second[3][3])-((second[2][3])*second[3][1]) )+second[1][3]*( ((second[2][1])*second[3][2])-((second[2][2])*second[3][1]) );
                textView4.setText(""+det);
            }
        }
        else{
            textView4.setText("Not a Square Matrix");
        }
    }
}
