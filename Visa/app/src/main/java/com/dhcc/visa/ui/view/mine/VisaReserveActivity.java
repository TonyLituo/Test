package com.dhcc.visa.ui.view.mine;

import android.support.annotation.NonNull;

import com.dhcc.visa.R;
import com.dhcc.visa.persenter.base.NullPersenter;
import com.dhcc.visa.ui.base.BaseActivity;
import com.dhcc.visa.ui.base.IBaseView;

public class VisaReserveActivity extends BaseActivity<IBaseView, NullPersenter> implements IBaseView {


    @NonNull
    @Override
    public NullPersenter createPresenter() {
        return new NullPersenter();
    }

    @Override
    public int getLayoutResID() {
        return R.layout.activity_visa_reserve;
    }

    @Override
    protected void initView() {

    }
}
