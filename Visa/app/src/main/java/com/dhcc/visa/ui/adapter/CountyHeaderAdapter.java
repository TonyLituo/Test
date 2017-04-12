package com.dhcc.visa.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.dhcc.visa.R;

import java.util.List;

/**
 * Created by m on 2017/4/10.
 * ${describe}
 */

public class CountyHeaderAdapter extends BaseAdapter {
    private Context mContext;
    private List<String> hotCounties;

    public CountyHeaderAdapter(Context context , List<String> counties) {
        this.mContext = context;
        this.hotCounties = counties;
    }

    @Override
    public int getCount() {
        if (hotCounties != null)
            return hotCounties.size();
        return 0;
    }

    @Override
    public Object getItem(int position) {
        if (hotCounties != null)
            hotCounties.get(position);
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_header,null,false);
            holder.tvHot = (TextView) convertView.findViewById(R.id.tv_hot_county);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tvHot.setText(hotCounties.get(position));
        return convertView;
    }

    private final class ViewHolder {
        TextView tvHot;
    }
}
