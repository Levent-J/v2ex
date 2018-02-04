package com.levent_j.v2ex.v2ex.node;

import com.levent_j.v2ex.base.ActivityEvent;
import com.levent_j.v2ex.base.BasePresenter;
import com.levent_j.v2ex.data.NodeDetailModel;
import com.levent_j.v2ex.net.ApiService;
import com.levent_j.v2ex.utils.MyLog;

import java.lang.ref.WeakReference;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @auther : levent_j on 2018/2/4.
 * @desc :
 */

public class NodeDetailPresenter extends BasePresenter{

    private WeakReference<INodeView> mViewRef;

    public NodeDetailPresenter(INodeView view) {
        mViewRef = new WeakReference<INodeView>(view);
    }

    public void loadNodeDetailData(){
        if (mViewRef == null || mViewRef.get()==null) {
            return;
        }

        ApiService.getInstance()
                .getNodeDetail()
                .compose(((NodeDetailActivity) mViewRef.get()).bindUntilEvent(ActivityEvent.DESTROY))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object o) throws Exception {
                        MyLog.d("loadNodeDetailData accept");
                        NodeDetailModel data = (NodeDetailModel) o;

                        if (mViewRef != null && mViewRef.get()!=null) {
                            mViewRef.get().onGetNodeDetailSuccess(data);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        MyLog.d("loadNodeDetailData accept");
                    }
                });
    }

    @Override
    protected void onDestroy() {

    }
}
