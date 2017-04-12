package com.dhcc.visa.ui.view;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.dhcc.visa.R;
import com.dhcc.visa.persenter.MainPersenter;
import com.dhcc.visa.ui.base.BaseActivity;
import com.dhcc.visa.ui.base.BaseFragment;
import com.dhcc.visa.ui.view.found.FoundFragment;
import com.dhcc.visa.ui.view.home.HomeFragment;
import com.dhcc.visa.ui.view.mine.MineFragment;
import com.dhcc.visa.ui.view.order.ProblemFragment;

import butterknife.BindView;

public class MainActivity extends BaseActivity<IMainView, MainPersenter> implements IMainView {

    @BindView(R.id.rg_group)
    RadioGroup mRbtnGroup;
    @BindView(R.id.rbtn_home)
    RadioButton mRbtnHome;
    @BindView(R.id.rbtn_found)
    RadioButton mRbtnFound;
    @BindView(R.id.rbtn_problem)
    RadioButton mRbtnProblem;
    @BindView(R.id.rbtn_my_visa)
    RadioButton mRbtnMyVisa;


    //判断是否登录
    private boolean isLogin;
    //当前显示的fragment
    private BaseFragment mCurrentFragment;

    private HomeFragment mHomeFragment;
    private FoundFragment mFoundFragment;
    private ProblemFragment mProblemFragment;
    private MineFragment mMineFragment;

    @NonNull
    @Override
    public MainPersenter createPresenter() {
        return new MainPersenter();
    }

    @Override
    public int getLayoutResID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

        if (null == mHomeFragment) {
            mHomeFragment = new HomeFragment();
        }
        showFragment(mHomeFragment);

        mRbtnGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                isLogin = presenter.isLogin();

                switch (checkedId) {
                    case R.id.rbtn_home://主页
                        if (null == mHomeFragment) {
                            mHomeFragment = new HomeFragment();
                        }
                        showFragment(mHomeFragment);
                        break;
                    case R.id.rbtn_found://发现
                        if (null == mFoundFragment) {
                            mFoundFragment = new FoundFragment();
                        }
                        showFragment(mFoundFragment);
                        break;
                    case R.id.rbtn_problem://常见问题
                        if (null == mProblemFragment) {
                            mProblemFragment = new ProblemFragment();
                        }
                        showFragment(mProblemFragment);
                        break;
                    case R.id.rbtn_my_visa://我的签证
                        if (null == mMineFragment) {
                            mMineFragment = new MineFragment();
                        }
                        if (isLogin) {
                            showFragment(mMineFragment);
                        } else {
                            showFragment(mMineFragment);
                        }

                        break;
                    default:

                        throw new UnsupportedOperationException("未知错误");

                }
            }
        });
    }


    @Override
    public void showFragment(BaseFragment fragment) {


        //要显示的页面为当前页面，跳出方法不做操作
        if (fragment == mCurrentFragment) return;

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        if (null != mCurrentFragment) {
            transaction.hide(mCurrentFragment);
        }
        if (fragment.isAdded()) {//添加过了直接显示
            transaction.show(fragment);
        } else {
            String tag = fragment.getClass().getSimpleName();
            // 添加Fragment并设置Tag
            transaction.add(R.id.layout_container, fragment, tag);
        }

        transaction.commit();
        mCurrentFragment = fragment;
    }


    @Override
    public void setToolTitle(int stringRes) {
    }

}
