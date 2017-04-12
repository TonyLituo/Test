package com.dhcc.visa.ui.view.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dhcc.visa.R;
import com.dhcc.visa.persenter.CommonPresent;
import com.dhcc.visa.persenter.ExitKitsPersenter;
import com.dhcc.visa.ui.base.BaseActivity;
import com.dhcc.visa.ui.base.IBaseView;
import com.hannesdorfmann.mosby.mvp.MvpPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lenovo on 2017/4/11.
 */

public class CountryClassActivity extends BaseActivity<IBaseView, CommonPresent> implements IBaseView {
    @BindView(R.id.base_img_left)
    ImageView mBaseImgLeft;
    @BindView(R.id.base_toolbar_title)
    TextView mBaseToolbarTitle;

    @Override
    public int getLayoutResID() {
        return R.layout.activity_country;
    }

    @Override
    protected void initView() {
        mBaseToolbarTitle.setText("亚洲");

    }

    @NonNull
    @Override
    public CommonPresent createPresenter() {
        return new CommonPresent();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.base_img_left})
    public void onClick(View view){
        switch (view.getId()){
           case  R.id.base_img_left:
            finish();
            break;
        }
    }

}
