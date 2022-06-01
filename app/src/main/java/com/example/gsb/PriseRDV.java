package com.example.gsb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.Spinner;


import java.util.ArrayList;
import java.util.List;

public class PriseRDV extends AppCompatActivity {
    Spinner spin;
    int idSelect;
    String pros[] = {"bonjour", "ta mere"};
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

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                curDate = String.valueOf(dayOfMonth + "/" + String.valueOf(month));
            }
        });
        /*listPro = db.getNomPro();
        if (listPro.moveToFirst()) {
            while(!listPro.isAfterLast()) {
                pros.add(listPro.getString(1));
                listPro.moveToNext();
            }
        }*/
        /*for (int i = 0; i < db.getNomPro().getCount(); i++) {
            pros.add(db.getNomPro().getString(1));
        }*/
        ArrayAdapter<String> aaListPro = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, pros);
        aaListPro.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aaListPro);
    }

    public void clicPriseRDV(View view){
        Cursor nomPro = db.getNomProSelectionne(idSelect);
        db.insertDataRdv(nomPro, curDate, heure);
    }



}