package com.example.fragmentsdemo;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
public class top extends Fragment {
    TextView title;
    TextView info;
    TextView mainText;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragmentTopView = inflater.inflate(R.layout.fragment_top,null);
        info=fragmentTopView.findViewById(R.id.botInfo);
        title=fragmentTopView.findViewById(R.id.topTitle);
        mainText=getActivity().findViewById(R.id.mainText);
        Button button=fragmentTopView.findViewById(R.id.botbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText("This is now Changed");
                mainText.setText("Click sent from top fragment");
            }
        });
        return fragmentTopView;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }
}
