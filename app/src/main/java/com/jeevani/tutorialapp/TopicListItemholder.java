package com.jeevani.tutorialapp;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Jeevani on 5/9/2017.
 */

public class TopicListItemholder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private GlobalUtils.ItemClikListener mListener;
    protected ImageView images;

    public TopicListItemholder(View itemView, GlobalUtils.ItemClikListener listener) {
        super(itemView);

        images = (ImageView) itemView.findViewById(R.id.images);
        /*add = (FloatingActionButton) itemView.findViewById(R.id.fab_add);
        if (add != null){
            add.setTag("add");
            add.setOnClickListener(this);
        }*/
        mListener = listener;
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
      /*  if (mListener != null) {
            if(v instanceof FloatingActionButton && v.getTag().equals("add") ) {
                mListener.onItemClick(v, GlobalUtils.TYPE_ADD, getAdapterPosition());
            }
            else {*/
        mListener.onItemClick(v, getItemViewType(), getAdapterPosition());
            /*}*/

    }

}
