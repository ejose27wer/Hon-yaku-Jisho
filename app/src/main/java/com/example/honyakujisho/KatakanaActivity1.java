package com.example.honyakujisho;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class KatakanaActivity1 extends AppCompatActivity {

    ImageButton left;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_katakana1);
        getSupportActionBar().hide();

        left = (ImageButton) findViewById(R.id.left);
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Katakana = new Intent(KatakanaActivity1.this, KatakanaActivity.class);
                startActivity(Katakana);

                Toast.makeText(KatakanaActivity1.this, "Back", Toast.LENGTH_SHORT).show();
            }
        });
    }
}