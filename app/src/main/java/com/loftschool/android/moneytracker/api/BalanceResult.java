package com.loftschool.android.moneytracker.api;

import com.google.gson.annotations.SerializedName;
/**
 * Created by Vlad on 29.03.2018.
 */

public class BalanceResult {
    public String status;
    @SerializedName("total_expenses")
    public int expense;
    @SerializedName("total_income")
    public int income;
}
