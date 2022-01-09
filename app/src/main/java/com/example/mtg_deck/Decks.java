package com.example.mtg_deck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class Decks extends AppCompatActivity {
    public static final String EXTRA_DECKSID = "decksId";
    private SQLiteDatabase db;
    public static Cursor bludeckCursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deck__blue);
        ListView listDrinks = (ListView) findViewById(R.id.blue_deck_list);
        SQLiteOpenHelper deckDatabaseHelper = new DeckDatabaseHelper(this);
        String nameColor = MainActivity.getColor();
//        Toast toast1 = Toast.makeText(this, MainActivity.getColor(), Toast.LENGTH_SHORT);
//        toast1.show();
//        try {
//            db = deckDatabaseHelper.getReadableDatabase();
//            bludeckCursor = db.query("DECK_COLORS",
//                    new String[]{"_id", "TYPE", "COLOR"},
//                    "COLOR = ?", new String[]{nameColor}, null, null, null);
//            SimpleCursorAdapter listAdapter = new SimpleCursorAdapter(this,
//                    android.R.layout.simple_list_item_1,
//                    bludeckCursor,
//                    new String[]{"TYPE"},
//                    new int[]{android.R.id.text1},
//                    0);
//            listDrinks.setAdapter(listAdapter);
//        } catch(SQLiteException e) {
//            Toast toast = Toast.makeText(this, "Database unavailable1", Toast.LENGTH_SHORT);
//            toast.show();
//        }
//        //Создание слушателя
//        AdapterView.OnItemClickListener itemClickListener =
//                new AdapterView.OnItemClickListener(){
//                    public void onItemClick(AdapterView<?> listDrinks,
//                                            View itemView,
//                                            int position,
//                                            long id) {
//                        //Напиток, выбранный пользователем, передается DrinkActivity
//                        Intent intent = new Intent(Decks.this,
//                                Description_Deck_Blue.class);
//                        intent.putExtra(Description_Deck_Blue.EXTRA_DECKBLUEID, (int) id);
//                        startActivity(intent);
//                    }
//                };
//        //Слушатель связывается со списковым представлением
//        listDrinks.setOnItemClickListener(itemClickListener);
//        }
        try {
            db = deckDatabaseHelper.getReadableDatabase();
            bludeckCursor = db.query("DECK_COLORS",
                    new String[]{"_id", "TYPE", "COLOR", "COM", "TYPE||' '||COM"},
                    "COLOR = ?", new String[]{nameColor}, null, null, null);
            SimpleCursorAdapter listAdapter = new SimpleCursorAdapter(this,
                    android.R.layout.simple_list_item_1,
                    bludeckCursor,
                    new String[]{"TYPE||' '||COM"},
                    new int[]{android.R.id.text1},
                    0);
            listDrinks.setAdapter(listAdapter);
        } catch(SQLiteException e) {
            Toast toast = Toast.makeText(this, "Database unavailable1", Toast.LENGTH_SHORT);
            toast.show();
        }
        //Создание слушателя
//        AdapterView.OnItemClickListener itemClickListener =
//                new AdapterView.OnItemClickListener(){
//                    public void onItemClick(AdapterView<?> listDrinks,
//                                            View itemView,
//                                            int position,
//                                            long id) {
//                        //Напиток, выбранный пользователем, передается DrinkActivity
//                        Intent intent = new Intent(Decks.this,
//                                Description_Deck_Blue.class);
//                        intent.putExtra(Description_Deck_Blue.EXTRA_DECKBLUEID, (int) id);
//                        startActivity(intent);
//                    }
//                };
//        //Слушатель связывается со списковым представлением
//        listDrinks.setOnItemClickListener(itemClickListener);
    }
//    public static String getCeckBox(){
//        String cek = bludeckCursor.getString(4);
//        return cek;
//    }
//    public static String getType() {
//        String color_type = bludeckCursor.getString(1);
//        return color_type;
//    }
//    @Override
////    public void onDestroy(){
////        super.onDestroy();
////        bludeckCursor.close();
////        db.close();
////    }
//    @Override
//    public void onDestroy(){
//        super.onDestroy();
//        bludeckCursor.close();
//        db.close();
//    }

}