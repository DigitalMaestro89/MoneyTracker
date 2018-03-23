package com.loftschool.android.moneytracker;

import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vlad on 16.03.2018.
 */
class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.ItemsViewHolder> {
    private static final String TAG = "ItemListAdapter";
    List<Item> data = new ArrayList<>();
    private ItemAdapterListener listener = null;

    public void setListener(ItemAdapterListener listener){
        this.listener = listener;
    }

    public void setData(List<Item> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public void addItem(Item item) {
        data.add(0, item);
        notifyItemInserted(0);
    }

    @Override
    public ItemListAdapter.ItemsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View view = inflater.inflate(R.layout.item, parent, false);
        return new ItemsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemListAdapter.ItemsViewHolder holder, int position) {
        Item item = data.get(position);
        holder.bind(item, position, listener, selection.get(position, false));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    private SparseBooleanArray selection = new SparseBooleanArray();

    public void toggleSelection(int position){
        if(selection.get(position, false)){
            selection.delete(position);
        }else {
            selection.put(position, true);
        }
    }

    void clearSelection(){
        selection.clear();
        notifyDataSetChanged();
    }

    int getSelectionItemCount(){
        return selection.size();
    }
    List<Integer> getSelectionItems(){
        List<Integer> items = new ArrayList<>();
        for (int i = 0; i < selection.size(); i++) {
            items.add(selection.keyAt(i));
        }
        return items;
    }

    Item remove(int position){
        final  Item item = data.remove(position);
        notifyItemRemoved(position);
        return item;
    }

    static class ItemsViewHolder extends RecyclerView.ViewHolder {
        private final TextView title;
        private final TextView price;

        public ItemsViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            price = itemView.findViewById(R.id.price);
        }

        public void bind(final Item item, final int position, final ItemAdapterListener listener, boolean selectrd) {
            title.setText(item.name);
            price.setText(item.price);

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    if (listener != null){
                        listener.onItemLongClick(item, position);
                    }
                    return true;
                }
            });
            itemView.setActivated(selectrd);
        }
    }
}
