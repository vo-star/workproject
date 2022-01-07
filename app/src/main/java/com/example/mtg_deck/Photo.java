package com.example.mtg_deck;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class Photo extends AppCompatActivity {
    public static final String EXTRA_PHOTOID = "photoId";
    int Poto = Description_Deck_Blue.getPoto();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
        ImageView photo = (ImageView)findViewById(R.id.photo);
        photo.setImageResource(Poto);
    }
}