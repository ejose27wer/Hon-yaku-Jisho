package com.example.honyakujisho;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class HiraganaActivity1 extends AppCompatActivity {

    ImageButton left1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hiragana1);
        getSupportActionBar().hide();

        left1 = (ImageButton) findViewById(R.id.left1);
        left1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Katakana = new Intent(HiraganaActivity1.this, HiraganaActivity.class);
                startActivity(Katakana);

                Toast.makeText(HiraganaActivity1.this, "Back", Toast.LENGTH_SHORT).show();
            }
        });
    }
}