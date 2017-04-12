package com.dhcc.visa.ui.view.home;

import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
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
 * Created by m on 2017/4/11.
 * ${describe}
 */

public class UploadDataActivity extends BaseActivity<IBaseView , CommonPresent> implements IBaseView{

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.base_img_left)
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
        return R.layout.activity_upload_layout;
    }

    @Override
    protected void initView() {
        mTvTitle.setText("上传资料");
        first_step.setText("资料上传");
        second_step.setText("填申请表");
        three_step.setText("订单确认");
    }

    @NonNull
    @Override
    public CommonPresent createPresenter() {
        return new CommonPresent();
    }

    @OnClick({R.id.base_img_left , R.id.upload_rl})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.base_img_left:
                this.finish();
                break;
            case R.id.upload_rl:
                this.finish();
                break;
        }

    }
}
