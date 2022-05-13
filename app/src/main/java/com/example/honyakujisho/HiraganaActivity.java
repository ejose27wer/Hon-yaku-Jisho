package com.example.honyakujisho;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class HiraganaActivity extends AppCompatActivity {

    ImageButton right1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hiragana);
        getSupportActionBar().hide();

        right1 = (ImageButton) findViewById(R.id.right1);
        right1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Katakana = new Intent(HiraganaActivity.this, HiraganaActivity1.class);
                startActivity(Katakana);

                Toast.makeText(HiraganaActivity.this, "Next", Toast.LENGTH_SHORT).show();
            }
        });
    }
}