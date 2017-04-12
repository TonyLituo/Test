package com.dhcc.visa.ui.view.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dhcc.visa.R;
import com.dhcc.visa.common.router.Router;
import com.dhcc.visa.persenter.LoginPersenter;
import com.dhcc.visa.ui.base.BaseActivity;
import com.dhcc.visa.ui.widget.MyDialog;
import com.hannesdorfmann.mosby.mvp.MvpPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lenovo on 2017/4/10.
 */

public class VisaDetailActivity extends BaseActivity {

    @BindView(R.id.base_img_left)
    ImageView mBaseImgLeft;
    @BindView(R.id.base_toolbar_title)
    TextView mBaseToolbarTitle;
    @BindView(R.id.visa_detail)
    TextView mVisaDetail;
    @BindView(R.id.handle_time)
    TextView mHandleTime;
    @BindView(R.id.rl_evaluation)
    RelativeLayout mRlEvaluation;

    @Override
    public int getLayoutResID() {
        return R.layout.activity_visa_detail;
    }

    @Override
    protected void initView() {
        mBaseToolbarTitle.setText("签证详情");
    }

    @NonNull
    @Override
    public MvpPresenter createPresenter() {
        return new LoginPersenter();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.base_img_left,R.id.rl_evaluation,R.id.visa_detail,R.id.handle_time})
    public void OnClick(View v) {
        switch (v.getId()) {
            case R.id.base_img_left:
                this.finish();
                break;
            case R.id.visa_detail:
                new MyDialog(this,MyDialog.OTHER_TYPE).setTitleText("美国商务签证").setContentText("").showContentText(false)
                        .setVisaAmt("￥1299").setDiscountAmt("￥1700")
                        .setVisaMsg("领馆收费1120+中智签证服务费+照片处理冲洗费用+顺风回寄包邮")
                        .show();
                break;
            case R.id.handle_time:
                new MyDialog(this,MyDialog.OTHER_TYPE).setTitleText("办理时长").setContentText("").showContentText(false)
                        .setVisaAmt("11-13").setDiscountAmt("工作日")
                        .setVisaMsg("从资料收起后开始计算：中智签证处理1-2个工作日+使馆可预约面试时间4-6个工作日之后+使馆受理5-6个工作日")
                        .show();
                break;
            case R.id.rl_evaluation:
                Router.newIntent(this).to(VisaDetailEvaluationActivity.class).launch();
                break;
        }

    }
}
