package com.dhcc.visa.ui.view.user.forgetpwd;

import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dhcc.visa.R;
import com.dhcc.visa.persenter.ForgetPwdPresenter;
import com.dhcc.visa.ui.base.BaseActivity;
import com.dhcc.visa.ui.base.IBaseView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by m on 2017/4/10.
 * ${describe}
 */

public class ForgetPwdThreeActivity extends BaseActivity<IBaseView, ForgetPwdPresenter>  implements IBaseView{
    @BindView(R.id.toolbar)
    Toolbar mToolbar;    @BindView(R.id.base_img_left)

    ImageView mIvBack;
    @BindView(R.id.base_toolbar_title)
    TextView mTvTitle;

    @BindView(R.id.tv_first_step)
    TextView first_step;

    @BindView(R.id.tv_second_step)
    TextView second_step;

    @BindView(R.id.tv_three_step)
    TextView three_step;
    @Override
    public int getLayoutResID() {
        return R.layout.activity_forget_pwd_three;
    }

    @Override
    protected void initView() {
        mTvTitle.setText("完成");
        first_step.setText("手机验证");
        second_step.setText("重置密码");
        three_step.setText("完成");
    }

    @NonNull
    @Override
    public ForgetPwdPresenter createPresenter() {
        return new ForgetPwdPresenter();
    }

    @OnClick({R.id.btn_complete , R.id.btn_login , R.id.base_img_left})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_complete:
                this.finish();
                break;
            case R.id.base_img_left:
                this.finish();
                break;
            case R.id.btn_login:
                this.finish();
                break;
        }
    }
}
