package com.example.a10014725.orientationandlistviewapp;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
public class MainActivity extends AppCompatActivity {
    Double land=0.0;
    ListView list;
    Double population=0.0;
    String text="Click on a list item to show my thoughts";
    ArrayList<Countries> a = new ArrayList<>();
    public static final String land_key = "SAVE";
    public static final String population_key = "SAVED";
    public static final String list_key = "Sav9-9ouie";
    public static final String text_key = "Sav9asd-9ouie";
    @Override
    protected void onStart() {
        super.onStart();
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putDouble(land_key, land);
        outState.putDouble(population_key, population);
        outState.putSerializable(list_key,a);
        outState.putString(text_key,text);
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
        final TextView text3 = findViewById(R.id.textView3);
        final TextView text6 = findViewById(R.id.textView6);
        list = findViewById(R.id.list);
        final TextView text4 = findViewById(R.id.textView4);
        final TextView text5 = findViewById(R.id.textView5);
        final TextView text7=findViewById(R.id.textView7);
        text3.setText("Population (millions)): 0.0");
        text4.setText("Land area (million mi^2): 0.0");
        a.add(new Countries(8.65, 293.0, R.drawable.sov, "Soviet Union", "The Union of Soviet Socialist Republics (USSR), commonly known as the Soviet Union, was a socialist state in Eurasia that existed from 30 December 1922 to 26 December 1991", "This empire was actually garbage as everyone went hungary and it collapsed in the 90s (it was created in the 20s). Amazing Idea, horrible execution. 4/10"));
        a.add(new Countries(.145, 126.8, R.drawable.jap, "Japanese Empire", "Japan consists of several thousands of islands, of which Honshu, Hokkaido, Kyushu and Shikoku are the four largest. Japan's closest neighbors are Korea, Russia and China", "Probably the best empire in the world due to the sheer niceness of its population and because they produce many video games companies like Sony and Nintendo 7/10"));
        a.add(new Countries(.008958, .956, R.drawable.dji, "Djibouti", "A country located in the Horn of Africa. It is bordered by Eritrea in the north, Ethiopia in the west and south, and Somalia in the southeast. The remainder of the border is formed by the Red Sea and the Gulf of Aden at the east", "There is literally nothing special about this country except for tis name 6/10"));
        a.add(new Countries(.261, 52.8, R.drawable.aus, "Austro-Hungarian Empire", "The Austro-Hungarian Empire or the Dual Monarchy in English-language sources, was a constitutional union of the Austrian Empire (the Kingdoms and Lands Represented in the Imperial Council, or Cisleithania) and the Kingdom of Hungary", "The absolute coolest empire in the entire world, this empire was a mix of like 5+ ethnicities and held its own against Italy and France during WW1 9/19"));
        a.add(new Countries(92.7, 12.5, R.drawable.mong, "Mongolian Empire", "Originating in the steppes of Central Asia, the Mongol Empire eventually stretched from Eastern Europe and parts of Central Europe to the Sea of Japan, extending northwards into Siberia, eastwards and southwards into the Indian subcontinent, Indochina and the Iranian Plateau", "This empire was the most bestest goodest empire of all the empires ever. It is said you can walk 1k steps in any direction without having to fear of a crime. Would create again 11/10"));
        a.add(new Countries(.261, 53.37, R.drawable.bur, "Burma/Myanmar", "The Republic of the Union of Myanmar and also known as Burma, is a country in Southeast Asia. Myanmar is bordered by India and Bangladesh to its west, Thailand and Laos to its east and China to its north and northeast", "This country is ruled by "));
        a.add(new Countries(1.27, 1333.9, R.drawable.india, "India", "India’s astounding diversity of religions, languages, and cultures is unique and unparalleled. The society of vast subcontinent, varied and complex in its rich heritage, is among the oldest in the world.", "Home country of many in this school, this country is one of the fastest growing countries in the world and has the best colleges and brightest people 8/10"));
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    land = a.get(position).getLandArea();
                    population = a.get(position).getPopulation();
                    text=a.get(position).getTextChanged()+"";
                    text7.setText(text);
                    text5.setText("Population (millions): " + a.get(position).getPopulation() + "");
                    text6.setText("Land area (million mi^2): " + a.get(position).getLandArea() + "");
                }
            });
        }
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    land = a.get(position).getLandArea();
                    population = a.get(position).getPopulation();
                    text3.setText("Population (millions): " + a.get(position).getPopulation() + "");
                    text4.setText("Land area (million mi^2): " + a.get(position).getLandArea() + "");
                }
            });
        }
        if (savedInstanceState != null) {
            land=savedInstanceState.getDouble(land_key);
            population=savedInstanceState.getDouble(population_key);
            a=(ArrayList<Countries>) savedInstanceState.getSerializable(list_key);
            text=savedInstanceState.getString(text_key);
            if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                text6.setText("Land area (million mi^2): " + savedInstanceState.getDouble(land_key) + "");
                text5.setText("Population (millions): " + savedInstanceState.getDouble(population_key) + "");
                text7.setText(text);
            }
            if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                text3.setText("Land area (million mi^2): " + savedInstanceState.getDouble(land_key) + "");
                text4.setText("Population (millions): " + savedInstanceState.getDouble(population_key) + "");
            }
        }
        CustomAdapter adapter = new CustomAdapter(this, R.layout.cutom_layout, a);
        list.setAdapter(adapter);
    }
    public class CustomAdapter extends ArrayAdapter<Countries> {
        Context context;
        int resource;
        List<Countries> objects;
        public CustomAdapter(@NonNull Context context, int resource, @NonNull List<Countries> objects) {
            super(context, resource, objects);
            this.context = context;
            this.resource = resource;
            this.objects = objects;
        }
        @NonNull
        @Override
        public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            View adapterLayout = inflater.inflate(resource, null);
            TextView textView = adapterLayout.findViewById(R.id.textView);
            final TextView textView2 = adapterLayout.findViewById(R.id.textView2);
            Button button2 = adapterLayout.findViewById(R.id.button2);
            ImageView imageView = adapterLayout.findViewById(R.id.imageView);
            if(position<a.size()) {
                textView.setText(a.get(position).getNames());
                imageView.setImageResource(a.get(position).getImages());
                textView2.setText(a.get(position).getTexts());
                if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    textView2.setText("");
                }
                button2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        a.remove(position);
                        notifyDataSetChanged();
                    }
                });
            }
            return adapterLayout;
        }
    }
    public class Countries implements Serializable{
        double population;
        double landArea;
        int image;
        String name;
        String text;
        String textChanged;
        public Countries(double landArea, double population, int image, String name, String text, String textChanged) {
            this.population = population;
            this.landArea = landArea;
            this.image = image;
            this.name = name;
            this.text = text;
            this.textChanged = textChanged;
        }
        public double getPopulation() {
            return population;
        }
        public double getLandArea() {
            return landArea;
        }
        public int getImages() {
            return image;
        }
        public String getNames() {
            return name;
        }
        public String getTexts() {
            return text;
        }
        public String getTextChanged() {
            return textChanged;
        }
        public void setText(String temp){
            text=temp;
        }
    }
}

