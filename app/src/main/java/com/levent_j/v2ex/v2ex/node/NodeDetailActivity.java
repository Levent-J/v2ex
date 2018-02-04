package com.levent_j.v2ex.v2ex.node;

import android.widget.Toast;

import com.levent_j.v2ex.R;
import com.levent_j.v2ex.base.BaseActivity;
import com.levent_j.v2ex.data.NodeDetailModel;
import com.levent_j.v2ex.utils.MyLog;

/**
 * @auther : levent_j on 2018/2/1.
 * @desc :
 */

public class NodeDetailActivity extends BaseActivity implements INodeView {

    private NodeDetailPresenter mNodeDetailPresenter;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_node_detail;
    }

    @Override
    protected void init() {
        mNodeDetailPresenter = new NodeDetailPresenter(this);

        initData();
    }

    private void initData() {
        mNodeDetailPresenter.loadNodeDetailData();
    }

    @Override
    protected void setClickListener() {

    }

    @Override
    public void onGetNodeDetailSuccess(NodeDetailModel data) {
        Toast.makeText(this,"hello world",Toast.LENGTH_LONG).show();
        MyLog.d("onGetNodeDetailSuccess");
    }

    @Override
    public void onGetNodeDetailFailed() {

    }
}
