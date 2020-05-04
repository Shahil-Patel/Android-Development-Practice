package com.example.a10014725.lifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button button;
    int c = 0;
    public static final String counter_key="SAVE";
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("TAG","onStart()");
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(counter_key,c);
    }
    @Override
    protected void onResume() {
        super.onResume();
}
    @Override
    protected void onPause() {
        super.onPause();
    }
    @Override
    protected void onStop() {
        super.onStop();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.adder);
        textView=findViewById(R.id.counter);
        if(savedInstanceState!=null){
            c=savedInstanceState.getInt(counter_key);
            textView.setText(c+"");
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c++;
                textView.setText(""+c);
            }
        });
    }
}
