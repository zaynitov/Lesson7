package com.example.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<ItemTypes> mData;

    public static class MyViewHolder1 extends RecyclerView.ViewHolder {
        public TextView mTextView1;



        public MyViewHolder1(View view) {
            super(view);
            mTextView1 = (TextView) view.findViewById(R.id.textview1);
        }
    }

    public static class MyViewHolder2 extends RecyclerView.ViewHolder {
        public TextView mTextView2;

        public MyViewHolder2(View view) {
            super(view);
            mTextView2 = (TextView) view.findViewById(R.id.textview2);
        }
    }

    public static class MyViewHolder3 extends RecyclerView.ViewHolder {
        public TextView mTextView3;

        public MyViewHolder3(View view) {
            super(view);
            mTextView3 = (TextView) view.findViewById(R.id.textview3);
        }
    }


    public CustomAdapter(List<ItemTypes> myDataset) {
        mData = myDataset;
    }


    @Override
    public int getItemViewType(int position) {

        if (mData.get(position).getType() == ItemTypes.FIRSTTYPE.getType()) return 0;
        if (mData.get(position).getType() == ItemTypes.SECONDTYPE.getType()) return 1;
        if (mData.get(position).getType() == ItemTypes.THIRDTYPE.getType()) return 2;
return 0;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        switch (viewType) {
            case 0:
                return new MyViewHolder1(LayoutInflater.from(parent.getContext()).inflate(R.layout.cell1, parent, false));
            case 1:
                return new MyViewHolder2(LayoutInflater.from(parent.getContext()).inflate(R.layout.cell2, parent, false));
            case 2:
                return new MyViewHolder3(LayoutInflater.from(parent.getContext()).inflate(R.layout.cell3, parent, false));
        }


        return new MyViewHolder1(LayoutInflater.from(parent.getContext()).inflate(R.layout.cell1, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        System.out.println(holder.getItemViewType());
        switch (holder.getItemViewType()) {
            case 0:
                MyViewHolder1 viewHolder1 = (MyViewHolder1) holder;
                viewHolder1.mTextView1.setText("SDA");
//                viewHolder1.mTextView1.setText("Test1");
                break;
            case 1:
                MyViewHolder2 viewHolder2 = (MyViewHolder2) holder;
               // viewHolder2.mTextView2.setText("Test2");
                break;
            case 2:
                MyViewHolder3 viewHolder3 = (MyViewHolder3) holder;
               // viewHolder3.mTextView3.setText("Test3");
                break;

        }




    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
