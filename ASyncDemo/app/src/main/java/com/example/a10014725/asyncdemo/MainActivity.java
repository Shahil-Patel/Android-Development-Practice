package com.example.a10014725.asyncdemo;

import android.graphics.Color;
import android.os.AsyncTask;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    URL url;
    URLConnection urlConnection;
    InputStream inputStream;
    String zip="";
    ArrayList<JSONObject> a=new ArrayList<>();
    ArrayList<ImageView> images=new ArrayList<>();
    ArrayList<TextView> texts=new ArrayList<>();
    ArrayList<String> quotes=new ArrayList<>();
    //https://api.openweathermap.org/data/2.5/forecast?zip=94040&appid=e9fbc5009440a8823c68c3b4ccdbdf61
    //API KEY e9fbc5009440a8823c68c3b4ccdbdf61
    //F = 9/5(K - 273) + 32 kelvin to farenheight                //CLEAR CLOUDS RAIN SNOW THUNDER
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button=findViewById(R.id.button);
        final EditText editText=findViewById(R.id.editText);
        final ImageView imageView=findViewById(R.id.imageView);
        final ImageView imageView2=findViewById(R.id.imageView2);
        final ImageView imageView3=findViewById(R.id.imageView3);
        final ImageView imageView4=findViewById(R.id.imageView4);
        final ImageView imageView5=findViewById(R.id.imageView5);
        final ImageView imageView6=findViewById(R.id.imageView6);
        quotes.add("\"There are exoplanets in our universe that have an atmosphere that is free of clouds\""); //clear
        quotes.add("\"Since the moon has no atmosphere, it is clear all (lunar) year long\""); //clear
        quotes.add("\"An interstellar cloud is generally an accumulation of gas, plasma, and dust in our and other galaxies\""); //Cloud
        quotes.add("\"The Hercules–Corona Borealis Great Wall or the Great GRB Wall is a massive cloud of galactic super structure that is the largest thing in the universe spanning 10 billion light years\""); //cloudy
        quotes.add("\"You know on Jupiter and Saturn it rains diamonds?\""); //rain
        quotes.add("\"Two teams of astronomers have discovered the largest and farthest reservoir of water ever detected in the universe. The water, equivalent to 140 trillion times all the water in the world's ocean, surrounds a huge, feeding black hole, called a quasar, more than 12 billion light-years away\""); //rain
        quotes.add("\"It can snow up to 80 times a year in space\""); //snow
        quotes.add("\"The Boomerang Nebula in the constellation Centaurus is officially the coldest known place in the entire Universe. It's even colder than the background temperature of space\""); //snow
        quotes.add("\"Lightning could occur in the middle of space, with a force equal to a trillion lightning bolts\""); //thunder
        quotes.add("\"Researchers at the University of Toronto have found some serious current emanating from a huge cosmic jet 2 billion light years from Earth. At 1018 amps, the current is the strongest current ever seen, equalling something like a trillion bolts of lightning\""); //thunder
        final TextView textView=findViewById(R.id.textView);
        TextView textView2=findViewById(R.id.textView2);
        TextView textView3=findViewById(R.id.textView3);
        TextView textView4=findViewById(R.id.textView4);
        TextView textView5=findViewById(R.id.textView5);
        final TextView textView11=findViewById(R.id.textView11);
        texts.add(textView);
        texts.add(textView2);
        texts.add(textView3);
        texts.add(textView4);
        texts.add(textView5);
        TextView textView6=findViewById(R.id.textView6);
        TextView textView7=findViewById(R.id.textView7);
        TextView textView8=findViewById(R.id.textView8);
        TextView textView9=findViewById(R.id.textView9);
        TextView textView10=findViewById(R.id.textView10);
        texts.add(textView6);
        texts.add(textView7);
        texts.add(textView8);
        texts.add(textView9);
        texts.add(textView10);
        TextView textView12=findViewById(R.id.textView12);
        TextView textView13=findViewById(R.id.textView13);
        TextView textView14=findViewById(R.id.textView14);
        TextView textView15=findViewById(R.id.textView15);
        TextView textView16=findViewById(R.id.textView16);
        final TextView quote=findViewById(R.id.textView22);
        TextView textView17=findViewById(R.id.textView17);
        TextView textView18=findViewById(R.id.textView18);
        TextView textView19=findViewById(R.id.textView19);
        TextView textView20=findViewById(R.id.textView20);
        TextView textView21=findViewById(R.id.textView21);
        final TextView textView23=findViewById(R.id.textView23);
        texts.add(textView12);
        texts.add(textView13);
        texts.add(textView14);
        texts.add(textView15);
        texts.add(textView16);
        texts.add(textView17);
        texts.add(textView18);
        texts.add(textView19);
        texts.add(textView20);
        texts.add(textView21);
        for(int x=0;x<texts.size();x++)
            texts.get(x).setTextColor(Color.rgb(253,205,71));
        textView11.setTextColor(Color.rgb(253,205,71));
        images.add(imageView);
        images.add(imageView2);
        images.add(imageView3);
        images.add(imageView4);
        images.add(imageView5);
        images.add(imageView6);
        RelativeLayout rl=findViewById(R.id.c);
        rl.setBackgroundColor(Color.rgb(41,48,60));
        button.setBackgroundColor(Color.rgb(253,205,71));
        button.setTextColor(Color.rgb(158,158,153));
        editText.setTextColor(Color.rgb(158,158,153));
        textView23.setTextColor(Color.rgb(253,205,71));
        quote.setTextColor(Color.rgb(253,205,71));
        editText.setGravity(Gravity.CENTER);
        editText.setBackgroundColor(Color.rgb(253,205,71));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zip=editText.getText().toString();
                AsyncThread thread=new AsyncThread();
                try {
                    thread.execute().get();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for(int x=0;x<a.size();x++) {
                    try {
                        textView11.setText((a.get(x).getString("dt_txt").substring(0,8))+(Integer.parseInt(a.get(x).getString("dt_txt").substring(8,10))-1));
                        if(  Integer.parseInt(a.get(x).getString("dt_txt").substring(11,13))-5>0){
                            texts.get(x).setText((Integer.parseInt(a.get(x).getString("dt_txt").substring(11,13)))-5+":00:00");
                        }

                        else texts.get(x).setText((Integer.parseInt(a.get(x).getString("dt_txt").substring(11,13))+19)+":00:00");
                        textView23.setText("Temperature: "+Math.round((1.8*(Double.parseDouble(a.get(0).getJSONObject("main").getString("temp"))-273)+32)*100.0)/100.0);
                        texts.get(x+10).setText("Tmin: "+Math.round((1.8*( Double.parseDouble(a.get(x).getJSONObject("main").getString("temp_min"))-273)+32)*100.0)/100.0+"");
                        texts.get(x+15).setText("Tmax: "+Math.round((1.8*( Double.parseDouble(a.get(x).getJSONObject("main").getString("temp_max"))-273)+32)*100.0)/100.0+"");
                        texts.get(x+5).setText(a.get(x).getJSONArray("weather").getJSONObject(0).getString("main"));
                        if(x==0)
                        {
                            if (a.get(x).getJSONArray("weather").getJSONObject(0).getString("main").equals("Clear")) {
                                if((int)((Math.random()*2)+1)%2==0){
                                    quote.setText(quotes.get(0));
                                    imageView.setImageResource(R.drawable.exo);
                                }
                                else{ quote.setText(quotes.get(1));
                                    imageView.setImageResource(R.drawable.moon);
                                }
                                imageView2.setImageResource(R.drawable.clear);
                            } else if (a.get(x).getJSONArray("weather").getJSONObject(0).getString("main").equals("Clouds")) {
                                if((int)((Math.random()*2)+1)%2==0){
                                    quote.setText(quotes.get(2));
                                    imageView.setImageResource(R.drawable.intcloud);
                                }
                                else{ quote.setText(quotes.get(3));
                                    imageView.setImageResource(R.drawable.herc);

                                }
                                imageView2.setImageResource(R.drawable.cloudy);
                            } else if (a.get(x).getJSONArray("weather").getJSONObject(0).getString("main").equals("Rain")) {
                                if((int)((Math.random()*2)+1)%2==0){
                                    quote.setText(quotes.get(4));
                                    imageView.setImageResource(R.drawable.jupiter);
                                }
                                else{ quote.setText(quotes.get(5));
                                    imageView.setImageResource(R.drawable.water);

                                }
                                imageView2.setImageResource(R.drawable.rain);
                            } else if (a.get(x).getJSONArray("weather").getJSONObject(0).getString("main").equals("Snow")) {
                                if((int)((Math.random()*2)+1)%2==0){
                                    quote.setText(quotes.get(6));
                                    imageView.setImageResource(R.drawable.hoth);
                                }
                                else{ quote.setText(quotes.get(7));
                                    imageView.setImageResource(R.drawable.boom);

                                }
                                imageView2.setImageResource(R.drawable.snow);
                            } else if (a.get(x).getJSONArray("weather").getJSONObject(0).getString("main").equals("Thunder")) {
                                if((int)((Math.random()*2)+1)%2==0){
                                    quote.setText(quotes.get(8));
                                    imageView.setImageResource(R.drawable.light);
                                }
                                else{ quote.setText(quotes.get(9));
                                    imageView.setImageResource(R.drawable.lights);

                                }
                                imageView2.setImageResource(R.drawable.thunder);
                            }
                        }
                        if(x==1) {
                            if (a.get(x).getJSONArray("weather").getJSONObject(0).getString("main").equals("Clear")) {
                                imageView3.setImageResource(R.drawable.clear);
                            } else if (a.get(x).getJSONArray("weather").getJSONObject(0).getString("main").equals("Clouds")) {
                                imageView3.setImageResource(R.drawable.cloudy);
                            } else if (a.get(x).getJSONArray("weather").getJSONObject(0).getString("main").equals("Rain")) {
                                imageView3.setImageResource(R.drawable.rain);
                            } else if (a.get(x).getJSONArray("weather").getJSONObject(0).getString("main").equals("Snow")) {
                                imageView3.setImageResource(R.drawable.snow);
                            } else if (a.get(x).getJSONArray("weather").getJSONObject(0).getString("main").equals("Thunder")) {
                                imageView3.setImageResource(R.drawable.thunder);
                            }
                        }
                        if(x==2) {
                            if (a.get(x).getJSONArray("weather").getJSONObject(0).getString("main").equals("Clear")) {
                                imageView4.setImageResource(R.drawable.clear);
                            } else if (a.get(x).getJSONArray("weather").getJSONObject(0).getString("main").equals("Clouds")) {
                                imageView4.setImageResource(R.drawable.cloudy);
                            } else if (a.get(x).getJSONArray("weather").getJSONObject(0).getString("main").equals("Rain")) {
                                imageView4.setImageResource(R.drawable.rain);
                            } else if (a.get(x).getJSONArray("weather").getJSONObject(0).getString("main").equals("Snow")) {
                                imageView4.setImageResource(R.drawable.snow);
                            } else if (a.get(x).getJSONArray("weather").getJSONObject(0).getString("main").equals("Thunder")) {
                                imageView4.setImageResource(R.drawable.thunder);
                            }
                        }
                        if(x==3) {
                            if (a.get(x).getJSONArray("weather").getJSONObject(0).getString("main").equals("Clear")) {
                                imageView5.setImageResource(R.drawable.clear);
                            } else if (a.get(x).getJSONArray("weather").getJSONObject(0).getString("main").equals("Clouds")) {
                                imageView5.setImageResource(R.drawable.cloudy);
                            } else if (a.get(x).getJSONArray("weather").getJSONObject(0).getString("main").equals("Rain")) {
                                imageView5.setImageResource(R.drawable.rain);
                            } else if (a.get(x).getJSONArray("weather").getJSONObject(0).getString("main").equals("Snow")) {
                                imageView5.setImageResource(R.drawable.snow);
                            } else if (a.get(x).getJSONArray("weather").getJSONObject(0).getString("main").equals("Thunder")) {
                                imageView5.setImageResource(R.drawable.thunder);
                            }
                        }
                        if(x==4) {
                            if (a.get(x).getJSONArray("weather").getJSONObject(0).getString("main").equals("Clear")) {
                                imageView6.setImageResource(R.drawable.clear);
                            } else if (a.get(x).getJSONArray("weather").getJSONObject(0).getString("main").equals("Clouds")) {
                                imageView6.setImageResource(R.drawable.cloudy);
                            } else if (a.get(x).getJSONArray("weather").getJSONObject(0).getString("main").equals("Rain")) {
                                imageView6.setImageResource(R.drawable.rain);
                            } else if (a.get(x).getJSONArray("weather").getJSONObject(0).getString("main").equals("Snow")) {
                                imageView6.setImageResource(R.drawable.snow);
                            } else if (a.get(x).getJSONArray("weather").getJSONObject(0).getString("main").equals("Thunder")) {
                                imageView6.setImageResource(R.drawable.thunder);
                            }
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
    public class AsyncThread extends AsyncTask<Void,Void,String>{
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }
        @Override
        protected String doInBackground(Void... voids) {
            JSONArray array=new JSONArray();
            JSONObject object=new JSONObject();
            JSONObject object2=new JSONObject();
            a=new ArrayList<>();
            try {
                url = new URL("https://api.openweathermap.org/data/2.5/forecast?zip="+zip+"&appid=e9fbc5009440a8823c68c3b4ccdbdf61");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            try {
                urlConnection = url.openConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                inputStream = urlConnection.getInputStream();
            } catch (IOException e) {
                e.printStackTrace();
            }
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
            try {
                String st;
                while((st=bufferedReader.readLine())!=null){
                    object = new JSONObject(st);
                    array=(object.getJSONArray("list"));
                    for(int x=0;x<5;x++){
                        object2=array.getJSONObject(x);
                        a.add(object2);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return "";
        }
    }
}
