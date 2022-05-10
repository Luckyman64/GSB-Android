package com.example.gsb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class creationProfessionnel extends AppCompatActivity {
    EditText nom;
    EditText prenom;
    EditText adresse;
    EditText mail;
    EditText tel;
    EditText type;
    SQLiteDataBase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creation_professionnel);
        nom = findViewById(R.id.editTextNom);
        prenom = findViewById(R.id.editTextPrenom);
        adresse = findViewById(R.id.editTextAdresse);
        mail = findViewById(R.id.editTextMail);
        tel = findViewById(R.id.editTextTel);
        type = findViewById(R.id.editTextType);
        db = new SQLiteDataBase(this);
    }

    public void clicRDV(View view){
        db.insertDataPro(nom.getText().toString(), prenom.getText().toString(), type.getText().toString(), adresse.getText().toString(), mail.getText().toString(), tel.getText().toString());
        nom.getText().clear();
        prenom.getText().clear();
        type.getText().clear();
        adresse.getText().clear();
        mail.getText().clear();
        tel.getText().clear();
    }
}