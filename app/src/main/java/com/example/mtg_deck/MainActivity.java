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
import static android.R.layout.simple_list_item_1;

public class MainActivity extends AppCompatActivity {
    private SQLiteDatabase db;
    public static Cursor colorCursor;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listDrinks = (ListView) findViewById(R.id.list_color_deck);
        SQLiteOpenHelper deckDatabaseHelper = new DeckDatabaseHelper(this);
        try {
            db = deckDatabaseHelper.getReadableDatabase();
            colorCursor = db.query("COLORS",
                    new String[]{"_id", "COLOR"},
                    null, null, null, null, null);
            SimpleCursorAdapter listAdapter = new SimpleCursorAdapter(this,
                    android.R.layout.simple_list_item_1,
                    colorCursor,
                    new String[]{"COLOR"},
                    new int[]{android.R.id.text1},
                    0);
            listDrinks.setAdapter(listAdapter);
        } catch(SQLiteException e) {

        }
        //Создание слушателя
        AdapterView.OnItemClickListener itemClickListener =
                new AdapterView.OnItemClickListener(){
                    public void onItemClick(AdapterView<?> listDrinks,
                                            View itemView,
                                            int position,
                                            long id) {
                        //Напиток, выбранный пользователем, передается DrinkActivity
                        Intent intent = new Intent(MainActivity.this,
                                Decks.class);
                        intent.putExtra(Decks.EXTRA_DECKSID, (int) id);
                        startActivity(intent);
                    }

                };

        //Слушатель связывается со списковым представлением
        listDrinks.setOnItemClickListener(itemClickListener);

    }

    public static String getColor(){
         String color_name = colorCursor.getString(1);
         return color_name;
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        colorCursor.close();
        db.close();
    }

}


