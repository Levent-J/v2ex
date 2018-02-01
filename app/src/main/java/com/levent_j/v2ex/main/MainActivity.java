package com.levent_j.v2ex.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.levent_j.v2ex.R;
import com.levent_j.v2ex.base.BaseActivity;

public class MainActivity extends BaseActivity {

    private Button button;


    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }


    @Override
    protected void init() {
        button=findViewById(R.id.btn_main);
    }

    @Override
    protected void setClickListener() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SecondActivity.class));
            }
        });
    }
}
