package com.example.honyakujisho;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DictionaryFragment extends Fragment {

    Context context;
    AutoCompleteTextView autoCompleteTextView;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dictionary,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        autoCompleteTextView = view.findViewById(R.id.Search_bar);
        autoCompleteTextView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (charSequence.length() == 1){
                    autoCompleteTextView.setAdapter(new ArrayAdapter<String>(
                            context, android.R.layout.simple_list_item_1,
                            DictionaryActivity.dbHelper.getEngWord(charSequence.toString())));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String engWord = (String) adapterView.getItemAtPosition(i);
                String getWord = DictionaryActivity.dbHelper.getWord(engWord);
                String getJap = DictionaryActivity.dbHelper.getJapWord(engWord);
                String getAntonym = DictionaryActivity.dbHelper.getAntonyms(engWord);
                String getDefinition = DictionaryActivity.dbHelper.getDefinition(engWord);
                String getExample = DictionaryActivity.dbHelper.getExample(engWord);
                String getExample1 = DictionaryActivity.dbHelper.getExample1(engWord);
                String getExample2 = DictionaryActivity.dbHelper.getExample2(engWord);
                String getExample3 = DictionaryActivity.dbHelper.getExample3(engWord);
                String getExample4 = DictionaryActivity.dbHelper.getExample4(engWord);
                String getNoun = DictionaryActivity.dbHelper.getNoun(engWord);
                String getVerb = DictionaryActivity.dbHelper.getVerb(engWord);
                String getAdjective = DictionaryActivity.dbHelper.getAdjective(engWord);
                String getAdverb = DictionaryActivity.dbHelper.getAdverb(engWord);
                String getPreposition = DictionaryActivity.dbHelper.getPreposition(engWord);

                Intent intent = new Intent(context, AnswerActivity.class);
                intent.putExtra("jap_words",getWord);
                intent.putExtra("eng_jap",engWord);
                intent.putExtra("jap_word",getJap);
                intent.putExtra("antonym",getAntonym);
                intent.putExtra("definition",getDefinition);
                intent.putExtra("example",getExample);
                intent.putExtra("example1",getExample1);
                intent.putExtra("example2",getExample2);
                intent.putExtra("example3",getExample3);
                intent.putExtra("example4",getExample4);
                intent.putExtra("noun",getNoun);
                intent.putExtra("verb",getVerb);
                intent.putExtra("adjective",getAdjective);
                intent.putExtra("adverb",getAdverb);
                intent.putExtra("preposition",getPreposition);
                startActivity(intent);
                Toast.makeText(context,engWord,Toast.LENGTH_SHORT).show();
            }
        });
    }
}