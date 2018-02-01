package com.levent_j.v2ex.v2ex.main;

import com.levent_j.v2ex.data.bean.Node;

import java.util.List;

/**
 * @auther : levent_j on 2018/2/1.
 * @desc :
 */

public interface IMainView {
    List<Node> onGetNodeListSuccess();

    void onGetNodeListFailed();
}
