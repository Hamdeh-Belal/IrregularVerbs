package com.example.irregularverbs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class VerbsTestActivity extends AppCompatActivity {
    private TextView textViewWelcome, textViewResult, textViewTrueAnswer,verbTextView;
    private EditText editTextVerb, editTextPastParticiple;
    private Button buttonCheck;
    private ImageView imageResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verbs_test);

        textViewWelcome = findViewById(R.id.textViewWelcome);
        textViewResult = findViewById(R.id.textViewResult);
        textViewTrueAnswer = findViewById(R.id.textViewTrueAnswer);
        editTextVerb = findViewById(R.id.editTextVerb);
        editTextPastParticiple = findViewById(R.id.editTextPastParticiple);
        buttonCheck = findViewById(R.id.buttonCheck);
        imageResult = findViewById(R.id.imageResult);
        verbTextView = findViewById(R.id.verbTextView);

        AllVerbDataBase allVerb =new AllVerbDataBase();
        newVerb();

        buttonCheck.setOnClickListener(v->{

            if(!editTextVerb.getText().toString().equals("")&&!editTextPastParticiple.getText().toString().equals("")){
              String []verbs=  allVerb.getTwoVerb(verbTextView.getText().toString().trim());
              if(editTextVerb.getText().toString().equalsIgnoreCase(verbs[1].trim())&&editTextPastParticiple.getText().toString().equalsIgnoreCase(verbs[2].trim())){
                  imageResult.setImageResource(R.drawable.true_sign);
                  textViewTrueAnswer.setText("Verb: "+verbs[0]+" \t "+"Past Simple: "+verbs[1]+" \t "+"Past Participle: "+verbs[2]+"\n Next question in [8 seconds]");
              }
              else {
                  imageResult.setImageResource(R.drawable.false_sign);
                  textViewTrueAnswer.setText("Verb: "+verbs[0]+" \t "+"Past Simple: "+verbs[1]+" \t "+"Past Participle: "+verbs[2]+"\n Next question in [8 seconds]");
              }
              nextStep();
//              newVerb();
            }





        });

    }
    private void newVerb(){
        AllVerbDataBase allVerb =new AllVerbDataBase();
        Random random = new Random();
        String firstVerb="";
        int index = random.nextInt(allVerb.getSize());
        String [] line = allVerb.getThreeVerb(index);
        firstVerb=line[0];
        verbTextView.setText(firstVerb);
        editTextVerb.setText("");
        editTextPastParticiple.setText("");
        textViewTrueAnswer.setText("");
        imageResult.setImageResource(R.drawable.initalimage);
    }
    protected void nextStep(){
         Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                newVerb();
            }
                },8000);

    }
}