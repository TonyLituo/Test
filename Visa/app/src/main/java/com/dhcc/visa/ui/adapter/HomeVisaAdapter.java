package com.dhcc.visa.ui.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.dhcc.visa.R;
import com.dhcc.visa.model.bean.HomeVisa;

import java.util.List;

/**
 * Created by Administrator on 2017/4/11.
 */

public class HomeVisaAdapter extends BaseQuickAdapter<HomeVisa, BaseViewHolder> {
    public HomeVisaAdapter(int layoutResId, List data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeVisa item) {
        helper.setText(R.id.text, item.getTitle());
        helper.setImageResource(R.id.icon, item.getImageResource());
    }
}
