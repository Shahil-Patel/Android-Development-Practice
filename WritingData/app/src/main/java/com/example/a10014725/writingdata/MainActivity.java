package com.example.a10014725.writingdata;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String test="Write this stuff";
        String fileName="info.json";
        TextView textView=findViewById(R.id.textview);
        try {
            OutputStreamWriter writer=new OutputStreamWriter(openFileOutput(fileName, Context.MODE_PRIVATE));
            writer.write(test);
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String input="";
        try {
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(openFileInput(fileName)));
            input="";
            input=bufferedReader.readLine();
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        textView.setText(input);
    }
}
