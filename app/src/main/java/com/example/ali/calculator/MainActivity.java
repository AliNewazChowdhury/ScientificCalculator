package com.example.ali.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ali.calculator.History.DatabaseHandler;
import com.example.ali.calculator.History.History;
import com.example.ali.calculator.History.HistoryActivity;

import java.util.ArrayDeque;
import java.util.ArrayList;

import static com.example.ali.calculator.R.id.input_main;
import static com.example.ali.calculator.R.id.textView;
import static com.example.ali.calculator.R.id.textView2;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    NavigationView navigationView = null;
    Toolbar toolbar = null;
    ViewPager viewPager;
    ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        MainFragment fragment = new MainFragment();
        android.support.v4.app.FragmentTransaction fragmentTransaction =
                getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container,fragment);
        fragmentTransaction.commit();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState(); //to synchronize the indicator with the state
                           // of the linked DrawerLayout after onRestoreInstanceState has occurred.

        viewPager = (ViewPager) findViewById(R.id.view_pager);//Layout manager that allows the user to flip left and right
                                                             // through pages of data, supply an implementation of a PagerAdapter
                                                            // to generate the pages that the view shows.
        adapter = new ViewPagerAdapter(getSupportFragmentManager()); //is an object

        adapter.addFragment(new MainFragment());

        viewPager.setAdapter(adapter);

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    ArrayList<String> arrayList=new ArrayList<String>();
    String string ="";
    String string1="";
    public void onClick1(View v){
        String a,b;
        TextView textView2 =(TextView)findViewById(R.id.input_main);
        Button button =(Button) v;
        string=(String) button.getText().toString();
        if(!string.contains("+") && !string.contains("-")&&!string.contains("*")&&!string.contains("/")){

            string1=string1+string;
            if(arrayList.size()>0){
                arrayList.remove((arrayList.size()-1));
            }

            arrayList.add(string1);
        }
        else{
            arrayList.add(string);
            arrayList.add(string);
            string1="";
        }
        textView2.setText(textView2.getText().toString()+string);
        //textView2.setText(arrayList.toString());

    }
    public void onClick(View v){
        TextView result_main=(TextView)findViewById(R.id.result_main);
        double cal=0;
        int c=arrayList.size();
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
            result_main.setText(Double.toString(cal));
        }
        catch (NumberFormatException e){
            result_main.setText("Error");
        }
        TextView textView2 =(TextView)findViewById(R.id.input_main);
        DatabaseHandler db = new DatabaseHandler(this);
        db.addHistory(new History(0,textView2.getText().toString(),result_main.getText().toString()));

    }
    public void clear(View v){
        TextView textView1=(TextView)findViewById(R.id.result_main);
        TextView textView2=(TextView)findViewById(R.id.input_main);

        string1="";
        string="";
        textView1.setText("0");
        textView2.setText("");
        arrayList.clear();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_history) {
            Intent intent = new Intent(MainActivity.this, HistoryActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.basic) {

            Intent intent = new Intent(MainActivity.this,StandAloneActivity.class);
            startActivity(intent);
        }
        else if (id == R.id.trigon) {
            Intent intent = new Intent(MainActivity.this,TrigonometryActivity.class);
            startActivity(intent);

        }
        else if (id == R.id.mat) {
            Intent intent = new Intent(MainActivity.this,MatrixActivity.class);
            startActivity(intent);
        }
        else if (id == R.id.vec) {
            Intent intent = new Intent(MainActivity.this,VectorActivity.class);
            startActivity(intent);

        }
        else if (id == R.id.constants) {
            Intent intent = new Intent(MainActivity.this,constants.class);
            startActivity(intent);
        }
        else if (id == R.id.conversion) {
            Intent intent = new Intent(MainActivity.this,conversion.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
