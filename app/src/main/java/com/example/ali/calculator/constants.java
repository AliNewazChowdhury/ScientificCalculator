package com.example.ali.calculator;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class constants extends Activity {
    Spinner spinner;
    ArrayAdapter<CharSequence>adapter;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constants);
        spinner=(Spinner)findViewById(R.id.spinner);
        adapter=ArrayAdapter.createFromResource(this,R.array.constants_name,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView textView=(TextView)findViewById(R.id.view);
                name=parent.getItemAtPosition(position).toString();
                if(name.matches("Speed of Light")) {
                    textView.setText("Speed of light · c \n" +
                            "299,792,458" +
                            "m/s \n" +
                            "Example · Mass–energy equivalence\n" +
                            "E = mc2");
                }
                else if(name.matches("Gravitation Constant")){
                    textView.setText("Gravitational constant · G \n" +
                            "6.674083131313131313" +
                            "x10^-11Nm2/kg2 \n" +
                            "Example · Newton's Law of Universal Gravitation\n" +
                            "F = Gm1m2/r2");
                }
                else if(name.matches("Acceleration due to gravity")){
                    textView.setText("Acceleration due to gravity · g \n" +
                            "9.81" +
                            "m/s2 \n" +
                            "Example · Weight\n" +
                            "W = mg");

                }
                else if(name.matches("Atomic mass unit")){
                    textView.setText("Atomic mass unit · a.m.u \n" +
                            "1.660538921(73)×10−27 kg.");
                }
                else if(name.matches("Avogadro Constant")){
                    textView.setText("Avogadro Constant\n" +
                            "6.02214085774747" +
                            "x10^23mol-1 ");
                }
                else if(name.matches("Bohr radius")){
                    textView.setText("Bohr radius · a0 \n" +
                            "5.2917721092171717171717171" +
                            "×10−11m \n" +
                            "Example · Radius for any atom\n" +
                            "r = n2 a0/Z");
                }
                else if(name.matches("Boltzmann constant")){
                    textView.setText("Boltzmann constant · k \n" +
                            "1.3806488131313" +
                            "x10-23J/K\n" +
                            "Example · The ideal gas law into an alternative form\n" +
                            "pV = NkT ");
                }
                else if(name.matches("Faraday constant")){
                    textView.setText("Faraday constant · F \n" +
                            "96,485.33289595" +
                            "C/mol \n" +
                            "Example · Current by electrolysis\n" +
                            "I = nF/t ");
                }
                else if(name.matches("Gas constant")){
                    textView.setText("Gas constant · R \n" +
                            "8.31445984848484848484" +
                            "J K-1mol-1 \n" +
                            "Example · Ideal gas law\n" +
                            "PV = NRT ");
                }
                else if(name.matches("Neutron mass energy (MeV)")){
                    textView.setText("Neutron mass energy (MeV) \n" +
                            "939.565 MeV");
                }
                else if(name.matches("Permeability of a vacuum")){
                    textView.setText("Permeability of a vacuum µ0 \n" +
                            "4π×10−7 N/A2 ≈ 1.2566370614×10−6 H/m or T·m/A or Wb/(A·m) or V·s/(A·m)");
                }
                else if(name.matches("Permittivity of a vacuum")){
                    textView.setText("Permittivity of a vacuum ε0\n" +
                            "8.854187817×10−12 F⋅m−1 (farads per metre)");
                }
                else if(name.matches("Planck constant")){
                    textView.setText("Planck constant h\n" +
                            "6.626070040818181818181818" +
                            "x10-34Js");
                }
                else if(name.matches("Rydberg constant")){
                    textView.setText("Rydberg constant · R∞ \n" +
                            "10,973,731.568539555555555555" +
                            "m-1 \n" +
                            "Example · Rydberg unit of energy\n" +
                            "1 Ry = hc R∞");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
}
