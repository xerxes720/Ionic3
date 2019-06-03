package com.example.Ionic3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ViewHolder> {

    //    private MyListData[] listData;
    public ArrayList<MyListData> listData;


    public MyListAdapter(ArrayList<MyListData> listData) {
        this.listData = listData;
    }


    @Override
    public void onBindViewHolder(@NonNull MyListAdapter.ViewHolder holder, int position) {

    }


    @NonNull
    @Override
    public MyListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;

    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView;
        public TextView textView2;
        public TextView textView3;
        public RelativeLayout relativeLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            this.imageView = itemView.findViewById(R.id.calender_image_small);
            this.textView = itemView.findViewById(R.id.title_text_view_recycler);
            this.textView2 = itemView.findViewById(R.id.assign_id);
            this.textView3 = itemView.findViewById(R.id.task_status);
            relativeLayout = itemView.findViewById(R.id.list_item_recycler);
        }
    }
}