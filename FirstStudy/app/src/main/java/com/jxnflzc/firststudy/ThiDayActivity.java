package com.jxnflzc.firststudy;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.*;
import android.view.*;

public class ThiDayActivity extends AppCompatActivity {
    private Button thiBtnSub;
    private EditText thiEdtName, thiEdtAge;
    private SharedPreferences thiPref;
    private SharedPreferences.Editor thiEdt;
    private CheckBox thiRemberInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thi_day);
        getSupportActionBar().hide();

        thiBtnSub = (Button)findViewById(R.id.btn_sub_info);
        thiEdtName = (EditText)findViewById(R.id.enter_name);
        thiEdtAge = (EditText)findViewById(R.id.enter_age);
        thiRemberInfo = (CheckBox)findViewById(R.id.remner_info);

        thiPref = PreferenceManager.getDefaultSharedPreferences(this);

        boolean isRemember = thiPref.getBoolean("remember_info", false);
        if(isRemember){
            String name = thiPref.getString("name", "");
            String age = thiPref.getString("age","");
            thiEdtName.setText(name);
            thiEdtAge.setText(age);
            thiRemberInfo.setChecked(true);
        }

        thiBtnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user_name;
                String user_age = thiEdtAge.getText().toString();

                if(TextUtils.isEmpty(thiEdtName.getText())){     //排除名字输入为空
                    user_name = "NULL";
                } else {
                    user_name = thiEdtName.getText().toString();
                }
                if(TextUtils.isEmpty(thiEdtAge.getText())){     //排除年龄输入为空
                    user_age = "NULL";
                } else {
                    user_age = thiEdtAge.getText().toString();
                }

                thiEdt = thiPref.edit();
                if(thiRemberInfo.isChecked()){
                    thiEdt.putBoolean("remember_info", true);
                    thiEdt.putString("name", user_name);
                    thiEdt.putString("age", user_age);
                } else{
                    thiEdt.clear();
                }
                thiEdt.apply();

                Intent goBack = new Intent(ThiDayActivity.this, MainActivity.class);//跳转到"第三天"界面
                startActivity(goBack);
            }
        });
    }

}
