package com.example.aditi.bakingapp.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.example.aditi.bakingapp.Fragments.FragmentDetailActivity;
import com.example.aditi.bakingapp.Fragments.FragmentStepsDetailActivity;
import com.example.aditi.bakingapp.MainActivity;
import com.example.aditi.bakingapp.R;

/**
 * Created by aditi on 25/2/18.
 */

public class StepsDetailActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        if (savedInstanceState == null) {

            FragmentManager fragmentManager = getSupportFragmentManager();
            if (MainActivity.isTablet) {
                FragmentDetailActivity fragmentDetailActivity = new FragmentDetailActivity();
                fragmentManager.beginTransaction()
                        .add(R.id.steps_details_frame, fragmentDetailActivity)
                        .commit();

                FragmentStepsDetailActivity fragmentStepsDetailActivity = new FragmentStepsDetailActivity();
                fragmentManager.beginTransaction()
                        .replace(R.id.detail_activity_layout, fragmentStepsDetailActivity)
                        .commit();
            } else {


                FragmentStepsDetailActivity fragmentStepsDetailActivity = new FragmentStepsDetailActivity();
                fragmentManager.beginTransaction()
                        .add(R.id.detail_activity_layout, fragmentStepsDetailActivity)
                        .commit();

            }


        }
    }
}




