package com.example.ali.calculator;

import android.icu.text.DecimalFormat;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.tonmo.calculator.History.DatabaseHandler;
import com.example.tonmo.calculator.History.History;

public class VectorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vector);
        TextView message =(TextView)findViewById(R.id.message);
        message.setText("Enter i1");

    }
    double i1,i2,j1,j2,k1,k2,count=1;
    String string ="";
    public void onClick(View v){


        TextView message =(TextView)findViewById(R.id.message);
        TextView input =(TextView)findViewById(R.id.input);
        TextView output =(TextView)findViewById(R.id.output);
        Button button =(Button) v;

        string=(String) button.getText().toString();
        input.setText(input.getText().toString()+ string);

    }
    public void equal(View v){
        TextView veci1 =(TextView)findViewById(R.id.veci1);
        TextView veci2 =(TextView)findViewById(R.id.veci2);
        TextView vecj1 =(TextView)findViewById(R.id.vecj1);
        TextView vecj2 =(TextView)findViewById(R.id.vecj2);
        TextView veck1 =(TextView)findViewById(R.id.veck1);
        TextView veck2 =(TextView)findViewById(R.id.veck2);

        TextView message =(TextView)findViewById(R.id.message);
        TextView input =(TextView)findViewById(R.id.input);
        TextView output =(TextView)findViewById(R.id.output);
        if(count==6){
            k2=Double.parseDouble(input.getText().toString());
            message.setText("");
            veck2.setText(""+k2);
            input.setText("");
            count++;
        }
        if(count==5){
            j2=Double.parseDouble(input.getText().toString());
            message.setText("Enter k2");
            vecj2.setText(""+j2);
            input.setText("");
            count++;
        }
        if(count==4){
            i2=Double.parseDouble(input.getText().toString());
            message.setText("Enter j2");
            veci2.setText(""+i2);
            input.setText("");
            count++;
        }
        if(count==3){
            k1=Double.parseDouble(input.getText().toString());
            message.setText("Enter i2");
            veck1.setText(""+k1);
            input.setText("");
            count++;
        }
        if(count==2){
            j1=Double.parseDouble(input.getText().toString());
            message.setText("Enter k1");
            vecj1.setText(""+j1);
            input.setText("");
            count++;
        }
        if(count==1){
            i1=Double.parseDouble(input.getText().toString());
            message.setText("Enter j1");
            veci1.setText(""+i1);
            input.setText("");
            count++;
        }

    }
    public void Addition(View v){
        double i1,i2,j1,j2,k1,k2,cali,calj,calk;
        String i,j,k;
        TextView veci1 =(TextView)findViewById(R.id.veci1);
        TextView veci2 =(TextView)findViewById(R.id.veci2);
        TextView vecj1 =(TextView)findViewById(R.id.vecj1);
        TextView vecj2 =(TextView)findViewById(R.id.vecj2);
        TextView veck1 =(TextView)findViewById(R.id.veck1);
        TextView veck2 =(TextView)findViewById(R.id.veck2);

        TextView message =(TextView)findViewById(R.id.message);
        TextView input =(TextView)findViewById(R.id.input);
        TextView output =(TextView)findViewById(R.id.output);

        i1= Double.parseDouble(veci1.getText().toString());
        i2= Double.parseDouble(veci2.getText().toString());
        j1= Double.parseDouble(vecj1.getText().toString());
        j2= Double.parseDouble(vecj2.getText().toString());
        k1= Double.parseDouble(veck1.getText().toString());
        k2= Double.parseDouble(veck2.getText().toString());
        cali=i1+i2;
        calj=j1+j2;
        calk=k1+k2;
        input.setText("("+i1+"i+"+j1+"j+"+k1+"k) + ("+i2+"i+"+j2+"j+"+k2+"k)");
        output.setText(cali+"i+"+calj+"j+"+calk+"k");

        DatabaseHandler db = new DatabaseHandler(this);
        db.addHistory(new History(0,input.getText().toString(),output.getText().toString()));
    }
    public void Subtraction(View v){
        double i1,i2,j1,j2,k1,k2,cali,calj,calk;
        String i,j,k;
        TextView veci1 =(TextView)findViewById(R.id.veci1);
        TextView veci2 =(TextView)findViewById(R.id.veci2);
        TextView vecj1 =(TextView)findViewById(R.id.vecj1);
        TextView vecj2 =(TextView)findViewById(R.id.vecj2);
        TextView veck1 =(TextView)findViewById(R.id.veck1);
        TextView veck2 =(TextView)findViewById(R.id.veck2);

        TextView message =(TextView)findViewById(R.id.message);
        TextView input =(TextView)findViewById(R.id.input);
        TextView output =(TextView)findViewById(R.id.output);

        i1= Double.parseDouble(veci1.getText().toString());
        i2= Double.parseDouble(veci2.getText().toString());
        j1= Double.parseDouble(vecj1.getText().toString());
        j2= Double.parseDouble(vecj2.getText().toString());
        k1= Double.parseDouble(veck1.getText().toString());
        k2= Double.parseDouble(veck2.getText().toString());
        cali=i1-i2;
        calj=j1-j2;
        calk=k1-k2;
        input.setText("("+i1+"i+"+j1+"j+"+k1+"k) - ("+i2+"i+"+j2+"j+"+k2+"k)");
        output.setText(cali+"i+"+calj+"j+"+calk+"k");
        DatabaseHandler db = new DatabaseHandler(this);
        db.addHistory(new History(0,input.getText().toString(),output.getText().toString()));
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void ModA(View v){
        double cal;
        TextView veci1 =(TextView)findViewById(R.id.veci1);
        TextView veci2 =(TextView)findViewById(R.id.veci2);
        TextView vecj1 =(TextView)findViewById(R.id.vecj1);
        TextView vecj2 =(TextView)findViewById(R.id.vecj2);
        TextView veck1 =(TextView)findViewById(R.id.veck1);
        TextView veck2 =(TextView)findViewById(R.id.veck2);

        TextView message =(TextView)findViewById(R.id.message);
        TextView input =(TextView)findViewById(R.id.input);
        TextView output =(TextView)findViewById(R.id.output);

        i1= Double.parseDouble(veci1.getText().toString());
        j1= Double.parseDouble(vecj1.getText().toString());
        k1= Double.parseDouble(veck1.getText().toString());
        DecimalFormat decFor = new DecimalFormat("0.00");
        cal=Math.sqrt((i1*i1)+(j1*j1)+(k1*k1));

        input.setText("sqrt(+"+i1+"*"+i1+"+"+j1+"*"+j1+"+"+k1+"*"+k1);
        output.setText("ModA="+decFor.format(cal));
        DatabaseHandler db = new DatabaseHandler(this);
        db.addHistory(new History(0,input.getText().toString(),output.getText().toString()));

    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void ModB(View v){
        double cal;
        TextView veci1 =(TextView)findViewById(R.id.veci1);
        TextView veci2 =(TextView)findViewById(R.id.veci2);
        TextView vecj1 =(TextView)findViewById(R.id.vecj1);
        TextView vecj2 =(TextView)findViewById(R.id.vecj2);
        TextView veck1 =(TextView)findViewById(R.id.veck1);
        TextView veck2 =(TextView)findViewById(R.id.veck2);

        TextView message =(TextView)findViewById(R.id.message);
        TextView input =(TextView)findViewById(R.id.input);
        TextView output =(TextView)findViewById(R.id.output);

        i2= Double.parseDouble(veci2.getText().toString());
        j2= Double.parseDouble(vecj2.getText().toString());
        k2= Double.parseDouble(veck2.getText().toString());

        DecimalFormat decFor = new DecimalFormat("0.00");
        cal=Math.sqrt((i2*i2)+(j2*j2)+(k2*k2));

        input.setText("sqrt(+"+i2+"*"+i2+"+"+j2+"*"+j2+"+"+k2+"*"+k2);
        output.setText("ModB="+decFor.format(cal));

        DatabaseHandler db = new DatabaseHandler(this);
        db.addHistory(new History(0,input.getText().toString(),output.getText().toString()));

    }
    public void DotProduct(View v){
        double cal;
        TextView veci1 =(TextView)findViewById(R.id.veci1);
        TextView veci2 =(TextView)findViewById(R.id.veci2);
        TextView vecj1 =(TextView)findViewById(R.id.vecj1);
        TextView vecj2 =(TextView)findViewById(R.id.vecj2);
        TextView veck1 =(TextView)findViewById(R.id.veck1);
        TextView veck2 =(TextView)findViewById(R.id.veck2);

        TextView message =(TextView)findViewById(R.id.message);
        TextView input =(TextView)findViewById(R.id.input);
        TextView output =(TextView)findViewById(R.id.output);

        i1= Double.parseDouble(veci1.getText().toString());
        i2= Double.parseDouble(veci2.getText().toString());
        j1= Double.parseDouble(vecj1.getText().toString());
        j2= Double.parseDouble(vecj2.getText().toString());
        k1= Double.parseDouble(veck1.getText().toString());
        k2= Double.parseDouble(veck2.getText().toString());
        cal=(i1*i2)+(j1*j2)+(k1*k2);
        output.setText("Dot Product="+cal);
        DatabaseHandler db = new DatabaseHandler(this);
        db.addHistory(new History(0,input.getText().toString(),output.getText().toString()));
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void CrossProduct(View v){
        double cal,i,j,k;
        TextView veci1 =(TextView)findViewById(R.id.veci1);
        TextView veci2 =(TextView)findViewById(R.id.veci2);
        TextView vecj1 =(TextView)findViewById(R.id.vecj1);
        TextView vecj2 =(TextView)findViewById(R.id.vecj2);
        TextView veck1 =(TextView)findViewById(R.id.veck1);
        TextView veck2 =(TextView)findViewById(R.id.veck2);

        TextView message =(TextView)findViewById(R.id.message);
        TextView input =(TextView)findViewById(R.id.input);
        TextView output =(TextView)findViewById(R.id.output);

        i1= Double.parseDouble(veci1.getText().toString());
        i2= Double.parseDouble(veci2.getText().toString());
        j1= Double.parseDouble(vecj1.getText().toString());
        j2= Double.parseDouble(vecj2.getText().toString());
        k1= Double.parseDouble(veck1.getText().toString());
        k2= Double.parseDouble(veck2.getText().toString());

        i=(j1*k2)-(k1*j2);
        j=(k1*i2)-(i1*k2);
        k=(i1*j2)-(i2*j1);

        DecimalFormat decFor = new DecimalFormat("0.00");
        cal=cal=Math.sqrt((i*i)+(j*j)+(k*k));
        output.setText("Cross Product="+decFor.format(cal));
        DatabaseHandler db = new DatabaseHandler(this);
        db.addHistory(new History(0,input.getText().toString(),output.getText().toString()));

    }
    public void reset(View v){
        int i1;
        TextView input =(TextView)findViewById(R.id.input);
        i1=Integer.parseInt(input.getText().toString());
        i1=(int)i1/10;
        input.setText(""+i1);
    }
}
