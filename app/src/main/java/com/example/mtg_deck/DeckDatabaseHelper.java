package com.example.mtg_deck;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class DeckDatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "deck"; // the name of our database
    private static final int DB_VERSION = 2; // the version of the database

    DeckDatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }
    private static void insertEnters1(SQLiteDatabase db, String color){
        ContentValues colorsEnters = new ContentValues();
        colorsEnters.put("COLOR", color);
        db.insert("COLORS", null, colorsEnters);
    }
    private static void insertEnters2(SQLiteDatabase db, String type, String color, String com) {
        ContentValues blueEnters = new ContentValues();
        blueEnters.put("TYPE", type);
        blueEnters.put("COLOR", color);
        blueEnters.put("COM", com);
        db.insert("DECK_COLORS", null, blueEnters);
    }
    private static void insertEnters3(SQLiteDatabase db,String color,  String type, String card, int resursID, int sign) {
        ContentValues cardEnters = new ContentValues();

        cardEnters.put("COLOR", color);
        cardEnters.put("TYPE", type);
        cardEnters.put("CARD", card);
        cardEnters.put("RESURSID", resursID);
        cardEnters.put("SIGN", sign);

        db.insert("CARDS", null, cardEnters);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE COLORS (_id INTEGER PRIMARY KEY AUTOINCREMENT, COLOR TEXT); " );
        Log.i("MyLog", "After create table1");
        insertEnters1(db, "MONO-BLUE");
        insertEnters1(db, "MONO-RED");
        insertEnters1(db, "MONO-BLACK");
        insertEnters1(db, "MONO-GREEN");
        insertEnters1(db, "MONO-WHITE");
        Log.i("MyLog", "After insert1");
        db.execSQL("CREATE TABLE DECK_COLORS (_id INTEGER PRIMARY KEY AUTOINCREMENT, TYPE TEXT, COLOR TEXT, COM TEXT); " );
        Log.i("MyLog", "After create table2");
        insertEnters2(db, "MILS", "MONO-BLUE", "Собирается");
        insertEnters2(db, "FLASH","MONO-BLUE","");
        insertEnters2(db, "AGGRO", "MONO-RED","");
        insertEnters2(db, "CAVALCADE","MONO-RED","");
        insertEnters2(db, "VAMPIRES", "MONO-BLACK","");
        insertEnters2(db, "DISCARD","MONO-BLACK","");
        insertEnters2(db, "NISSA", "MONO-GREEN","");
        insertEnters2(db, "FOOD","MONO-GREEN","");
        insertEnters2(db, "LIFE", "MONO-WHITE","");
        insertEnters2(db, "WEENIE","MONO-WHITE","");
        Log.i("MyLog", "After insert2");
        db.execSQL("CREATE TABLE CARDS (_id INTEGER PRIMARY KEY AUTOINCREMENT,COLOR TEXT ,TYPE TEXT , CARD TEXT, RESURSID INTEGER, SIGN INTEGER); " );
        insertEnters3(db, "MONO-BLUE","MILS" , "4 Мерфолк, Хранительница Тайн", R.drawable.merfolk, 0);
        insertEnters3(db, "MONO-BLUE", "MILS", "4 Ошеломленная Ученица", R.drawable.lener, 0);
        insertEnters3(db, "MONO-BLUE", "MILS", "4 Горгулья Вантресса", R.drawable.gorg,0);
        insertEnters3(db, "MONO-BLUE", "MILS", "4 Стена Потерянных Мыслей", R.drawable.faol,0);
        insertEnters3(db, "MONO-BLUE", "MILS", "3 Холодный Отказ", R.drawable.coald,0);
        insertEnters3(db, "MONO-BLUE", "MILS", "4 Скажи Волшебное Слово", R.drawable.woard,0);
        insertEnters3(db, "MONO-BLUE", "MILS", "4 Распад Мыслей", R.drawable.one,0);
        insertEnters3(db, "MONO-BLUE", "MILS", "3 Попасть в Историю", R.drawable.two,0);
        insertEnters3(db, "MONO-BLUE", "MILS", "4 Ведьмин Колодец", R.drawable.three,0);
        insertEnters3(db, "MONO-BLUE", "MILS", "4 Затонувшие Тайны",  R.drawable.five,0);
        insertEnters3(db, "MONO-BLUE", "MILS", "1 Замок Вантресс",  R.drawable.six,0);
        insertEnters3(db, "MONO-BLUE", "MILS", "17 Остров",  R.drawable.seven,0);
        insertEnters3(db, "MONO-BLUE", "MILS", "4 Мистическое Святилище",  R.drawable.thore,0);
        insertEnters3(db, "MONO-BLUE", "MILS", "",  0 ,1);
        insertEnters3(db, "MONO-BLUE", "MILS", "Доп. колода:",  0 ,1);
        insertEnters3(db, "MONO-BLUE", "MILS", "3 Такой Крохотный",  R.drawable.sid1 ,0);
    }
    
}
