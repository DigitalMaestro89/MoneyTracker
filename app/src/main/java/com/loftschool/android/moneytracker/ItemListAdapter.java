package com.loftschool.android.moneytracker;

import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vlad on 16.03.2018.
 */
class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.ItemViewHolder> {
    private static final String TAG = "ItemListAdapter";
    List<Item> data = new ArrayList<>();
    private ItemsAdapterListener listener = null;

    public void setListener(ItemsAdapterListener listener) {
        this.listener = listener;
    }

    public void setData(List<Item> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public void addItem(Item item) {
        data.add(item);
        int position = data.indexOf(item);
        notifyItemInserted(position);
        notifyDataSetChanged();
    }

    @Override
    public ItemListAdapter.ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemListAdapter.ItemViewHolder holder, int position) {
        Item record = data.get(position);
        holder.bind(record, position, listener, selection.get(position, false));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    private SparseBooleanArray selection = new SparseBooleanArray();

    public void toggleSelection(int position) {
        if (selection.get(position, false)) {
            selection.delete(position);
        } else {
            selection.put(position, true);
        }
        notifyItemChanged(position);
    }

    void clearSelection() {
        selection.clear();
        notifyDataSetChanged();
    }

    int getSelectionItemCount() {
        return selection.size();
    }

    List<Integer> getSelectionItems() {
        List<Integer> items = new ArrayList<>(selection.size());
        for (int i = 0; i < selection.size(); i++) {
            items.add(selection.keyAt(i));
        }
        return items;
    }

    Item remove(int position) {
        final Item item = data.remove(position);
        notifyItemRemoved(position);
        return item;
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        private final TextView title;
        private final TextView price;

        public ItemViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            price = itemView.findViewById(R.id.price);
        }

        public void bind(final Item item, final int position, final ItemsAdapterListener listener, boolean selected) {
            title.setText(item.name);
            price.setText(item.price);

            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        listener.onItemClick(item, position);
                    }
                }
            });
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    if (listener != null) {
                        listener.onItemLongClick(item, position);
                    }
                    return true;
                }
            });
            itemView.setActivated(selected);
        }
    }
}
