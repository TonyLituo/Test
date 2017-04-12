package com.dhcc.visa.ui.view.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
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

public class SearchActivity extends BaseActivity {
    @BindView(R.id.back)
    TextView mBack;

    @Override
    public int getLayoutResID() {
        return R.layout.activity_search;
    }

    @Override
    protected void initView() {

    }

    @NonNull
    @Override
    public MvpPresenter createPresenter() {
        return new RegisterPresenter();
    }

    @OnClick({R.id.back})
    public void OnClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                this.finish();
                break;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
