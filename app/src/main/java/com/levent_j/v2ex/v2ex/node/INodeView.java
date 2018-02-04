package com.levent_j.v2ex.v2ex.node;

import com.levent_j.v2ex.data.NodeDetailModel;

import java.util.List;

/**
 * @auther : levent_j on 2018/2/4.
 * @desc :
 */

public interface INodeView {
    void onGetNodeDetailSuccess(NodeDetailModel data);
    void onGetNodeDetailFailed();
}
