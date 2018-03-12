package com.loftschool.android.moneytracker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

public class Activity_additem extends AppCompatActivity {
    private static final String TAG = "Activity_additem";
    private EditText name;
    private EditText price;
    private Button addBtn;
    private boolean name_fill = false;
    private boolean price_fill = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_additem);
        name = findViewById(R.id.name);
        price = findViewById(R.id.price);
        addBtn = findViewById(R.id.add_btn);

        name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                name_fill = !TextUtils.isEmpty(s);
                fillTxt();
            }
        });
        price.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                price_fill = !TextUtils.isEmpty(s);
                fillTxt();
            }
        });

    }

    protected void fillTxt() {
        if (name_fill && price_fill && true) {
            addBtn.setEnabled(true);
        } else addBtn.setEnabled(false);
    }
}
