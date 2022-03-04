package com.example.mtg_deck;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class Themes extends AppCompatActivity {
    public static final String EXTRA_DECKSID = "decksId";
    private SQLiteDatabase db;
    public static Cursor ThemeCursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deck__blue);
        ListView Themelist = (ListView) findViewById(R.id.theme_list);
        SQLiteOpenHelper themeDatabaseHelper = new ThemeDatabaseHelper(this);
        String nameText = MainActivity.getText();
        try {
            db = themeDatabaseHelper.getReadableDatabase();
            ThemeCursor = db.query("TEXT_THEME",
                    new String[]{"_id", "TAB", "THEME", "TEXT", "THEME||' '||TEXT"},
                    "THEME = ?", new String[]{nameText}, null, null, null);
            SimpleCursorAdapter listAdapter = new SimpleCursorAdapter(this,
                    android.R.layout.simple_list_item_1,
                    ThemeCursor,
                    new String[]{"THEME||' '||TEXT"},
                    new int[]{android.R.id.text1},
                    0);
            Themelist.setAdapter(listAdapter);
        } catch (SQLiteException e) {
            Toast toast = Toast.makeText(this, "Database unavailable1", Toast.LENGTH_SHORT);
            toast.show();
        }


    }
}