package com.example.lenovo.myapplication;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null) {

            if (findViewById(R.id.detail_container) != null) {
                getSupportFragmentManager().beginTransaction().add(R.id.item_container, new ItemFragment()).commit();
            }

          else {  getSupportFragmentManager().beginTransaction().add(R.id.item_container, new ItemFragment()).commit();}

        }

    }
}
