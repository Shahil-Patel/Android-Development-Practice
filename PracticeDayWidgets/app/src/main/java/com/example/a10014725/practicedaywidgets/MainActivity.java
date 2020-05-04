package com.example.a10014725.practicedaywidgets;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SeekBar seekBar;
    TextView textSize;
    Switch switch1;
    Switch switch2;
    Switch switch3;
    TextView textColor;
    boolean s1=false;
    boolean s2=false;
    boolean s3=false;
    Button button;
    Button button2;
    EditText editText;
    EditText editText2;
    TextView textView6;
    TextView textView7;
    ArrayList<String> a=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekBar=findViewById(R.id.seekBar);
        textSize=findViewById(R.id.textSize);
        switch1=findViewById(R.id.switch1);
        switch2=findViewById(R.id.switch2);
        switch3=findViewById(R.id.switch3);
        textColor=findViewById(R.id.textColor);
        button=findViewById(R.id.button);
        button2=findViewById(R.id.button2);
        editText=findViewById(R.id.editText);
        editText2=findViewById(R.id.editText2);
        textView6=findViewById(R.id.textView6);
        textView7=findViewById(R.id.textView7);
        button=findViewById(R.id.button);
        button2=findViewById(R.id.button2);
        a.add("a@sb.com");
        a.add("b@sb.com");
        a.add("c@sb.com");
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textSize.setTextSize(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    s1=true;
                if(!isChecked)
                    s1=false;
                if(s1&&s2&&s3)
                {
                    textColor.setTextColor(Color.BLUE);
                }
                else if (s1&&s3&&!s2){
                    textColor.setTextColor(Color.RED);
                }
                else if (!s1&&s3&&!s2){
                    textColor.setTextColor(Color.GREEN);
                }
            }
        });
        switch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    s2=true;
                if(!isChecked)
                    s2=false;
                if(s1&&s2&&s3)
                {
                    textColor.setTextColor(Color.BLUE);
                }
                else if (s1&&s3&&!s2){
                    textColor.setTextColor(Color.RED);
                }
                else if (!s1&&s3&&!s2){
                    textColor.setTextColor(Color.GREEN);
                }
            }
        });
        switch3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    s3=true;
                if(!isChecked)
                    s3=false;
                if(s1&&s2&&s3)
                {
                    textColor.setTextColor(Color.BLUE);
                }
                else if (s1&&s3&&!s2){
                    textColor.setTextColor(Color.RED);
                }
                else if (!s1&&s3&&!s2){
                    textColor.setTextColor(Color.GREEN);
                }
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str=editText.getText().toString();
                if(str.indexOf("@")<str.indexOf(".com")&&str.contains("@")&&str.contains(".com")){
                    textView6.setText("Verified");
                }
                else textView6.setText("Not Verified");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str=editText2.getText().toString();
                if(str.contains(a.get(0))&&str.length()==a.get(0).length()){
                    textView7.setText("In Database");
                }
                else if(str.contains(a.get(1))&&str.length()==a.get(1).length()){
                    textView7.setText("In Database");
                }
                else if(str.contains(a.get(2))&&str.length()==a.get(2).length()){
                    textView7.setText("In Database");
                }
                else textView7.setText("Not In Database");
            }
        });
    }
}
