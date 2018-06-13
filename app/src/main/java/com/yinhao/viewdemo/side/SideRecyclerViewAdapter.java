package com.yinhao.viewdemo.side;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.ArrayMap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yinhao.viewdemo.R;

import java.util.List;

public class SideRecyclerViewAdapter extends RecyclerView.Adapter<SideRecyclerViewAdapter.ViewHolder> {
    private List<Contant> mContantList;
    private Context mContext;
    private ArrayMap<String, Integer> mLetters;

    public SideRecyclerViewAdapter(List<Contant> contants, Context context, ArrayMap<String, Integer> letters) {
        this.mContantList = contants;
        this.mContext = context;
        this.mLetters = letters;
    }

    @Override
    public int getItemViewType(int position) {
        //根据每个字母下第一个联系人在数据中的位置，来显示headView
        Contant contant = mContantList.get(position);
        if (mLetters.get(contant.getFirstChar()) == position) {
            return 1;
        }
        return 0;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        if (viewType == 1) {
            return new ViewHolder(parent, inflater, true);
        } else {
            return new ViewHolder(parent, inflater, false);
        }
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tv_name.setText(mContantList.get(position).getName());
        holder.tv_head.setText(mContantList.get(position).getFirstChar());
    }

    @Override
    public int getItemCount() {
        return mContantList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_head;
        TextView tv_name;

        public ViewHolder(ViewGroup parent, LayoutInflater inflater, boolean displayHead) {
            super(inflater.inflate(R.layout.itme_side_list, parent, false));
            tv_head = (TextView) itemView.findViewById(R.id.tv_head);
            tv_name = (TextView) itemView.findViewById(R.id.tv_name);
            if (displayHead) {
                tv_head.setVisibility(View.VISIBLE);
            } else {
                tv_head.setVisibility(View.GONE);
            }
        }
    }
}
