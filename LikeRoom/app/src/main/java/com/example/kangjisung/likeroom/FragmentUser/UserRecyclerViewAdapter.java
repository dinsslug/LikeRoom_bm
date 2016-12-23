package com.example.kangjisung.likeroom.FragmentUser;

import android.content.Context;
import android.graphics.PorterDuff;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kangjisung.likeroom.CustomClass.SingleToast;
import com.example.kangjisung.likeroom.R;

import java.util.ArrayList;

public class UserRecyclerViewAdapter extends RecyclerView.Adapter<UserRecyclerViewAdapter.UserRecyclerViewHolder>
{
    private ArrayList<UserRecyclerViewItem> userListViewItemRecycler = new ArrayList<UserRecyclerViewItem>();
    private Context context;

    UserRecyclerViewAdapter() {}

    public static class UserRecyclerViewHolder extends RecyclerView.ViewHolder
    {
        TextView textViewName;
        TextView textViewPhone;
        TextView textViewPoint;
        Button buttonDescription;
        public View view;

        UserRecyclerViewHolder(View view)
        {
            super(view);

            this.view = view;
            textViewName = (TextView)view.findViewById(R.id.textViewName);
            textViewPhone = (TextView)view.findViewById(R.id.textViewPhone);
            textViewPoint = (TextView)view.findViewById(R.id.textViewPoint);
            buttonDescription = (Button)view.findViewById(R.id.buttonDescription);
        }
    }

    @Override
    public UserRecyclerViewAdapter.UserRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_recyclerview, parent, false);
        UserRecyclerViewHolder vh = new UserRecyclerViewHolder(v);
        context = parent.getContext();
        return vh;
    }

    @Override
    public void onBindViewHolder(UserRecyclerViewHolder holder, int position)
    {
        final UserRecyclerViewItem userRecyclerViewItem = userListViewItemRecycler.get(position);
        holder.textViewName.setText(userRecyclerViewItem.getName());
        holder.textViewPhone.setText(userRecyclerViewItem.getPhone());
        holder.textViewPoint.setText(userRecyclerViewItem.getPoint());
        holder.buttonDescription.getBackground().setColorFilter(ContextCompat.getColor(context, R.color.clrMenuIcon), PorterDuff.Mode.SRC_IN);
        holder.buttonDescription.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                SingleToast.show(context, userRecyclerViewItem.getName().toString() + " 항목의 버튼 클릭", Toast.LENGTH_SHORT);
            }
        });
        holder.view.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view){
                SingleToast.show(context, userRecyclerViewItem.getName().toString() + " 항목을 길게 눌렀습니다", Toast.LENGTH_SHORT);
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return userListViewItemRecycler.size();
    }

    public void addItem(String addName, String addPhone, String addPoint)
    {
        UserRecyclerViewItem addItemList = new UserRecyclerViewItem();

        addItemList.setName(addName);
        addItemList.setPhone(addPhone);
        addItemList.setPoint(addPoint);

        userListViewItemRecycler.add(addItemList);
    }
}