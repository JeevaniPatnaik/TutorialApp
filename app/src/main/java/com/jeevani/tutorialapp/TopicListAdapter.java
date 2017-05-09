package com.jeevani.tutorialapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Jeevani on 5/9/2017.
 */

public class TopicListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private GlobalUtils.ItemClikListener mItemClikListener;

    private final Context context;

    private final Integer[] images;
    public TopicListAdapter(Context mContext,Integer[] images) {
        this.context = mContext;
        this.images = images;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_topic_list, parent, false);

        TopicListItemholder vh = new TopicListItemholder(v, mItemClikListener);

        return vh;

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof TopicListItemholder) {

            ((TopicListItemholder) holder).images.setBackgroundResource(images[position]);

        }
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public void setOnItemClikListener(GlobalUtils.ItemClikListener listener) {
        this.mItemClikListener = listener;
    }
}
