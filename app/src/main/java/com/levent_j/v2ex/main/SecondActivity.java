package com.levent_j.v2ex.main;

import com.levent_j.v2ex.R;
import com.levent_j.v2ex.base.ActivityEvent;
import com.levent_j.v2ex.base.BaseActivity;
import com.levent_j.v2ex.utils.MyLog;

import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @auther : levent_j on 2018/2/1.
 * @desc :
 */

public class SecondActivity extends BaseActivity{
    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        Flowable.interval(1,1, TimeUnit.SECONDS)
                .compose(bindUntilEvent(ActivityEvent.DESTROY))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object o) throws Exception {
                        toast();
                    }
                });
    }

    private void toast() {
        MyLog.d("哇啦啦啦绿");
    }

    @Override
    protected void setClickListener() {

    }
}
