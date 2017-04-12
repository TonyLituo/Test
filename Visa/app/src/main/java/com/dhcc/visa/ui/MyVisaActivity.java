package com.dhcc.visa.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dhcc.visa.R;
import com.dhcc.visa.persenter.RegisterPresenter;
import com.dhcc.visa.ui.base.BaseActivity;
import com.hannesdorfmann.mosby.mvp.MvpPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lenovo on 2017/4/11.
 */

public class MyVisaActivity extends BaseActivity{
    @BindView(R.id.base_img_left)
    ImageView mBaseImgLeft;
    @BindView(R.id.base_toolbar_title)
    TextView mBaseToolbarTitle;

    @Override
    public int getLayoutResID() {
        return R.layout.activity_my_visa;
    }

    @Override
    protected void initView() {
        mBaseToolbarTitle.setText("我的签证");
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @NonNull
    @Override
    public MvpPresenter createPresenter() {
        return new RegisterPresenter();
    }

    @OnClick({R.id.base_img_left})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.base_img_left:
                finish();
                break;
        }
    }

}
