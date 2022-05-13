package com.example.honyakujisho;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class AnswerActivity extends AppCompatActivity {

    TextView EngWord,JapWord,Word,Definition,Antonyms,Verb,Example,Example1,Example2,Example3,Example4,Adverb,Noun,Adjective,Preposition;
    ImageView speaker,speaker1;
    AutoCompleteTextView autoCompleteTextView;
    TextToSpeech Speech0, Speech1;
    String engWord,word,japWord,antonym,definition,example,example1,example2,example3,example4,verb,adverb,noun,adjective,preposition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);
        getSupportActionBar().hide();

        autoCompleteTextView = findViewById(R.id.Search_bar);
        Definition = findViewById(R.id.txtDefinition);

        Antonyms = findViewById(R.id.txtAntonyms);
        Verb = findViewById(R.id.txtVerb);
        Adverb = findViewById(R.id.txtAdverb);
        Noun = findViewById(R.id.txtNoun);
        Adjective = findViewById(R.id.txtAdjective);
        Preposition = findViewById(R.id.txtPreposition);
        Word = findViewById(R.id.txtWord);
        EngWord = findViewById(R.id.txtEngWord);
        JapWord = findViewById(R.id.txtJapWord);
        Example = findViewById(R.id.txtExample);
        Example1 = findViewById(R.id.txtExample1);
        Example2 = findViewById(R.id.txtExample2);
        Example3 = findViewById(R.id.txtExample3);
        Example4 = findViewById(R.id.txtExample4);

        speaker = findViewById(R.id.speaker);
        speaker1 = findViewById(R.id.speaker1);

        word = getIntent().getStringExtra("jap_word");
        engWord = getIntent().getStringExtra("eng_jap");
        japWord = getIntent().getStringExtra("jap_words");
        antonym = getIntent().getStringExtra("antonym");
        definition = getIntent().getStringExtra("definition");
        example = getIntent().getStringExtra("example");
        example1 = getIntent().getStringExtra("example1");
        example2 = getIntent().getStringExtra("example2");
        example3 = getIntent().getStringExtra("example3");
        example4 = getIntent().getStringExtra("example4");
        noun = getIntent().getStringExtra("noun");
        verb = getIntent().getStringExtra("verb");
        adverb = getIntent().getStringExtra("adverb");
        adjective = getIntent().getStringExtra("adjective");
        preposition = getIntent().getStringExtra("preposition");

        Speech0 = new TextToSpeech(getApplicationContext(),
                new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int i) {
                        if (i == TextToSpeech.SUCCESS){
                            int lang = Speech0.setLanguage(Locale.ENGLISH);
                        }
                    }
                });
        speaker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = EngWord.getText().toString();
                int speech0 = Speech0.speak(s,TextToSpeech.QUEUE_FLUSH,null);
            }
        });

        Speech1 = new TextToSpeech(getApplicationContext(),
                new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int a) {
                        if (a == TextToSpeech.SUCCESS){
                            int lang = Speech1.setLanguage(Locale.JAPANESE);
                        }
                    }
                });
        speaker1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String see = JapWord.getText().toString();
                int speech1 = Speech1.speak(see,TextToSpeech.QUEUE_FLUSH,null);
            }
        });

        setData();
    }

    public void setData(){
        if (!japWord.isEmpty()){
            Word.setText(word);
            EngWord.setText(engWord);
            JapWord.setText(japWord);
            Antonyms.setText(antonym);
            Definition.setText(definition);
            Example.setText(example);
            Example1.setText(example1);
            Example2.setText(example2);
            Example3.setText(example3);
            Example4.setText(example4);
            Noun.setText(noun);
            Verb.setText(verb);
            Adjective.setText(adjective);
            Adverb.setText(adverb);
            Preposition.setText(preposition);
        }
    }

    public void btn_back(View view) {
        finish();
    }

    public void getSpeech(View view) {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,"Start Speaking");
        intent.putExtra(RecognizerIntent.EXTRA_RESULTS, Locale.getDefault());
        startActivityForResult(intent,10);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 10 && resultCode == RESULT_OK){
            autoCompleteTextView.setText(data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS).get(0));
        }
    }
}