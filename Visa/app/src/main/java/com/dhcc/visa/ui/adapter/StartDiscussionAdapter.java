package com.dhcc.visa.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SectionIndexer;
import android.widget.TextView;

import com.dhcc.visa.R;
import com.dhcc.visa.ui.widget.pinyin.Country;

import java.util.List;

/**
 * Created by m on 2017/4/10.
 * ${describe}
 */

public class StartDiscussionAdapter extends BaseAdapter implements SectionIndexer {

    private Context context;
    private List<Country> adapterList;

    public StartDiscussionAdapter(Context context, List<Country> list) {
        this.context = context;
        adapterList = list;
    }

    @Override
    public int getCount() {
        return adapterList == null ? 0 : adapterList.size();
    }

    @Override
    public Object getItem(int position) {
        return adapterList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("InflateParams")
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final ViewHolder viewHolder;
        final Country mContent = adapterList.get(position);
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_counties, null);
            viewHolder.tvTitle = (TextView) convertView.findViewById(R.id.counties_name);
            viewHolder.tvLetter = (TextView) convertView.findViewById(R.id.dis_catalog);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // 根据position获取分类的首字母的Char ascii值
        int section = getSectionForPosition(position);
        // 如果当前位置等于该分类首字母的Char的位置 ，则认为是第一次出现
        if (mContent != null) {
            if (position == getPositionForSection(section)) {
                viewHolder.tvLetter.setVisibility(View.VISIBLE);
                viewHolder.tvLetter.setText(mContent.getLetters());
            } else {
                viewHolder.tvLetter.setVisibility(View.GONE);
            }

            if (TextUtils.isEmpty(mContent.getDisplayName())) {
                viewHolder.tvTitle.setText(mContent.getName());
            } else {
                viewHolder.tvTitle.setText(mContent.getDisplayName());
            }
        }

        return convertView;
    }

    @Override
    public Object[] getSections() {
        return new Object[0];
    }

    /**
     * 根据分类的首字母的Char ascii值获取其第一次出现该首字母的位置
     */
    @Override
    public int getPositionForSection(int sectionIndex) {
        for (int i = 0; i < getCount(); i++) {
            String sortStr = adapterList.get(i).getLetters();
            char firstChar = sortStr.toUpperCase().charAt(0);
            if (firstChar == sectionIndex) {
                return i;
            }
        }

        return -1;
    }

    /**
     * 根据ListView的当前位置获取分类的首字母的Char ASCII
     */
    @SuppressLint("DefaultLocale")
    @Override
    public int getSectionForPosition(int position) {
        return adapterList.get(position).getLetters().charAt(0);
    }

    private final class ViewHolder {
        /**
         * 首字母
         */
        TextView tvLetter;
        /**
         * 城市名称
         */
        TextView tvTitle;

    }
}
