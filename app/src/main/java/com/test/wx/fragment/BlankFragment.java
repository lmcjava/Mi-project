package com.test.wx.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.test.wx.R;

public class BlankFragment extends Fragment {


    public static BlankFragment newInstance(String parm){
        BlankFragment blankFragment = new BlankFragment();
        Bundle bundle = new Bundle();
        bundle.putString("test",parm);
        blankFragment.setArguments(bundle);
        return blankFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_content, null);
        TextView textView=view.findViewById(R.id.tv);
        textView.setText(getArguments().getString("test"));
        System.out.println("onCreateView>>>>>>>>>>>"+getArguments().getString("test"));
        return view;
    }
}
