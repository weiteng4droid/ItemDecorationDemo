package me.weiteng.itemdecorationdemo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by weiTeng on 2018/3/2
 */
public class DemoViewHolder extends RecyclerView.ViewHolder {

    public TextView nameLabel;
    public ImageView icon;

    public DemoViewHolder(View itemView) {
        super(itemView);

        nameLabel = (TextView) itemView.findViewById(R.id.name_label);
        icon = (ImageView) itemView.findViewById(R.id.demo_iv);
    }
}
