package com.loftschool.android.moneytracker;

/**
 * Created by TVV on 14.03.2018.
 */

public class Record {

    public static final String TYPE_UNKNOWN = "unknown";
    public static final String TYPE_INCOMES = "incomes";
    public static final String TYPE_EXPENSES = "expenses";

    public int id;
    public String name;
    public int price;
    public String type;

    public Record(String name, int price, String type) {

        this.name = name;
        this.price = price;
        this.type = type;
    }
}
