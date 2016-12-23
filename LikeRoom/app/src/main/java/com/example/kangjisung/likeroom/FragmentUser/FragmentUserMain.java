package com.example.kangjisung.likeroom.FragmentUser;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.kangjisung.likeroom.R;

public class FragmentUserMain extends Fragment implements View.OnClickListener
{
    private View view;
    private RecyclerView userRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private UserRecyclerViewAdapter mAdapter;

    private Button buttonSortByName;
    private Button buttonSortByPhone;
    private Button buttonSortByPoint;
    private Button buttonNotice;

    private int sortStateId = R.id.buttonSortByName;
    private String sortState = "ASC";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.user_main, container, false);

        mAdapter = new UserRecyclerViewAdapter();
        mLayoutManager = new LinearLayoutManager(getActivity());

        userRecyclerView = (RecyclerView)view.findViewById((R.id.recyclerView));
        userRecyclerView.setAdapter(mAdapter);
        userRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter.addItem("김소연", "01063192456", "4278 p");
        mAdapter.addItem("김철수", "01012345678", "762 p");
        mAdapter.addItem("홍길동", "01052512963", "0 p");
        for(int i=0; i<10; i++) {
            mAdapter.addItem("이름", "01010101010", "0 p");
        }

        /*
        userListView.setOnItemLongClickListener(new RecyclerView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView parent, View v, int position, long id)
            {
                UserListViewItem posItem = (UserListViewItem)parent.getItemAtPosition(position);

                SingleToast.show(getContext(),  posItem.getName().toString() + " 항목을 길게 눌렀습니다.", Toast.LENGTH_SHORT);

                return true;
            }
        });
        */

        buttonSortByName = (Button)view.findViewById(R.id.buttonSortByName);
        buttonSortByPhone = (Button)view.findViewById(R.id.buttonSortByPhone);
        buttonSortByPoint = (Button)view.findViewById(R.id.buttonSortByPoint);

        buttonSortByName.setOnClickListener(this);
        buttonSortByPhone.setOnClickListener(this);
        buttonSortByPoint.setOnClickListener(this);

        buttonNotice = (Button)view.findViewById(R.id.buttonNotice);

        /*
        buttonNotice.setOnClickListener(new Button.OnClickListener() {
            @Override
        });
        */

        return view;
    }

    @Override
    public void onClick(View view)
    {
        if(view instanceof Button) {
            // OnClick을 실행한 View가 버튼일 경우
            Button button = (Button) view;

            if (sortStateId != view.getId()) {
                Button beforeSortButton = (Button) getActivity().findViewById(sortStateId);
                button.setBackgroundResource(R.drawable.button_sort_asc);
                button.setTextColor(ContextCompat.getColor(getContext(), R.color.White));
                beforeSortButton.setBackgroundResource(R.drawable.button_sort);
                beforeSortButton.setTextColor(ContextCompat.getColor(getContext(), R.color.Black));
                sortStateId = view.getId();
                sortState = "ASC";
            }
            else {
                if (sortState.equals("DESC")) {
                    view.setBackgroundResource(R.drawable.button_sort_asc);
                    sortState = "ASC";
                } else {
                    view.setBackgroundResource(R.drawable.button_sort_desc);
                    sortState = "DESC";
                }
            }
            // TODO : sortStateId와 sortState를 이용해 정렬을 수행
            switch(sortStateId)
            {
                case R.id.buttonSortByName:
                    break;
                case R.id.buttonSortByPhone:
                    break;
                case R.id.buttonSortByPoint:
                    break;
            }
        }
    }
}