package com.loftschool.android.moneytracker;

/**
 * Created by Vlad on 24.03.2018.
 */

public interface ItemsAdapterListener {
    void onItemClick(Item item, int position);

    void onItemLongClick(Item item, int position);
}
