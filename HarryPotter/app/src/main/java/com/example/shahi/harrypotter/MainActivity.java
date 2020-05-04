package com.example.shahi.harrypotter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup r;
    ImageView i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        r=findViewById(R.id.radioGroup);
        i=findViewById(R.id.imageView);
        r.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.radioButton1){
                    i.setImageResource(R.drawable.harry);
                    Toast.makeText(MainActivity.this, "Harry", Toast.LENGTH_SHORT).show();
                }
                if(checkedId==R.id.radioButton2){
                    i.setImageResource(R.drawable.herm);
                    Toast.makeText(MainActivity.this, "Hermonine", Toast.LENGTH_SHORT).show();
                }
                if(checkedId==R.id.radioButton3){
                    i.setImageResource(R.drawable.ron);
                    Toast.makeText(MainActivity.this, "Ron", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
