package com.task001.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.task001.Fragment.CategoryFragment;
import com.task001.R;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CategoryFragment categoryFragment = new CategoryFragment();
        //If you wnat to test Arabic support remove comment from this line
        //Utilities.setPreference(this, Constants.SELECTED_LANGUAGE,Constants.ARABIC);
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_fragment,categoryFragment).addToBackStack("").commit();
    }
}


