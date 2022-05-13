package com.example.honyakujisho;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private long backPressedTime;
    private Toast backToast;
    private TextView dictionary,translator,chart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        dictionary = (TextView) findViewById(R.id.btn_dictionary);
        dictionary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Dictionary = new Intent(MainActivity.this, DictionaryActivity.class);
                startActivity(Dictionary);

                Toast.makeText(MainActivity.this, "Dictionary", Toast.LENGTH_SHORT).show();
            }
        });

        translator = (TextView) findViewById(R.id.btn_translator);
        translator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Translator = new Intent(MainActivity.this, TranslatorActivity.class);
                startActivity(Translator);

                Toast.makeText(MainActivity.this, "Translator", Toast.LENGTH_SHORT).show();
            }
        });

        chart = (TextView) findViewById(R.id.btn_chart);
        chart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Chart = new Intent(MainActivity.this, ChartActivity.class);
                startActivity(Chart);

                Toast.makeText(MainActivity.this, "Chart", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()){
            backToast.cancel();
            super.onBackPressed();
            return;
        }else {
            backToast = Toast.makeText(getBaseContext(),"Tap again to exit", Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime = System.currentTimeMillis();
    }
}