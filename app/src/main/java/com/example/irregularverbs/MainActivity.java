package com.example.irregularverbs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button verbTestBt;
    private Button sentencesTestBt;
    private Button allVerbBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getViews();
    }

    private void getViews() {
        verbTestBt = findViewById(R.id.verbTestBt);
        sentencesTestBt = findViewById(R.id.sentencesTestBt);
        allVerbBt= findViewById(R.id.allVerbBt);

        verbTestBt.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, VerbsTestActivity.class);
            startActivity(intent);

        });
        sentencesTestBt.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SentenceTestActivity.class);
            startActivity(intent);

        });
        allVerbBt.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AllVerbsActivity.class);
            startActivity(intent);

        });

        }
}