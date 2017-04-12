package com.dhcc.visa.ui.view.home;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dhcc.visa.R;
import com.dhcc.visa.persenter.ExitKitsPersenter;
import com.dhcc.visa.ui.base.BaseActivity;
import com.dhcc.visa.ui.base.IBaseView;
import com.dhcc.visa.ui.view.mine.VisaSenseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by lenovo on 2017/4/10.
 */

public class ExitKitsActivity extends BaseActivity<IBaseView, ExitKitsPersenter> implements IBaseView {

    @BindView(R.id.base_img_left)
    ImageView mBaseImgLeft;
    @BindView(R.id.base_toolbar_title)
    TextView mBaseToolbarTitle;

    @Override
    public int getLayoutResID() {
        return R.layout.activity_exit_kits;
    }

    @Override
    protected void initView() {
        mBaseToolbarTitle.setText("出境锦囊");
    }

    @OnClick(R.id.ll_exit_tips)
    public void StartToInfo(){
        mActivityUtils.startActivity(VisaSenseActivity.class);
    }

    @NonNull
    @Override
    public ExitKitsPersenter createPresenter() {
        return new ExitKitsPersenter();
    }

    @OnClick({ R.id.base_img_left})
    public void OnClick(View v) {
        switch (v.getId()) {
            case R.id.base_img_left:
                this.finish();
                break;

        }

    }
}