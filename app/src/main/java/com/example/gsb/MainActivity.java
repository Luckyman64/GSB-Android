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

public class MainActivity extends AppCompatActivity {
    EditText textAfficher;
    SQLiteDataBase db;
    CalendarView calendrier;
    String curDate;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textAfficher = findViewById(R.id.editTextAfficher);
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
                texte = texte + String.valueOf(data.getString(0) + " " + data.getString(1));
            }
            textAfficher.setText(texte);
        }
        catch(Exception e){
            textAfficher.setText(e.getMessage());
        }
    }




};