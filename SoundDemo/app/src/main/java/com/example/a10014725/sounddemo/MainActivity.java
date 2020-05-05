package com.example.a10014725.sounddemo;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    Button stop;
    Button pause;
    MediaPlayer mediaPlayer;
    SeekBar progress;
    Button time;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pause = findViewById(R.id.pause);
        stop = findViewById(R.id.stop);
        progress=findViewById(R.id.seekBar);
        time=findViewById(R.id.time);
        textView=findViewById(R.id.textView);
        mediaPlayer = MediaPlayer.create(this,R.raw.alarm);
        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(""+mediaPlayer.getCurrentPosition()/1000);
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                }
                else mediaPlayer.start();
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                    try {
                        mediaPlayer.prepare();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else mediaPlayer.start();
            }
        });
        final Handler handler=new Handler();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if(mediaPlayer!=null){
                    progress.setProgress(100/(mediaPlayer.getCurrentPosition()/1000));
                }
                handler.postDelayed(this,500);
            }
        });
    }
}
