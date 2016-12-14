package com.example.kangjisung.likeroom.FragmentItem;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kangjisung.likeroom.R;

public class FragmentItemMain extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        /* 초기화 코드는 여기서 */
        return inflater.inflate(R.layout.item_main, container, false);
    }

    /* 이벤트 코드는 여기서 */
}