package com.example.irregularverbs;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class AllVerbsActivity extends AppCompatActivity {

    private EditText editTextSearch;
    private Button buttonSearch;
    private ImageView imageResult;
    private ListView listViewIrregularVerbs;
    private ArrayAdapter<String> adapter;
    private String[] irregularVerbs;
    private TextView resultTextView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_verbs);
        editTextSearch = findViewById(R.id.editTextSearch);
        buttonSearch = findViewById(R.id.buttonSearch);
        imageResult = findViewById(R.id.imageResult);
        listViewIrregularVerbs = findViewById(R.id.listViewIrregularVerbs);
        resultTextView=findViewById(R.id.resultTextView);

        AllVerbDataBase allVerb = new AllVerbDataBase();
        irregularVerbs = allVerb.getEditData();

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, irregularVerbs);
        listViewIrregularVerbs.setAdapter(adapter);

        buttonSearch.setOnClickListener(v -> {
            String searchQuery = editTextSearch.getText().toString().trim();
            String line=allVerb.getLineSpace(editTextSearch.getText().toString().trim());
                if(line!=null){

                    resultTextView.setText(line);
                    imageResult.setImageResource(R.drawable.true_sign);
                    imageResult.setVisibility(View.VISIBLE);
                }
                else {
                    resultTextView.setText("");
                    imageResult.setImageResource(R.drawable.false_sign);
                    imageResult.setVisibility(View.VISIBLE);
                }

            imageResult.setVisibility(View.VISIBLE);
        });
        listViewIrregularVerbs.setOnItemClickListener((parent, view, position, id) -> {
            // Get the selected item from the ListView
            String selectedItem = (String) parent.getItemAtPosition(position);
            editTextSearch.setText("");
            imageResult.setImageResource(R.drawable.initalimage);
            resultTextView.setText(selectedItem);

        });
    }
}