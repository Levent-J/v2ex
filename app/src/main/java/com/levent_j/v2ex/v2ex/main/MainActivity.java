package com.levent_j.v2ex.v2ex.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.levent_j.v2ex.R;
import com.levent_j.v2ex.base.BaseActivity;
import com.levent_j.v2ex.base.BasePresenter;
import com.levent_j.v2ex.data.bean.Node;
import com.levent_j.v2ex.utils.MyLog;

import java.util.List;

public class MainActivity extends BaseActivity implements IMainView {

    private Button button;
    private MainPresenter mainPresenter;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }


    @Override
    protected void init() {
        button = findViewById(R.id.btn_main);

        mainPresenter = new MainPresenter(this);

        addPresenter(mainPresenter);
    }

    @Override
    protected void setClickListener() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainPresenter.loadNodeList();
            }
        });
    }

    @Override
    public List<Node> onGetNodeListSuccess() {
        MyLog.d("onGetNodeListSuccess");
        return null;
    }

    @Override
    public void onGetNodeListFailed() {

    }
}
