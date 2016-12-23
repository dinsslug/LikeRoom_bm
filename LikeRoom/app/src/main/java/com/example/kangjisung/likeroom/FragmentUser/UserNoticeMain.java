package com.example.kangjisung.likeroom.FragmentUser;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kangjisung.likeroom.R;

/**
 * Created by Ahn on 2016-12-23.
 */

public class UserNoticeMain extends Fragment
{
    private View view;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.user_notice_main, container, false);

        return view;
    }
}