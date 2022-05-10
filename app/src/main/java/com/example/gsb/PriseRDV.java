package com.example.gsb;

import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Spinner;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class PriseRDV extends AppCompatActivity {
    Spinner spin;
    int idSelect;
    ArrayList<String> pro;
    SQLiteDataBase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prise_rdv);
        spin = findViewById(R.id.spinnerRDV);
        db = new SQLiteDataBase(this);
        pro.add(db.getNomPro().toString());
        ArrayAdapter<String> aaRDV = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, pro);
        spin.setAdapter(aaRDV);

        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                idSelect = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    protected void buttonRDV(Bundle savedInstanceState){

    }



}