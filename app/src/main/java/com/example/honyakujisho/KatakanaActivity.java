package com.example.honyakujisho;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class KatakanaActivity extends AppCompatActivity {

    ImageButton right;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_katakana);
        getSupportActionBar().hide();

        right = (ImageButton) findViewById(R.id.right);
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Katakana = new Intent(KatakanaActivity.this, KatakanaActivity1.class);
                startActivity(Katakana);

                Toast.makeText(KatakanaActivity.this, "Next", Toast.LENGTH_SHORT).show();
            }
        });
    }
}