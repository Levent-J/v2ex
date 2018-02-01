package com.levent_j.v2ex.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.levent_j.v2ex.R;
import com.levent_j.v2ex.utils.MyLog;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther : levent_j on 2018/2/1.
 * @desc :
 */

public abstract class BaseActivity extends RxActivity{

    private List<BasePresenter> mPresenters;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(setLayoutId());

        init();

        setClickListener();
    }

    //设置布局id
    protected abstract int setLayoutId();

    //初始化
    protected abstract void init();

    //设置监听器
    protected abstract void setClickListener();

    //添加presenter
    protected void addPresenter(BasePresenter presenter){
        if (mPresenters == null) {
            mPresenters = new ArrayList<>();
        }
        mPresenters.add(presenter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //依次销毁destroy
        if (mPresenters != null) {
            for (BasePresenter each : mPresenters) {
                each.onDestroy();
                MyLog.d("each.onDestroy");
            }
            mPresenters.clear();
        }

    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        overridePendingTransition(R.anim.slid_in_right,R.anim.animo_no);
    }

    @Override
    public void startActivity(Intent intent, @Nullable Bundle options) {
        super.startActivity(intent, options);
        overridePendingTransition(R.anim.slid_in_right,R.anim.animo_no);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(0,R.anim.slid_out_right);
    }


}
