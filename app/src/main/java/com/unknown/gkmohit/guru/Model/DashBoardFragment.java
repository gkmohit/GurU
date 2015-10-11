package com.unknown.gkmohit.guru.Model;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.unknown.gkmohit.guru.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class DashBoardFragment extends Fragment {

    public DashBoardFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dash_board, container, false);
    }
}
