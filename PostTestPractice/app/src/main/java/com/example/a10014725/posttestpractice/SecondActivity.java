package com.example.a10014725.posttestpractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    Button closer;
    EditText enterNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        closer=findViewById(R.id.closer);
        enterNumber=findViewById(R.id.editText);
        Toast.makeText(this,getIntent().getStringExtra("Test"),Toast.LENGTH_SHORT).show();
        closer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendInfoBack=new Intent(SecondActivity.this,MainActivity.class);
                sendInfoBack.putExtra(MainActivity.intentcode,enterNumber.getText().toString());
                setResult(RESULT_OK,sendInfoBack);
                finish();
            }
        });
    }
}
