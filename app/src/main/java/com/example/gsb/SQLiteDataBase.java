package com.example.gsb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteDataBase extends SQLiteOpenHelper {
    public static final String DATABASE_Name = "GSB.bd";
    public static final String TABLE_NAME = "Professionnel_table";
    public static final String TABLE_NAME2 = "RDV_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "nom";
    public static final String COL_3 = "prenom";
    public static final String COL_4 = "type";
    public static final String COL_5 = "adresse";
    public static final String COL_6 = "mail";
    public static final String COL_7 = "tel";
    public static final String COL_8 = "date";
    public static final String COL_9 = "heure";
    public static final String COL_10 = "professionnel";

    public SQLiteDataBase(@Nullable Context context) {
        super(context, DATABASE_Name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE table " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, NOM TEXT, " +
                "PRENOM TEXT, TYPE TEXT, ADRESSE TEXT, MAIL TEXT, TEL TEXT)");
        db.execSQL("CREATE table " + TABLE_NAME2 + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, DATE TEXT, " +
                "PROFESSIONNEL TEXT, HEURE TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME2);
        onCreate(db);
    }

    public Cursor getNomPro(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor result = db.rawQuery("select nom from " + TABLE_NAME,null);

        return result;
    }

    public Cursor getNomProSelectionne(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor result = db.rawQuery("select nom from " + TABLE_NAME + " where id = " + id,null);

        return result;
    }

    public Cursor getRdv(String date) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor result = db.rawQuery("select * from " + TABLE_NAME2 + " where date = "  + date, null);

        return result;
    }

    public Cursor getRecherche(String CP){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result = db.rawQuery("select nom from " + TABLE_NAME + " where adresse like %" + CP + "%", null);

        return result;
    }

    public void insertDataPro (String nom, String prenom, String type, String adresse, String mail, String tel){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_2, nom);
        contentValues.put(COL_3, prenom);
        contentValues.put(COL_4, type);
        contentValues.put(COL_5, adresse);
        contentValues.put(COL_6, mail);
        contentValues.put(COL_7, tel);
        db.insert(TABLE_NAME, null, contentValues);
        db.close();
    }

    public void insertDataRdv (Cursor pro, String date, String heure){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_8, date);
        contentValues.put(COL_9, heure);
        contentValues.put(COL_10, String.valueOf(pro));
        db.insert(TABLE_NAME2, null, contentValues);
        db.close();
    }
}
