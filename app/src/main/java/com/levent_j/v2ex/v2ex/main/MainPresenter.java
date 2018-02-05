package com.levent_j.v2ex.v2ex.main;

import com.levent_j.v2ex.base.ActivityEvent;
import com.levent_j.v2ex.base.BasePresenter;
import com.levent_j.v2ex.data.NodeModel;
import com.levent_j.v2ex.data.RootModel;
import com.levent_j.v2ex.net.ApiService;
import com.levent_j.v2ex.utils.MyLog;

import java.lang.ref.WeakReference;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @auther : levent_j on 2018/2/1.
 * @desc :
 */

public class MainPresenter extends BasePresenter {

    private WeakReference<IMainView> mViewRef;

    public MainPresenter(IMainView mViewRef) {
        this.mViewRef = new WeakReference(mViewRef);
    }

    protected void loadNodeList() {
        MyLog.d("loadNodeList");
        if (mViewRef == null || mViewRef.get() == null) {
            return;
        }
        ApiService.getInstance()
                .getNodeList()
                .compose(((MainActivity) mViewRef.get()).bindUntilEvent(ActivityEvent.DESTROY))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object o) throws Exception {
                        List<RootModel> result = (List<RootModel>) o;

                        if (mViewRef != null && mViewRef.get()!=null) {
                            mViewRef.get().onGetNodeListSuccess(result);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        throwable.printStackTrace();
                    }
                });
    }

    @Override
    protected void onDestroy() {
        mViewRef.clear();
        MyLog.d("clear");
    }
}
