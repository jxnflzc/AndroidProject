package com.jxnflzc.firststudy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListViewTestActivity extends AppCompatActivity {
    private String[] fruits = {"Apple", "Banana", "Orange", "Watermelon", "Pear", "Pineapple", "Strawberry", "Cherry", "Mango",
            "Apple", "Banana", "Orange", "Watermelon", "Pear", "Pineapple", "Strawberry", "Cherry", "Mango",};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_test);
        getSupportActionBar().hide();

        ArrayAdapter<String> fruits_adapter = new ArrayAdapter<String>(
                ListViewTestActivity.this, android.R.layout.simple_list_item_1, fruits);
        ListView listView_test = (ListView) findViewById(R.id.list_view_item);
        listView_test.setAdapter(fruits_adapter);
    }
}
