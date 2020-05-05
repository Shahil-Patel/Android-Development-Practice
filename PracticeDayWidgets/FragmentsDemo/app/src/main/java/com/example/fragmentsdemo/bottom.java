package com.example.fragmentsdemo;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
public class bottom extends Fragment {
    TextView title;
    TextView info;
    receiveString str;
    TextView mainText;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragmentBottomView = inflater.inflate(R.layout.fragment_bottom,null);
        info=fragmentBottomView.findViewById(R.id.botInfo);
        title=fragmentBottomView.findViewById(R.id.botTitle);
        mainText=getActivity().findViewById(R.id.mainText);
        Button button=fragmentBottomView.findViewById(R.id.botbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText("This is now Changed");
                mainText.setText("Click sent from bottom fragment");
                str.receive("Click ");
            }
        });
        return fragmentBottomView;
    }

    public interface receiveString{
        public void receive(String string);
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        str=(receiveString)context;
    }
}
