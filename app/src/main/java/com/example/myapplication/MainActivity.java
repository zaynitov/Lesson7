package com.example.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    MyBroadcastReceiver myBroadcastReceiver;
    IntentFilter intentFilter;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private LinearLayoutManager mManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        myBroadcastReceiver = new MyBroadcastReceiver();
        intentFilter = new IntentFilter(MyService.intentFilterString);
        registerReceiver(myBroadcastReceiver, intentFilter);
        mRecyclerView = findViewById(R.id.recycleview);
        mManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mManager);
        List<ItemTypes> listForRecView = new ArrayList<>();

        listForRecView.add(ItemTypes.FIRSTTYPE);
        listForRecView.add(ItemTypes.SECONDTYPE);
        listForRecView.add(ItemTypes.THIRDTYPE);


        mAdapter = new CustomAdapter(listForRecView);
        mRecyclerView.setAdapter(mAdapter);

        startService(MyService.newIntent(this));

    }


    public class MyBroadcastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {

            mRecyclerView.findViewHolderForAdapterPosition(0).itemView.setBackgroundColor(Color.parseColor(intent.getStringExtra("colour1")));
            mRecyclerView.findViewHolderForAdapterPosition(1).itemView.setBackgroundColor(Color.parseColor(intent.getStringExtra("colour2")));
            mRecyclerView.findViewHolderForAdapterPosition(2).itemView.setBackgroundColor(Color.parseColor(intent.getStringExtra("colour3")));
        }
    }


}
