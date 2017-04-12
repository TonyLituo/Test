package com.dhcc.visa.ui.view.mine;

import com.dhcc.visa.R;
import com.dhcc.visa.persenter.MinePresenter;
import com.dhcc.visa.ui.MyOrderActivity;
import com.dhcc.visa.ui.base.BaseFragment;
import com.dhcc.visa.ui.view.user.SettingActivity;

import butterknife.OnClick;

/**
 * Created by Lituo on 2017/4/6 0006. pic7:03 .
 * Mail：tony1994_vip@163.com
 */

public class MineFragment extends BaseFragment<IMineView, MinePresenter> implements IMineView {

    @OnClick(R.id.mine_setting)
    public void onViewClicked() {
        mActivityUtils.startActivity(SettingActivity.class);
    }

    @OnClick(R.id.rl_my_order)
    public void MyOrdert(){
        mActivityUtils.startActivity(MyOrderActivity.class);
    }

    @Override
    public MinePresenter createPresenter() {
        return new MinePresenter();
    }


    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initView() {

    }


}
