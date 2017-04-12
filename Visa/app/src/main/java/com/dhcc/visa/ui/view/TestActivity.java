package com.dhcc.visa.ui.view;

import android.support.annotation.NonNull;
import android.widget.Button;

import com.dhcc.visa.R;
import com.dhcc.visa.persenter.LoginPersenter;
import com.dhcc.visa.ui.base.BaseNetActivity;
import com.dhcc.visa.ui.view.user.login.ILoginView;

import butterknife.BindView;

public class TestActivity
        extends BaseNetActivity<ILoginView, LoginPersenter>
        implements ILoginView {


    @BindView(R.id.btn_login)
    Button mBtnLogin;




    @Override
    public int getLayoutResID() {
        return R.layout.activity_test;
    }

    @Override
    protected void initView() {

    }

    @Override
    public void succeed(String strJson) {

    }

    @NonNull
    @Override
    public LoginPersenter createPresenter() {
        return new LoginPersenter();
    }


}
