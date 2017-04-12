package com.dhcc.visa.ui.view.user;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.dhcc.visa.R;
import com.dhcc.visa.persenter.SettingPersenter;
import com.dhcc.visa.ui.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class SettingActivity extends BaseActivity<ISettingView, SettingPersenter> implements ISettingView {


    @BindView(R.id.base_img_left)
    ImageView mBaseImgLeft;
    @BindView(R.id.base_toolbar_title)
    TextView mBaseToolbarTitle;
    @BindView(R.id.tv_about)
    TextView mTvAbout;
    @BindView(R.id.tv_serive)
    TextView mTvSerive;
    @BindView(R.id.tv_tel)
    TextView mTvTel;
    @BindView(R.id.tv_check_update)
    TextView mTvCheckUpdate;
    @BindView(R.id.btn_exit_login)
    Button mBtnExitLogin;

    @NonNull
    @Override
    public SettingPersenter createPresenter() {
        return new SettingPersenter();
    }

    @Override
    public int getLayoutResID() {
        return R.layout.activity_setting;
    }

    @Override
    protected void initView() {
        mBaseToolbarTitle.setText(getResources().getString(R.string.setting_title));
    }

    @Override
    public void setToolBar() {

    }


    @OnClick({R.id.tv_about, R.id.tv_serive, R.id.tv_tel, R.id.tv_check_update, R.id.btn_exit_login, R.id.base_img_left})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_about:
                break;
            case R.id.tv_serive:
                break;
            case R.id.tv_tel:
                break;
            case R.id.tv_check_update:
                break;
            case R.id.btn_exit_login:
                break;
            case R.id.base_img_left:
                this.finish();
                break;

        }
    }
}
