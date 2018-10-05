package com.zhengyuan.skill.ButtomNavigationBar;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zhengyuan.skill.R;

/**
 * Created by Administrator on 2018/10/6.
 */

public class BookFragment extends Fragment {
    public static BookFragment newInstance(String param1) {
        BookFragment fragment = new BookFragment();
        Bundle args = new Bundle();
        args.putString("agrs1", param1);
        fragment.setArguments(args);
        return fragment;
    }

    public BookFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_book, container, false);
        Bundle bundle = getArguments();
        String agrs1 = bundle.getString("agrs1");
        TextView tv = (TextView) view.findViewById(R.id.tv_book);
        tv.setText(agrs1);
        return view;
    }
}
