package com.example.a10014725.intentdemo;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityNumber extends AppCompatActivity {
    Button closer;
    EditText enterNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number);
        closer=findViewById(R.id.closer);
        enterNumber=findViewById(R.id.editText);
        Toast.makeText(this,getIntent().getStringExtra("Test"),Toast.LENGTH_SHORT).show();
        closer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendInfoBack=new Intent(ActivityNumber.this,MainActivity.class);
                sendInfoBack.putExtra(MainActivity.intentcode,enterNumber.getText().toString());
                setResult(RESULT_OK,sendInfoBack);
                finish();
            }
        });
    }
}
