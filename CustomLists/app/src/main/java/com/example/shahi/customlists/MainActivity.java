package com.example.shahi.customlists;
import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
public class MainActivity extends AppCompatActivity {
    ListView list;
    ArrayList<String> a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        a=new ArrayList<>();
        list=findViewById(R.id.list);
        a.add("Aboosh");
        a.add("Maduri Man");
        a.add("Cancer");
        a.add("a");
        a.add("zxcv");
        CustomAdapter adapter=new CustomAdapter(this,R.layout.custom_layout,a);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,position+"",Toast.LENGTH_SHORT).show();
            }
        });
    }
    public class CustomAdapter extends ArrayAdapter<String>
    {
        Context context;
        int resource;
        List<String> list;

        public CustomAdapter(@NonNull Context context, int resource, @NonNull List<String> objects) {
            super(context, resource, objects);
            this.context=context;
            this.resource=resource;
            this.list=objects;
        }
        @NonNull
        @Override
        public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflator=(LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            View adapterLayout=inflator.inflate(resource,null);
            TextView textView=adapterLayout.findViewById(R.id.textView);
            Button button=adapterLayout.findViewById(R.id.button);
            ImageView imageView=adapterLayout.findViewById(R.id.imageView);
            textView.setText(list.get(position)+" Position: "+position);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    list.remove(position);
                    notifyDataSetChanged();
                }
            });
            return adapterLayout;
        }
    }
}
