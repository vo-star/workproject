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
        insertEnters1(db, "Типы");
        insertEnters1(db, "MONO-RED");
        insertEnters1(db, "MONO-BLACK");
        insertEnters1(db, "MONO-GREEN");
        insertEnters1(db, "MONO-WHITE");
        Log.i("MyLog", "After insert1");
        db.execSQL("CREATE TABLE DECK_COLORS (_id INTEGER PRIMARY KEY AUTOINCREMENT, TYPE TEXT, COLOR TEXT, COM TEXT); " );
        Log.i("MyLog", "After create table2");
        insertEnters2(db, "", "MONO-BLUE", "Примитивные типы Java не являются объектами. К ним относятся:"

        +" boolean - булев тип, может иметь значения true или false"
       + " byte - 8-разрядное целое число"
        +" short - 16-разрядное целое число"
        +" int - 32-разрядное целое число"
        +" long - 64-разрядное целое число"
        +" char - 16-разрядное беззнаковое целое, представляющее собой символ UTF-16 (буквы и цифры)"
        +"float - 32-разрядное число в формате IEEE 754 с плавающей точкой"
        +" double - 64-разрядное число в формате IEEE 754 с плавающей точкой"
        +" Примитивный в данном случае не оскорбление, а просто даёт понять, что речь идёт о простом типе, который не умеет прыгать, спать или мяукать. Да что он вообще умеет? Ой, всё."
         +       " Java определяет четыре целочисленных типа: byte, short, int, long. Они могут быть положительными и отрицательными (Java не поддерживает только положительные значения без знака, как некоторые языки программирования)."
          +      " Тип byte "
        +" Наименьший по размеру целочисленный тип - byte. Это 8-битовый тип с диапазоном допустимых значений от -128 до 127. Переменные типа byte часто используются при работе с потоком данных из сети или файла, а также при работе с необработанными двоичными данными или в массивах для экономии памяти. "

         +       " Объявить переменную типа byte можно следующим образом: "


        +" byte c, a, t; // объявили сразу три переменные "
        +" В арифметических выражениях с переменными типа byte вычисления выполняются как с типом int, т.е. с помощью 32-битовой арифметики, а полученный результат будет 32-битовым. Смотри пример с short."

         +       " Строку с числом перевести в данный тип можно через метод parseByte(String): "
        +" byte x = Byte.parseByte('100'); "
        +" Класс Byte является оболочкой для данного типа. Без необходимости не используйте в Android класс Byte. "

        +" Слово «байт» (byte) возникло в компании IBM примерно в 1956 году. Оно произошло от слова bite («кусок»), но его было решено писать через букву y, чтобы не путать со словом «bit» («бит»). В течение некоторого времени слово «байт» обозначало просто число битов в конкретном потоке данных. Однако в середине 1960-х, в связи с разработкой семейства компьютеров System/360 в компании IBM, это слово стало обозначать группу из восьми бит. "

                +" Любопытно, что bite имеет также значение 'укус' (сущ.) или 'укусить' (глагол). Таким образом это наш родной 'Кусь!'");
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

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}
