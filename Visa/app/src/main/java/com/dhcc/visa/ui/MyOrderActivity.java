package com.dhcc.visa.ui;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dhcc.visa.R;
import com.dhcc.visa.persenter.CommonPresent;
import com.dhcc.visa.ui.base.BaseActivity;
import com.dhcc.visa.ui.base.IBaseView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by lenovo on 2017/4/11.
 */

public class MyOrderActivity extends BaseActivity <IBaseView, CommonPresent> implements IBaseView{
    @BindView(R.id.base_img_left)
    ImageView mBaseImgLeft;
    @BindView(R.id.base_toolbar_title)
    TextView mBaseToolbarTitle;

    @Override
    public int getLayoutResID() {
        return R.layout.activity_my_order;
    }

    @Override
    protected void initView() {
        mBaseToolbarTitle.setText("我的订单");
    }


    @OnClick({R.id.base_img_left})
    public void OnClick(View v) {
        switch (v.getId()) {
            case R.id.base_img_left:
                this.finish();
                break;
        }

    }

    @NonNull
    @Override
    public CommonPresent createPresenter() {
        return new CommonPresent();
    }
}
