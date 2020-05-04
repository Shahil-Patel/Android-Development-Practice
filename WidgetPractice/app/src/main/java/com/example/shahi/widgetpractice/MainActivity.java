package com.example.shahi.widgetpractice;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean s=false;
    int x;
    int y;
    Button testButton;
    SeekBar seekBar;
    EditText editText;
    TextView textView;
    Switch aSwitch;
    TextView switchText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        testButton=findViewById(R.id.testButton);
        seekBar=findViewById(R.id.seekBar);
        editText=findViewById(R.id.editText);
        textView=findViewById(R.id.textView);
        aSwitch=findViewById(R.id.aSwitch);
        switchText=findViewById(R.id.switchText);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(!s)
                    testButton.setWidth(testButton.getWidth()+progress/2);
                if(s)
                    testButton.setWidth(testButton.getWidth()-progress/2);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                x=seekBar.getProgress();
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                y=seekBar.getProgress();
                if(x>y)
                    s=false;
                if(x<y)
                    s=true;
            }
        });
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                switch(String.valueOf(s).toLowerCase()){
                    case "red": textView.setTextColor(Color.RED);
                        break;
                    case "blue": textView.setTextColor(Color.BLUE);
                        break;
                    case "green": textView.setTextColor(Color.GREEN);
                        break;
                    default: textView.setTextColor(Color.BLACK);
                }
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    switchText.setText("BAR OFF");
                    seekBar.setEnabled(false);
                }
                if(!isChecked) {
                    switchText.setText("BAR ON");
                    seekBar.setEnabled(true);
                }
            }
        });
    }
}
