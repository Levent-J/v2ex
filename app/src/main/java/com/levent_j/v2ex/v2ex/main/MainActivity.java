package com.levent_j.v2ex.v2ex.main;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.levent_j.v2ex.R;
import com.levent_j.v2ex.base.BaseActivity;
import com.levent_j.v2ex.data.NodeModel;
import com.levent_j.v2ex.utils.MyLog;

import java.util.List;

public class MainActivity extends BaseActivity implements IMainView {

    private RecyclerView mNodeListView;

    private NodeListAdapter mNodeListAdapter;

    private MainPresenter mainPresenter;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }


    @Override
    protected void init() {
        mNodeListView = findViewById(R.id.rlv_node_list);


        mNodeListAdapter = new NodeListAdapter(this);

        mNodeListView.setLayoutManager(new LinearLayoutManager(this));
        mNodeListView.setAdapter(mNodeListAdapter);

        mainPresenter = new MainPresenter(this);

        addPresenter(mainPresenter);

        initData();
    }

    private void initData() {
        mainPresenter.loadNodeList();
    }

    @Override
    protected void setClickListener() {

    }


    @Override
    public void onGetNodeListSuccess(List<NodeModel> list) {
        mNodeListAdapter.addData(list);
    }

    @Override
    public void onGetNodeListFailed() {

    }
}
