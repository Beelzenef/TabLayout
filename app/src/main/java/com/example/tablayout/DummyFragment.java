package com.example.tablayout;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DummyFragment extends Fragment {

    TextView txtV_Msg;

    public static String KEY_MSG = "msg";

    public static DummyFragment newInstance(Bundle args)
    {
        DummyFragment dummyFragment = new DummyFragment();
        if (args != null)
        {
            dummyFragment.setArguments(args);
        }
        return dummyFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View rootV = inflater.inflate(R.layout.fragment_dummy, container, false);
        txtV_Msg = (TextView) rootV.findViewById(R.id.txtV_Msg);
        txtV_Msg.setText(getArguments().getString(DummyFragment.KEY_MSG));
        return rootV;
    }
}
