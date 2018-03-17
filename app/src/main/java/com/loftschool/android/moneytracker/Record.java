package com.loftschool.android.moneytracker;

/**
 * Created by TVV on 14.03.2018.
 */

public class Record {

    private final String name;
    private final int price;
    private String comment;

    public Record(String title, int price) {
        this.name = title;
        this.price = price;
    }

    public String getTitle() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getComment() {
        return comment;
    }
}
