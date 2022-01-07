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
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.lang.reflect.Array;

public class Description_Deck_Blue extends AppCompatActivity {
    public static final String EXTRA_DECKBLUEID = "deckblueId";
    private SQLiteDatabase db;
    public static Cursor cardCursor;
    String nameColor = MainActivity.getColor();
    String nameType = Decks.getType();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description__deck__blue);


        final ListView listCard = (ListView) findViewById(R.id.list_card);
        SQLiteOpenHelper deckDatabaseHelper = new DeckDatabaseHelper(this);
        try {
            db = deckDatabaseHelper.getReadableDatabase();
            cardCursor = db.query("CARDS",
                    new String[]{"_id", "TYPE", "COLOR","CARD", "RESURSID","SIGN"},
                    "COLOR = ? AND TYPE = ?", new String[]{nameColor,nameType}, null, null, null);
            SimpleCursorAdapter listAdapter = new SimpleCursorAdapter(this,
                    android.R.layout.simple_list_item_1,
                    cardCursor,
                    new String[]{"CARD"},
                    new int[]{android.R.id.text1},
                    0);
            listCard.setAdapter(listAdapter);
        } catch(SQLiteException e) {
            Toast toast = Toast.makeText(this, "Database unavailable1", Toast.LENGTH_SHORT);
            toast.show();
        }

        //Создание слушателя
        final AdapterView.OnItemClickListener itemClickListener =
                new AdapterView.OnItemClickListener(){
                    public void onItemClick(AdapterView<?> listDrinks,
                                            View itemView,
                                            int position,
                                            long id) {
                        if (cardCursor.getInt(5) == 0) {
                            Intent intent = new Intent(Description_Deck_Blue.this,
                                    Photo.class);
                            intent.putExtra(Photo.EXTRA_PHOTOID, (int) id);
                            startActivity(intent);
                        }

                    }
                };
        //Слушатель связывается со списковым представлением
        listCard.setOnItemClickListener(itemClickListener);
    }
    public static int getPoto(){
        int resurcePoto = cardCursor.getInt(4);
        return resurcePoto;
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        cardCursor.close();
        db.close();
    }
}




