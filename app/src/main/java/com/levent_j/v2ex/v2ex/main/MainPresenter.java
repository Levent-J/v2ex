package com.levent_j.v2ex.v2ex.main;

import com.levent_j.v2ex.base.BasePresenter;
import com.levent_j.v2ex.utils.MyLog;

import java.lang.ref.WeakReference;

/**
 * @auther : levent_j on 2018/2/1.
 * @desc :
 */

public class MainPresenter extends BasePresenter{

    private WeakReference<IMainView> mViewRef;

    public MainPresenter(IMainView mViewRef) {
        this.mViewRef = new WeakReference(mViewRef);
    }

    protected void loadNodeList(){
        MyLog.d("loadNodeList");
        if (mViewRef != null&& mViewRef.get()!=null) {
            mViewRef.get().onGetNodeListSuccess();
        }
    }

    @Override
    protected void onDestroy() {
        mViewRef.clear();
        MyLog.d("clear");
    }
}
