package com.example.kangjisung.likeroom.Garbage;

import android.content.Context;
import android.graphics.PorterDuff;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kangjisung.likeroom.CustomClass.SingleToast;
import com.example.kangjisung.likeroom.FragmentUser.UserRecyclerViewItem;
import com.example.kangjisung.likeroom.R;

import java.util.ArrayList;

/**
 * Created by Ahn on 2016-12-19.
 */

public class _UserListViewAdapter extends BaseAdapter
{
    // Adapter에 추가된 데이터를 저장하기 위한 ArrayList
    ArrayList<UserRecyclerViewItem> userListViewItemRecycler;
    Button buttonDescription;

    // ListViewAdapter의 생성자
    public _UserListViewAdapter() {
        super();

        userListViewItemRecycler = new ArrayList<UserRecyclerViewItem>() ;
    }

    // Adapter에 사용되는 데이터의 개수를 리턴. : 필수 구현
    @Override
    public int getCount() {
        return userListViewItemRecycler.size() ;
    }

    // position에 위치한 데이터를 화면에 출력하는데 사용될 View를 리턴. : 필수 구현
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        int pos = position;
        final Context context = parent.getContext();

        // "listview_item" Layout을 inflate하여 convertView 참조 획득.
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.user_recyclerview, parent, false);
        }

        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        TextView textViewName = (TextView)convertView.findViewById(R.id.textViewName) ;
        TextView textViewPhone = (TextView)convertView.findViewById(R.id.textViewPhone) ;
        TextView textViewPoint = (TextView)convertView.findViewById(R.id.textViewPoint) ;

        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        final UserRecyclerViewItem userRecyclerViewItem = userListViewItemRecycler.get(position);

        // 아이템 내 각 위젯에 데이터 반영
        textViewName.setText(userRecyclerViewItem.getName());
        textViewPhone.setText(userRecyclerViewItem.getPhone());
        textViewPoint.setText(userRecyclerViewItem.getPoint());

        buttonDescription = (Button)convertView.findViewById(R.id.buttonDescription);
        buttonDescription.getBackground().setColorFilter(ContextCompat.getColor(context, R.color.clrMenuIcon), PorterDuff.Mode.SRC_IN);
        buttonDescription.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                SingleToast.show(context, userRecyclerViewItem.getName().toString() + " 항목의 버튼 클릭", Toast.LENGTH_SHORT);
            }
        });

        return convertView;
    }

    // 지정한 위치(position)에 있는 데이터와 관계된 아이템(row)의 ID를 리턴. : 필수 구현
    @Override
    public long getItemId(int position) {
        return position;
    }

    // 지정한 위치(position)에 있는 데이터 리턴 : 필수 구현
    @Override
    public Object getItem(int position) {
        return userListViewItemRecycler.get(position) ;
    }

    // 아이템 데이터 추가를 위한 함수. 개발자가 원하는대로 작성 가능.
    public void addItem(String addName, String addPhone, String addPoint)
    {
        UserRecyclerViewItem addItemList = new UserRecyclerViewItem();

        addItemList.setName(addName);
        addItemList.setPhone(addPhone);
        addItemList.setPoint(addPoint);

        userListViewItemRecycler.add(addItemList);
    }
}
