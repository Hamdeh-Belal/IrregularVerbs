package com.example.irregularverbs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class SentenceTestActivity extends AppCompatActivity {
    private TextView firstPartTV;
    private TextView secondPartTV;
    private EditText solutionET;
    private Button checkBt;
    private ImageView result_img;
    private Sentence sentence;
    private TextView trueValueTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sentence_test);
        getViews();
        setData();
        checkBt.setOnClickListener(v -> {
            if (!solutionET.getText().toString().equals("")) {
                if (solutionET.getText().toString().trim().equalsIgnoreCase(sentence.getSolution())) {
                    result_img.setImageResource(R.drawable.true_sign);
                } else {
                    result_img.setImageResource(R.drawable.false_sign);
                }
                trueValueTV.setText(sentence.getFirstPart() + " " + sentence.getSolution() + " " + sentence.getSecondPart() + "\n Next question in [8 seconds] ");
                nextStep();

            }
        });
    }

    private void getViews() {
        firstPartTV = findViewById(R.id.firstPartTV);
        secondPartTV = findViewById(R.id.secondPartTV);
        solutionET = findViewById(R.id.solutionET);
        checkBt = findViewById(R.id.checkBt);
        result_img = findViewById(R.id.result_img);
        trueValueTV = findViewById(R.id.trueValueTV);
    }

    private void setData() {
        Random random = new Random();
        SentenceDataBase dataBase = new SentenceDataBase();
        sentence = dataBase.getExample(random.nextInt(dataBase.getSize()));
        firstPartTV.setText(sentence.getFirstPart());
        secondPartTV.setText(sentence.getSecondPart() + "(" + sentence.getWord() + ")");
        result_img.setImageResource(R.drawable.initalimage);
        solutionET.setText("");
        trueValueTV.setText("");
    }

    protected void nextStep() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                setData();
            }
        }, 8000);

    }
}