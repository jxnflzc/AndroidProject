package com.jxnflzc.firststudy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.view.*;
import android.content.*;

public class FirDayActivity extends AppCompatActivity {
    private Button firToastLong, firToastShort, firListViewTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fir_day);
        getSupportActionBar().hide();

        firToastLong = (Button)findViewById(R.id.btn_toast_long);
        firToastShort = (Button)findViewById(R.id.btn_toast_short);
        firListViewTest = (Button)findViewById(R.id.btn_list_view_test);

        firToastLong.setOnClickListener(new View.OnClickListener() {        //ToastLong按钮点击效果
            @Override
            public void onClick(View v) {
                Toast.makeText(FirDayActivity.this, "You click the LONG button!", Toast.LENGTH_LONG).show();
            }
        });
        firToastShort.setOnClickListener(new View.OnClickListener() {        //ToastShort按钮点击效果
            @Override
            public void onClick(View v) {
                Toast.makeText(FirDayActivity.this, "You click the SHORT button!", Toast.LENGTH_SHORT).show();
            }
        });
        firListViewTest.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent gotoListViewTestActivity = new Intent(FirDayActivity.this, ListViewTestActivity.class);//转到"ListView Test"界面
                startActivity(gotoListViewTestActivity);
            }
        });
    }
}
