package com.levent_j.v2ex.v2ex.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.levent_j.v2ex.R;
import com.levent_j.v2ex.data.NodeModel;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther : levent_j on 2018/2/4.
 * @desc :
 */

public class NodeListAdapter extends RecyclerView.Adapter<NodeListAdapter.Node>{

    private List<NodeModel> mDataSource;

    private Context mContext;

    public NodeListAdapter(Context context) {
        mContext = context;
        this.mDataSource = new ArrayList<>();
    }

    public void addData(List<NodeModel> list){
        mDataSource.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public Node onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.item_node_list,parent,false);
        return new Node(view);
    }

    @Override
    public void onBindViewHolder(Node holder, int position) {
        holder.bindData(mDataSource.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataSource.size();
    }

    class Node extends RecyclerView.ViewHolder {

        private TextView textView;

        public Node(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_node);
        }

        public void bindData(NodeModel data){
            textView.setText("hello world");
        }
    }
}
