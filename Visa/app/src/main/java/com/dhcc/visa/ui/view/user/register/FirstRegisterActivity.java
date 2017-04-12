package com.dhcc.visa.ui.view.user.register;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.dhcc.visa.R;
import com.dhcc.visa.common.router.Router;
import com.dhcc.visa.persenter.RegisterPresenter;
import com.dhcc.visa.ui.base.BaseActivity;
import com.dhcc.visa.ui.base.IBaseNetView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/4/10.
 */

public class FirstRegisterActivity extends BaseActivity<IBaseNetView, RegisterPresenter> {

    @BindView(R.id.base_img_left)
    ImageView mIvBack;
    @BindView(R.id.base_toolbar_title)
    TextView mTvTitle;
    @BindView(R.id.base_tool_right)
    ImageView mBaseToolRight;
    @BindView(R.id.btn_next)
    Button mBtnNext;


    @Override
    public int getLayoutResID() {
        return R.layout.activity_register_step_one;
    }

    @Override
    protected void initView() {
        mTvTitle.setText(R.string.register);
    }

    @NonNull
    @Override
    public RegisterPresenter createPresenter() {
        return new RegisterPresenter();
    }


    @OnClick({R.id.btn_next, R.id.base_img_left})
    public void OnClick(View v) {
        switch (v.getId()) {
            case R.id.base_img_left:
                this.finish();
                break;
            case R.id.btn_next:
                Router.newIntent(this).to(SecondRegisterActivity.class).launch();
                break;
        }

    }
}
