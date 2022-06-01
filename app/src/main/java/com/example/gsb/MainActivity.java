package com.example.gsb;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    SQLiteDataBase db;
    CalendarView calendrier;
    String curDate;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinnerMain);
        db = new SQLiteDataBase(this);
        calendrier = findViewById(R.id.calendarViewPlanning);
        calendrier.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                curDate = dayOfMonth + "/" + month;
            }
        });
    }

    public void clicAfficher(View view){
        try{
            Cursor data = db.getRdv(curDate);
            String texte = "";
            while(data.moveToNext()){
                texte = String.valueOf(data.getString(3) + " " + data.getString(4));
            }
            ArrayAdapter<String> aaListPro = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Collections.singletonList(texte));
            aaListPro.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(aaListPro);
        }
        catch(Exception e){

        }
    }




};