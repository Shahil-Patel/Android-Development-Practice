package com.example.a10014725.intentdemo;
import android.content.Intent;
import android.support.annotation.MainThread;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button launchButton;
    TextView name;
    TextView number;
    static final int numbercode=1234;
    static final String intentcode="Marty";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        launchButton=findViewById(R.id.launchButton);
        name=findViewById(R.id.name);
        number=findViewById(R.id.number);
        launchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentToLoad=new Intent(MainActivity.this,ActivityNumber.class);
                intentToLoad.putExtra("Test","This is a test");
                startActivityForResult(intentToLoad,numbercode);

                //   startActivity(intentToLoad);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==numbercode&&resultCode==RESULT_OK){
            number.setText(data.getStringExtra(intentcode));
        }
    }
}
