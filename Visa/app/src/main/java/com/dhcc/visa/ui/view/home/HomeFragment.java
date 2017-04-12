package com.dhcc.visa.ui.view.home;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.dhcc.visa.R;
import com.dhcc.visa.common.router.Router;
import com.dhcc.visa.model.bean.HomeVisa;
import com.dhcc.visa.persenter.HomePresenter;
import com.dhcc.visa.ui.adapter.HomeVisaAdapter;
import com.dhcc.visa.ui.base.BaseFragment;
import com.dhcc.visa.ui.view.prdtlist.PrdtListActivity;
import com.dhcc.visa.ui.view.user.login.LoginActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Lituo on 2017/4/6 0006. pic7:02 .
 * Mail：tony1994_vip@163.com
 */

public class HomeFragment extends BaseFragment<IHomeView, HomePresenter> implements IHomeView {
    private static final Class<?>[] ACTIVITY = {LoginActivity.class, LoginActivity.class, LoginActivity.class, ExitKitsActivity.class};
    private static final String[] TITLE = {"签证政策", "领馆信息", "出签预测", "出境锦囊"};
    private static final int[] IMG = {R.mipmap.visa_policy, R.mipmap.consulate_info, R.mipmap.visa_prediction, R.mipmap.out_of_the_kit};

    private ArrayList<HomeVisa> mList;
    private RecyclerView mRecyclerView;

    @BindView(R.id.iv_search)
    ImageView iv_search;
    @BindView(R.id.tv_search)
    TextView tv_search;
    @BindView(R.id.imageView1)
    ImageView imageView1;
    @BindView(R.id.imageView2)
    ImageView imageView2;
    @BindView(R.id.img1)
    ImageView img1;
    @BindView(R.id.img2)
    ImageView img2;
    @BindView(R.id.iv_left)
    ImageView iv_left;
    @BindView(R.id.iv_right)
    ImageView iv_right;
    @BindView(R.id.iv2_left)
    ImageView iv2_left;
    @BindView(R.id.iv2_right)
    ImageView iv2_right;

    @Override
    protected void initView() {
        mRecyclerView = (RecyclerView) getActivity().findViewById(R.id.recrcler);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        initData();
        initAdapter();
    }

    private void initAdapter() {
        BaseQuickAdapter homeAdapter = new HomeVisaAdapter(R.layout.item_home_visa, mList);
        homeAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
//                Router.newIntent(getActivity()).to(ACTIVITY[position]).launch();
            }
        });

        mRecyclerView.setAdapter(homeAdapter);
    }

    private void initData() {
        mList = new ArrayList<>();
        for (int i = 0; i < TITLE.length; i++) {
            HomeVisa item = new HomeVisa();
            item.setTitle(TITLE[i]);
            item.setActivity(ACTIVITY[i]);
            item.setImageResource(IMG[i]);
            mList.add(item);
        }

    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_home;
    }

    @Override
    public HomePresenter createPresenter() {
        return new HomePresenter();
    }


    @OnClick({R.id.imageView1, R.id.imageView2, R.id.iv_left, R.id.iv_right, R.id.iv2_left, R.id.iv2_right, R.id.img1, R.id.img2, R.id.iv_search, R.id.tv_search})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_search:
                Router.newIntent(getActivity()).to(SearchActivity.class).launch();
                break;
            case R.id.tv_search:
                Router.newIntent(getActivity()).to(SearchActivity.class).launch();
                break;
            case R.id.imageView1:
                Router.newIntent(getActivity()).to(LoginActivity.class).launch();
                break;
            case R.id.imageView2:
                Router.newIntent(getActivity()).to(LoginActivity.class).launch();
                break;
            case R.id.iv_left:
                Router.newIntent(getActivity()).to(PrdtListActivity.class).launch();
                break;
            case R.id.iv_right:
                Router.newIntent(getActivity()).to(PrdtListActivity.class).launch();
                break;
            case R.id.iv2_left:
                Router.newIntent(getActivity()).to(PrdtListActivity.class).launch();
                break;
            case R.id.iv2_right:
                Router.newIntent(getActivity()).to(PrdtListActivity.class).launch();
                break;
            case R.id.img1:
                Router.newIntent(getActivity()).to(CountryClassActivity.class).launch();
                break;
            case R.id.img2:
                Router.newIntent(getActivity()).to(CountryClassActivity.class).launch();
                break;
        }
    }
}
