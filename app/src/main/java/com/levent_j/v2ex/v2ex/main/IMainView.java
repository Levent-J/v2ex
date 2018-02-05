package com.levent_j.v2ex.v2ex.main;

import com.levent_j.v2ex.data.NodeModel;
import com.levent_j.v2ex.data.RootModel;

import java.util.List;

/**
 * @auther : levent_j on 2018/2/1.
 * @desc :
 */

public interface IMainView {
    void onGetNodeListSuccess(List<RootModel> list);

    void onGetNodeListFailed();
}
