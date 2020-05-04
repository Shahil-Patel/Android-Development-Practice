package com.example.a10014725.posttestpractice;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    EditText editText;
    TextView editTextViet;
    Button button;
    TextView spinnerView;
    ArrayList<String> names;
    RadioGroup radioGroup;
    static final int numbercode=12;
    static final String intentcode="hello";
    ImageView imageView;
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textViet);
        editText=findViewById(R.id.editText);
        radioGroup=findViewById(R.id.radioGroup);
        imageView=findViewById(R.id.imageView);
        spinner=findViewById(R.id.spinner);
        editTextViet=findViewById(R.id.editTextViet);
        spinnerView=findViewById(R.id.spinnerView);
        textView.setText("asdasd");
        imageView.setImageResource(R.drawable.apple);
        button=findViewById(R.id.button);
        names=new ArrayList<>();
        names.add("A");
        names.add("E");
        names.add("I");
        names.add("O");
        names.add("U");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentToLoad=new Intent(MainActivity.this,SecondActivity.class);
                intentToLoad.putExtra("Test","This is a test");
                startActivityForResult(intentToLoad,numbercode);
            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.radioButton){
                    Toast.makeText(MainActivity.this, "Option 1", Toast.LENGTH_SHORT).show();
                }
                else if(checkedId==R.id.radioButton2){
                    Toast.makeText(MainActivity.this, "Option 2", Toast.LENGTH_SHORT).show();
                }
            }
        });
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,names);
        spinner.setAdapter(spinnerAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                   spinnerView.setText(names.get(position));
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                editTextViet.setText(s.toString());
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == numbercode && resultCode == RESULT_OK) {
            Toast.makeText(this, data.getStringExtra(intentcode), Toast.LENGTH_SHORT).show();
        }
    }
}
