package com.lc.licongqimo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lc.licongqimo.R;
import com.lc.licongqimo.bean.StoryBean;

import java.util.List;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.ViewHolder> {
    private Context context;
    private List<StoryBean.ResultBean.DataBean> list;

    public StoryAdapter(Context context, List<StoryBean.ResultBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_story, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        StoryBean.ResultBean.DataBean dataBean = list.get(position);
        holder.tv_title.setText(dataBean.getTitle());
        holder.tv_author_name.setText(dataBean.getAuthor_name());
        holder.tv_category.setText(dataBean.getCategory());
        Glide.with(context).load(dataBean.getThumbnail_pic_s()).into(holder.iv);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView iv;
        private final TextView tv_title;
        private final TextView tv_author_name;
        private final TextView tv_category;

        public ViewHolder(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_author_name = itemView.findViewById(R.id.tv_author_name);
            tv_category = itemView.findViewById(R.id.tv_category);

        }
    }
}
