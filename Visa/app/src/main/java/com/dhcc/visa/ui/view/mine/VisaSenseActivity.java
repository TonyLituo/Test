package com.dhcc.visa.ui.view.mine;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.dhcc.visa.R;
import com.dhcc.visa.persenter.base.NullPersenter;
import com.dhcc.visa.ui.base.BaseActivity;
import com.dhcc.visa.ui.base.IBaseView;

import butterknife.BindView;
import butterknife.OnClick;

public class VisaSenseActivity extends BaseActivity<IBaseView, NullPersenter> implements IBaseView {

    @BindView(R.id.base_toolbar_title)
    TextView mBaseToolbarTitle;


    @NonNull
    @Override
    public NullPersenter createPresenter() {
        return new NullPersenter();
    }

    @Override
    public int getLayoutResID() {
        return R.layout.activity_visa_sense;
    }

    @Override
    protected void initView() {
        mBaseToolbarTitle.setText(R.string.visa_sense);
    }

    @OnClick({R.id.base_img_left})
    public void OnClick(View v) {
        switch (v.getId()) {
            case R.id.base_img_left:
                this.finish();
                break;

        }

    }


}
