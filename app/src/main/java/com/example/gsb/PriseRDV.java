package com.example.gsb;

import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.Spinner;


import java.util.ArrayList;

public class PriseRDV extends AppCompatActivity {
    Spinner spin;
    int idSelect;
    ArrayList<String> pros;
    Cursor listPro;
    SQLiteDataBase db;
    View heure;
    CalendarView calendarView;
    String curDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prise_rdv);
        spin = findViewById(R.id.spinnerRDV);
        db = new SQLiteDataBase(this);
        heure = findViewById(R.id.editTextHeure);
        calendarView = findViewById((R.id.calendarViewRDV));
        listPro = db.getNomPro();
        /*int i = 0;
        if (listPro.getCount() > 0){
            listPro.moveToFirst();
            do {
                pros.set(i, listPro.getString(2));
            } while (listPro.moveToNext());
            listPro.close();
        }*/
        /*ArrayAdapter<String> aaRDV = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, pro);
        spin.setAdapter(aaRDV);

        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                idSelect = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });*/
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month,
                                            int dayOfMonth) {
                curDate = String.valueOf(dayOfMonth);
            }
        });
    }
    public void clicPriseRDV(View view){
        Cursor nomPro = db.getNomProSelectionne(idSelect);
        db.insertDataRdv(nomPro, curDate, heure);
    }



}