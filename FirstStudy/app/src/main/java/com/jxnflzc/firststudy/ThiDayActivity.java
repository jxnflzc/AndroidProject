package com.jxnflzc.firststudy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;

public class ThiDayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thi_day);
        getSupportActionBar().hide();

    }
}
