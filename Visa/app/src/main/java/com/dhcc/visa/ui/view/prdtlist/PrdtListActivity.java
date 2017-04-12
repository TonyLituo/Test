package com.dhcc.visa.ui.view.prdtlist;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dhcc.visa.R;
import com.dhcc.visa.common.router.Router;
import com.dhcc.visa.model.bean.VisaPrdtBean;
import com.dhcc.visa.persenter.CommonPresent;
import com.dhcc.visa.ui.adapter.VisaPrdtListAdapter;
import com.dhcc.visa.ui.base.BaseActivity;
import com.dhcc.visa.ui.base.IBaseView;
import com.dhcc.visa.ui.view.home.ExitKitsActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/4/10.
 */

public class PrdtListActivity extends BaseActivity<IBaseView, CommonPresent> implements IBaseView {
    @BindView(R.id.iv_prdtlist_back)
    ImageView mIvPrdtlistBack;
    private List<VisaPrdtBean> visaPrdtBeanList = new ArrayList<VisaPrdtBean>();

    @BindView(R.id.rv_countries)
    RecyclerView recyclerView;
    @BindView(R.id.tv_out_of_the_kit)
    TextView mTvOutOfKit;

    @Override
    public int getLayoutResID() {
        return R.layout.activity_visa_list;
    }

    @Override
    protected void initView() {
        for (int i = 0; i < 5; i++) {
            VisaPrdtBean visaPrdtBean = new VisaPrdtBean("美国商务旅游签证（B1/B2）- 全国受理","99.9%","￥1399","1000人已受理","2000人评论","￥1399");
            visaPrdtBeanList.add(visaPrdtBean);
        }
        VisaPrdtListAdapter visaPrdtListAdapter = new VisaPrdtListAdapter(this, visaPrdtBeanList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(visaPrdtListAdapter);


    }

    @NonNull
    @Override
    public CommonPresent createPresenter() {
        return new CommonPresent();
    }

    @OnClick({R.id.tv_out_of_the_kit,R.id.iv_prdtlist_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_prdtlist_back://返回按钮
                finish();
                break;
            case R.id.tv_sorting://排序
                break;
            case R.id.tv_filter://筛选
                break;
            case R.id.visa_policy://签证政策
                break;
            case R.id.tv_consulate_info://领馆信息
                break;
            case R.id.tv_out_of_prediction://出境预测
                break;
            case R.id.tv_out_of_the_kit://出境锦囊
                Router.newIntent(this).to(ExitKitsActivity.class).launch();
                break;
        }
    }


}
