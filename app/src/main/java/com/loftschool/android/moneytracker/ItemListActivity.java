package com.loftschool.android.moneytracker;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TVV on 14.03.2018.
 */

public class ItemListActivity extends AppCompatActivity {

    private static final String TAG = "ItemListActivity";
    private RecyclerView mRecycleView;
    private List<Record> mData = new ArrayList<>();
    private ItemListAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items_list);
        mRecycleView = findViewById(R.id.list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecycleView.setLayoutManager(layoutManager);
//        mRecycleView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new ItemListAdapter();
        createData();

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, layoutManager.getOrientation());
        mRecycleView.addItemDecoration(dividerItemDecoration);

        mRecycleView.setAdapter(mAdapter);
    }

    private void createData() {
        mData.add(new Record("Молоко", 35));
        mData.add(new Record("Жизнь", 1));
        mData.add(new Record("Курсы", 50));
        mData.add(new Record("Хлеб", 26));
        mData.add(new Record("Тот самый ужин который я оплатил за всех потому что платил картой", 600000));
        mData.add(new Record("", 0));
        mData.add(new Record("Тот самый ужин", 604));
        mData.add(new Record("ракета Falcon Heavy", 1));
        mData.add(new Record("Лего Тысячелетний сокол", 100000000));
        mData.add(new Record("Монитор", 100));
        mData.add(new Record("MacBook Pro", 100));
        mData.add(new Record("Шоколадка", 100));
        mData.add(new Record("Шкаф", 100));
        mData.add(new Record("Молоко", 35));
        mData.add(new Record("Жизнь", 1));
        mData.add(new Record("Курсы", 50));
        for (int i = 0; i < 15; i++) {
            mData.add(new Record("Продукт №" + i, (int)  (Math.random() * 1000)));
        }
    }

    @Override
    public String toString() {
        return "ItemListActivity{" +
                "mRecycleView=" + mRecycleView +
                ", mData=" + mData +
                ", mAdapter=" + mAdapter +
                '}';
    }

    private class ItemListAdapter extends RecyclerView.Adapter<RecordViewHolder> {

        @Override
        public RecordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Log.d(TAG, "onCreateViewHolder " + mRecycleView.getChildCount());
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_record, parent, false);
            return new RecordViewHolder(view);
        }

        @Override
        public void onBindViewHolder(RecordViewHolder holder, int position) {
            Log.d(TAG, "onBindViewHolder " + mRecycleView.getChildCount() + " " + position);
            Record record = mData.get(position);
            holder.applyData(record);
        }

        @Override
        public int getItemCount() {
            return mData.size();
        }
    }

    private class RecordViewHolder extends RecyclerView.ViewHolder {

        private final TextView title;
        private final TextView price;

        public RecordViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            price = itemView.findViewById(R.id.price);
        }

        public void applyData(Record record) {
            Log.d(TAG, "applyData " + mRecycleView.getChildLayoutPosition(itemView) + " " + record.getTitle());
            title.setText(record.getTitle());
            price.setText(String.valueOf(record.getPrice()));
        }
    }
}
