package com.example.gsb;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.List;

public class RechercheProfessionnels extends AppCompatActivity {
    EditText recherche, Affichage;
    SQLiteDataBase db;
    int idSelect;
    String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recherche_professionnels);

        recherche = findViewById(R.id.editTextRecherche);
        Affichage = findViewById(R.id.editTextRecherchePro);
        db = new SQLiteDataBase(this);
    }

    public void clicRecherche(View view){
        Cursor donnees = db.getRecherche(recherche.getText().toString());
        if (donnees.moveToFirst()) {
            str = donnees.getString(donnees.getColumnIndex("content"));
        }
        Affichage.setText(str);
    }
}