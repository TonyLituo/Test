package com.dhcc.visa.ui.view.mine;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.dhcc.visa.R;
import com.dhcc.visa.persenter.ExitKitsPersenter;
import com.dhcc.visa.ui.base.BaseActivity;
import com.dhcc.visa.ui.base.IBaseView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by zhanY on 2017/4/11.
 */

public class QuestionActivity extends BaseActivity <IBaseView, ExitKitsPersenter> implements IBaseView{

    @BindView(R.id.frame_query)
    FrameLayout frameLayout;
    @BindView(R.id.textView1)
    TextView textView1;
    @BindView(R.id.textView2)
    TextView textView2;
    @BindView(R.id.textView3)
    TextView textView3;
    @BindView(R.id.vw1)
    View v1;
    @BindView(R.id.vw2)
    View v2;
    @BindView(R.id.vw3)
    View v3;

    View viewFirst, viewSecond, viewThird;

    @Override
    public int getLayoutResID() {
        return R.layout.layout_question;
    }

    @Override
    protected void initView() {

        viewFirst = View.inflate(this, R.layout.fragment_question, null);
        viewSecond = View.inflate(this, R.layout.fragment_question, null);
        viewThird = View.inflate(this, R.layout.fragment_question, null);
        frameLayout.removeAllViews();
        frameLayout.addView(viewFirst);

    }

    @NonNull
    @Override
    public ExitKitsPersenter createPresenter() {
        return new ExitKitsPersenter();
    }

    @OnClick({R.id.textView1, R.id.textView2, R.id.textView3})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.textView1:
                initGrayColor();
                isPressedColor(textView1, v1);
                break;
            case R.id.textView2:
                initGrayColor();
                isPressedColor(textView2, v2);
                break;
            case R.id.textView3:
                initGrayColor();
                isPressedColor(textView3, v3);
                break;
        }
    }

    // 恢复其他为灰色
    @SuppressWarnings("deprecation")
    public void initGrayColor() {
        v1.setVisibility(View.INVISIBLE);
        v2.setVisibility(View.INVISIBLE);
        v3.setVisibility(View.INVISIBLE);
        textView1.setTextColor(getResources().getColor(R.color.gray_color));
        textView2.setTextColor(getResources().getColor(R.color.gray_color));
        textView3.setTextColor(getResources().getColor(R.color.gray_color));

    }

    // 显示当前为蓝色
    @SuppressWarnings("deprecation")
    public void isPressedColor(TextView textview, View view) {
        textview.setTextColor(getResources().getColor(R.color.blue));
        view.setVisibility(View.VISIBLE);
    }

}
