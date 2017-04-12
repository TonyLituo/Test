package com.dhcc.visa.ui.view.user.register;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.dhcc.visa.R;
import com.dhcc.visa.common.router.Router;
import com.dhcc.visa.persenter.RegisterPresenter;
import com.dhcc.visa.ui.base.BaseActivity;
import com.hannesdorfmann.mosby.mvp.MvpPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lenovo on 2017/4/11.
 */

public class SecondRegisterActivity extends BaseActivity {
    @BindView(R.id.base_img_left)
    ImageView mBaseImgLeft;
    @BindView(R.id.base_toolbar_title)
    TextView mBaseToolbarTitle;
    @BindView(R.id.btn_next)
    Button mBtnNext;

    @Override
    public int getLayoutResID() {
        return R.layout.activity_register_step_two;
    }

    @Override
    protected void initView() {
        mBaseToolbarTitle.setText("绑定银行卡");
    }

    @NonNull
    @Override
    public MvpPresenter createPresenter() {
        return new RegisterPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_next,R.id.base_img_left})
    public void OnClick(View v){
        switch (v.getId()) {
            case R.id.base_img_left:
                this.finish();
                break;
            case R.id.btn_next:
                Router.newIntent(this).to(ThirdRegisterActivity.class).launch();
                break;
        }

    }
}
