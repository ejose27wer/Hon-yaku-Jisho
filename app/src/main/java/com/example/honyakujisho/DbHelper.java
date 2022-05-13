package com.example.honyakujisho;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;


public class DbHelper extends SQLiteOpenHelper {

    Context context;
    String dbname, dbpath;

    public DbHelper(@Nullable Context context,@Nullable String name, int version) {
        super(context, name,null, version);
        this.context = context;
        this.dbname = name;
        dbpath = "/data/data/" + "com.example.honyakujisho" + "/databases/";
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void CheckDb(){

        SQLiteDatabase checkDb = null;
        try {
            checkDb = SQLiteDatabase.openDatabase(dbpath + dbname,null,0);
        }catch (Exception e){
            e.printStackTrace();
        }

        if (checkDb != null){
            Log.d("qwerty","database already exists");
            Log.d("qwerty","Opening database");
            OpenDatabase();
        }else {
            Log.d("qwerty","Copying database");
            CopyDatabase();
        }
    }

    public void CopyDatabase(){

        this.getReadableDatabase();
        try {
            InputStream is = context.getAssets().open("dictionary.db");
            OutputStream os = new FileOutputStream(dbpath + dbname);

            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) > 0){
                os.write(buffer,0,len);
            }
            os.close();
            os.flush();
            is.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        Log.d("qwerty","Database copied");
    }

    public void OpenDatabase(){
        SQLiteDatabase sqLiteDatabase = SQLiteDatabase.openDatabase(dbpath + dbname,null,0);
    }

    public ArrayList<String> getEngWord(String engQuery){

        ArrayList<String> engWord = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String columnName = "eng_jap";

        try {
            Cursor cursor = sqLiteDatabase.query(
                    "English",
                    new String[]{columnName},
                    columnName + " LIKE ?",
                    new String[]{engQuery + "%"},
                    null,null,columnName
            );

            int index = cursor.getColumnIndex(columnName);

            while (cursor.moveToNext()){
                engWord.add(cursor.getString(index));
            }
            sqLiteDatabase.close();
            cursor.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return engWord;
    }

    @SuppressLint("Range")
    public String getJapWord(String japQuery){

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(" SELECT * FROM English WHERE eng_jap = '"+japQuery+"'",null);

        String jap = "";
        while (cursor.moveToNext()){
            jap = cursor.getString(cursor.getColumnIndex("jap_word"));
        }
        return jap;
    }

    @SuppressLint("Range")
    public String getWord(String wordQuery){

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(" SELECT * FROM English WHERE eng_jap = '"+wordQuery+"'",null);

        String jap = "";
        while (cursor.moveToNext()){
            jap = cursor.getString(cursor.getColumnIndex("jap_words"));
        }
        return jap;
    }

    @SuppressLint("Range")
    public String getAntonyms(String antonymQuery){

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM English WHERE eng_jap = '"+antonymQuery+"'",null);

        String antonyms = "";
        while (cursor.moveToNext()){
            antonyms = cursor.getString(cursor.getColumnIndex("antonym"));
        }
        return antonyms;
    }

    @SuppressLint("Range")
    public String getDefinition(String definitionQuery){

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM English WHERE eng_jap = '"+definitionQuery+"'",null);

        String definition = "";
        while (cursor.moveToNext()){
            definition = cursor.getString(cursor.getColumnIndex("definition"));
        }
        return definition;
    }

    @SuppressLint("Range")
    public String getExample(String exampleQuery){

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM English WHERE eng_jap = '"+exampleQuery+"'",null);

        String example = "";
        while (cursor.moveToNext()){
            example = cursor.getString(cursor.getColumnIndex("example"));
        }
        return example;
    }

    @SuppressLint("Range")
    public String getExample1(String example1Query){

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM English WHERE eng_jap = '"+example1Query+"'",null);

        String example = "";
        while (cursor.moveToNext()){
            example = cursor.getString(cursor.getColumnIndex("example1"));
        }
        return example;
    }

    @SuppressLint("Range")
    public String getExample2(String example2Query){

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM English WHERE eng_jap = '"+example2Query+"'",null);

        String example = "";
        while (cursor.moveToNext()){
            example = cursor.getString(cursor.getColumnIndex("example2"));
        }
        return example;
    }

    @SuppressLint("Range")
    public String getExample3(String example3Query){

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM English WHERE eng_jap = '"+example3Query+"'",null);

        String example = "";
        while (cursor.moveToNext()){
            example = cursor.getString(cursor.getColumnIndex("example3"));
        }
        return example;
    }

    @SuppressLint("Range")
    public String getExample4(String example4Query){

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM English WHERE eng_jap = '"+example4Query+"'",null);

        String example = "";
        while (cursor.moveToNext()){
            example = cursor.getString(cursor.getColumnIndex("example4"));
        }
        return example;
    }

    @SuppressLint("Range")
    public String getNoun(String nounQuery){

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM English WHERE eng_jap = '"+nounQuery+"'",null);

        String noun = "";
        while (cursor.moveToNext()){
            noun = cursor.getString(cursor.getColumnIndex("noun"));
        }
        return noun;
    }

    @SuppressLint("Range")
    public String getVerb(String verbQuery){

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM English WHERE eng_jap = '"+verbQuery+"'",null);

        String verb = "";
        while (cursor.moveToNext()){
            verb = cursor.getString(cursor.getColumnIndex("verb"));
        }
        return verb;
    }

    @SuppressLint("Range")
    public String getAdjective(String adjectiveQuery){

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM English WHERE eng_jap = '"+adjectiveQuery+"'",null);

        String adjective = "";
        while (cursor.moveToNext()){
            adjective = cursor.getString(cursor.getColumnIndex("adjective"));
        }
        return adjective;
    }

    @SuppressLint("Range")
    public String getAdverb(String adverbQuery){

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM English WHERE eng_jap = '"+adverbQuery+"'",null);

        String adverb = "";
        while (cursor.moveToNext()){
            adverb = cursor.getString(cursor.getColumnIndex("adverb"));
        }
        return adverb;
    }

    @SuppressLint("Range")
    public String getPreposition(String prepositionQuery){

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM English WHERE eng_jap = '"+prepositionQuery+"'",null);

        String preposition = "";
        while (cursor.moveToNext()){
            preposition = cursor.getString(cursor.getColumnIndex("preposition"));
        }
        return preposition;
    }
}
