package com.example.mtg_deck;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

public class News extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        TextView textnwes = findViewById(R.id.textView3);

// задаём текст
        textnwes.setText("ZENDIKAR RISING 2020\n" +
                "  \n" +
                "Дата релиза zendikar rising 2020\n " +
                "25 сентября 2020 года.\n" +
                "Zendikar Rising, который выйдет 25 сентября, станет третьим\n" +
                "визитом на самолет Zendikar,\n" +
                " после блока Zendikar с 2009-10\n" +
                " и блока Битва за Zendikar с 2015-16.Для Zendikar Rising Wizards of the Coast действительно хотели вернуть первоначальное ощущение «приключенческого самолета» оригинального блока Zendikar\n.");
        textnwes.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);

        ScrollView scrollView = new ScrollView(this);
        TextView textnews2 = new TextView(this);
        textnews2.setLayoutParams(new ViewGroup.LayoutParams
                (ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    }
}