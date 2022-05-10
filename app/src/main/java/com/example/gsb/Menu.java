package com.example.gsb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void clicAfficherRDVMenu(View view){
        Intent intentAfficherRDV = new Intent(this, MainActivity.class);
        startActivity(intentAfficherRDV);
    }

    public void clicPriseRDVMenu(View view){
        Intent intentAfficherRDV = new Intent(this, PriseRDV.class);
        startActivity(intentAfficherRDV);
    }

    public void clicRechercheProMenu(View view){
        Intent intentAfficherRDV = new Intent(this, RechercheProfessionnels.class);
        startActivity(intentAfficherRDV);
    }

    public void clicCreationProMenu(View view){
        Intent intentAfficherRDV = new Intent(this, creationProfessionnel.class);
        startActivity(intentAfficherRDV);
    }
}