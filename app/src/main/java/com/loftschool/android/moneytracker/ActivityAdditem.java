package com.loftschool.android.moneytracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class ActivityAdditem extends AppCompatActivity {
    private static final String TAG = "ActivityAdditem";
    public static final String TYPE_KEY = "type";

    private EditText name;
    private EditText price;
    private Button addBtn;
    private String type;

    private boolean name_fill = false;
    private boolean price_fill = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_additem);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle(R.string.add_item_title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        name = findViewById(R.id.name);
        price = findViewById(R.id.price);
        addBtn = findViewById(R.id.add_btn);
        type = getIntent().getStringExtra(TYPE_KEY);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameValue = name.getText().toString();
                String priceValue = price.getText().toString();

                if (!nameValue.isEmpty() && !priceValue.isEmpty()) {
                    Item item = new Item(nameValue, priceValue, type);
                    Intent intent = new Intent();
                    intent.putExtra("item", item);
                    setResult(RESULT_OK, intent);
                    finish();
                }

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
