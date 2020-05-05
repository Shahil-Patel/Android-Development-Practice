package com.example.dialoguedemo;

import android.app.Dialog;
import android.app.NativeActivity;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button standard;
    Button custom;
    Button cButton;
    TextView cText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        standard=findViewById(R.id.standard);
        custom=findViewById(R.id.custom);
        cText=findViewById(R.id.cText);
        cButton=findViewById(R.id.cButton);
        custom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        standard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                alert.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Confirm Clicked", Toast.LENGTH_SHORT).show();
                    }
                });
                alert.setNegativeButton("Deny", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Deny Clicked", Toast.LENGTH_SHORT).show();
                    }
                });
                alert.setTitle("This is my title");
                alert.setMessage("This is my message");
                AlertDialog myAlert = alert.create();
                myAlert.show();
            }
        });
        custom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog customDialog = new Dialog(MainActivity.this);
                customDialog.setContentView(R.layout.dialog_layout);
                customDialog.setTitle("This is title");
                Button button = customDialog.findViewById(R.id.cButton);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "Custom Clicked", Toast.LENGTH_SHORT).show();
                        customDialog.dismiss();
                    }
                });
                customDialog.show();
            }
        });
    }
}
