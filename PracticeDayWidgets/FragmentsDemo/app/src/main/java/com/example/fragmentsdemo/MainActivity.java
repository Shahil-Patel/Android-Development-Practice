package com.example.fragmentsdemo;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity implements bottom.receiveString{
    Button mainButton;
    TextView mainText;
    LinearLayout top;
    LinearLayout bottom;
    FragmentTransaction fragmentTransaction;
    FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainButton=findViewById(R.id.mainButton);
        mainText=findViewById(R.id.mainText);
        top=findViewById(R.id.top);
        bottom=findViewById(R.id.bottom);
        fragmentManager=getSupportFragmentManager();
        //start
        fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.layoutBottom, new bottom());
        fragmentTransaction.add(R.id.layoutTop,new top());
        fragmentTransaction.commit();
        //end
    }
    @Override
    public void receive(String string) {
        mainText.setText(string+"Interface View");
    }
}
