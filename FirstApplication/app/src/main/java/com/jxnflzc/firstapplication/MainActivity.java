package com.jxnflzc.firstapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    private EditText mEdtAge;
    private Button mBtnSubmit, mBtnReset;
    private TextView mTxtResult;
    private Spinner mSpnSex;
    private String msSex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEdtAge = (EditText) findViewById(R.id.edtAge);//获取输入的年龄
        mBtnSubmit = (Button) findViewById(R.id.btnSubmit);//提交按钮
        mBtnReset = (Button) findViewById(R.id.btnReset);//重置按钮
        mTxtResult = (TextView) findViewById(R.id.txtResult);//结果显示
        mSpnSex = (Spinner) findViewById(R.id.spnSex);//性别选单
        mSpnSex.setOnItemSelectedListener(spnSexOnItemSelected);//获取性别监听器
        mBtnSubmit.setOnClickListener(btnSubmitOnClick);//提交按钮监听器
        mBtnReset.setOnClickListener(btnResetOnClick);//重置按钮监听器
    }

    private View.OnClickListener btnSubmitOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String strResult = getString(R.string.result);//显示结果
            if(TextUtils.isEmpty(mEdtAge.getText())){       //针对年龄输入为空的情况显示错误
                strResult += getString(R.string.wrong);
                mTxtResult.setText(strResult);
            } else {
                int iAge = Integer.parseInt(mEdtAge.getText().toString());

                if(msSex.equals(getString(R.string.sex_male))){         //当性别为“男”时
                    if(iAge <= 0)
                        strResult += getString(R.string.wrong);
                    else if(iAge < 28)
                        strResult += getString(R.string.sug_not_hurry);
                    else if(iAge > 33)
                        strResult += getString(R.string.sug_get_married);
                    else
                        strResult += getString(R.string.sug_find_couple);
                } else {        //当性别为“女”时
                    if(iAge <= 0)
                        strResult += getString(R.string.wrong);
                    else if(iAge < 25)
                        strResult += getString(R.string.sug_not_hurry);
                    else if(iAge > 30)
                        strResult += getString(R.string.sug_get_married);
                    else
                        strResult += getString(R.string.sug_find_couple);
                }

                mTxtResult.setText(strResult);
            }
        }
    };

    private View.OnClickListener btnResetOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String strResult = getString(R.string.result);
            mTxtResult.setText(strResult);
            mEdtAge.setText("");//重置按钮清空年龄
        }
    };

    private AdapterView.OnItemSelectedListener spnSexOnItemSelected = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView parent, View v, int position, long id){
            msSex = parent.getSelectedItem().toString();//获取选择的性别
        }
        public void onNothingSelected(AdapterView parent){
        }
    };
}
