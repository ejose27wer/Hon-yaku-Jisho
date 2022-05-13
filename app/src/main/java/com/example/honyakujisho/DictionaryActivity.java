package com.example.honyakujisho;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class DictionaryActivity extends AppCompatActivity {

    ViewPager viewPager;

    public static DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);
        getSupportActionBar().hide();

        viewPager = findViewById(R.id.View_pager);
        viewPager.setAdapter(new SectionPagerAdapter(getSupportFragmentManager()));

        dbHelper = new DbHelper(this,"dictionary.db",1);
        try {
            dbHelper.CheckDb();
            dbHelper.OpenDatabase();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    class SectionPagerAdapter extends FragmentPagerAdapter{

        public SectionPagerAdapter(@NonNull FragmentManager fragmentManager){
            super(fragmentManager);
        }

        @NonNull
        @Override
        public Fragment getItem(int position){
            switch (position){
                case 0:
                default:
                    return new DictionaryFragment();
            }
        }

        @Override
        public int getCount(){
            return 1;
        }
    }
}