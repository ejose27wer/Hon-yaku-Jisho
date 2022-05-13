package com.example.honyakujisho;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ChartActivity extends AppCompatActivity {

    TextView katakana,hiragana;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);
        getSupportActionBar().hide();


        katakana = (TextView) findViewById(R.id.btn_katakana);
        katakana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Katakana = new Intent(ChartActivity.this, KatakanaActivity.class);
                startActivity(Katakana);

                Toast.makeText(ChartActivity.this, "Katakana", Toast.LENGTH_SHORT).show();
            }
        });

        hiragana = (TextView) findViewById(R.id.btn_hiragana);
        hiragana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Hiragana = new Intent(ChartActivity.this, HiraganaActivity.class);
                startActivity(Hiragana);

                Toast.makeText(ChartActivity.this, "Hiragana", Toast.LENGTH_SHORT).show();
            }
        });
    }
}