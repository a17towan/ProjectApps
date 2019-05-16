package com.example.projectapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Size;
import android.widget.TextView;

    public class CatsDetailsActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_catsdetails);

            TextView test = (TextView) findViewById(R.id.test);
            Intent intent = getIntent();
            String race = intent.getStringExtra("Race");
            test.setText("Race: " + race);

            TextView test2 = (TextView) findViewById(R.id.test2);
            String color = intent.getStringExtra("Color");
            test2.setText("Color: " + color);

            TextView test3 = (TextView) findViewById(R.id.test3);
            String size = intent.getStringExtra("Size");
            test3.setText("Size: " + size);
        }
    }

