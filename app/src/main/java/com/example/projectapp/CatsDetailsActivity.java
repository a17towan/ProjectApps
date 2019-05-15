package com.example.projectapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class CatsDetailsActivity {
    public class CatsDetailActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_catsdetails);

            TextView test = (TextView) findViewById(R.id.test);
            Intent intent = getIntent();
            String race = intent.getStringExtra("RACE");
            test.setText("The race is: " + race);

            TextView test2 = (TextView) findViewById(R.id.test2);
            String color = intent.getStringExtra("COLOR");
            test2.setText("The color is: " + color);

            TextView test3 = (TextView) findViewById(R.id.test3);
            String size = intent.getStringExtra("SIZE");
            test3.setText("The size number is is: " + size);
        }
    }
}
