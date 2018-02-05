package com.levent_j.v2ex.v2ex.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.levent_j.v2ex.R;
import com.levent_j.v2ex.data.NodeModel;
import com.levent_j.v2ex.data.RootModel;
import com.levent_j.v2ex.utils.DateUtil;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @auther : levent_j on 2018/2/4.
 * @desc :
 */

public class NodeListAdapter extends RecyclerView.Adapter<NodeListAdapter.Node> {

    private List<RootModel> mDataSource;

    private Context mContext;

    private ItemClickListener mItemClickListener;

    public NodeListAdapter(Context context) {
        mContext = context;
        this.mDataSource = new ArrayList<>();
    }

    public void addData(List<RootModel> list) {
        mDataSource.addAll(list);
        notifyDataSetChanged();
    }

    public void setItemClickListener(ItemClickListener clickListener) {
        mItemClickListener = clickListener;
    }

    @Override
    public Node onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.item_node_list, parent, false);
        return new Node(view);
    }

    @Override
    public void onBindViewHolder(Node holder, int position) {

        final RootModel nodeModel = mDataSource.get(position);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mItemClickListener.onClick(nodeModel);
            }
        });
        holder.bindData(nodeModel);
    }

    @Override
    public int getItemCount() {
        return mDataSource.size();
    }

    public interface ItemClickListener {
        void onClick(RootModel model);
    }

    class Node extends RecyclerView.ViewHolder {

        private TextView title;
        private TextView node;
        private TextView username;
        private TextView content;
        private TextView replies;
        private TextView date;
        private ImageView nodeAvatar;
        private ImageView userAvatar;


        public Node(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_root_title);
            node = itemView.findViewById(R.id.tv_root_node);
            nodeAvatar = itemView.findViewById(R.id.iv_root_node_avatar);
            userAvatar = itemView.findViewById(R.id.iv_root_user_avatar);
            username = itemView.findViewById(R.id.tv_root_username);
            content = itemView.findViewById(R.id.tv_root_content);
            replies = itemView.findViewById(R.id.tv_root_replies);
            date = itemView.findViewById(R.id.tv_root_time);

        }

        public void bindData(RootModel data) {
            title.setText(data.getTitle());
            node.setText(data.getNode().getTitle());
            username.setText(data.getMember().getUsername());
            content.setText(data.getContent());
            replies.setText("回复数：" + data.getReplies());
            date.setText("时间" + DateUtil.Long2String(data.getCreated()));
            Picasso.with(mContext).load("http:" + data.getNode().getAvatar_normal()).into(nodeAvatar);
            Picasso.with(mContext).load("http:" + data.getMember().getAvatar_normal()).into(userAvatar);
        }

    }
}
