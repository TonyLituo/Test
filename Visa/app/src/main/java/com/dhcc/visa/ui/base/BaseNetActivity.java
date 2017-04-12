package com.dhcc.visa.ui.base;

import android.os.Bundle;

import com.dhcc.visa.common.utils.LogUtils;
import com.dhcc.visa.ui.widget.DhccProgrssDialog;
import com.hannesdorfmann.mosby.mvp.MvpPresenter;

import java.util.HashMap;

/**
 * Created by Lituo on 2017/4/10 0010. 22:08 .
 * Mail：tony1994_vip@163.com
 * 单个网络访问presenter 基类  封装 请求的Map对象、网络访问错误处理、
 *
 */

public abstract class BaseNetActivity<V extends IBaseNetView, P extends MvpPresenter<V>>
        extends BaseActivity<V, P> implements IBaseNetView {

    protected HashMap<String, String> map;

    DhccProgrssDialog progessbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        map = new HashMap<>();
        progessbar = new DhccProgrssDialog(this, 1);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        map.clear();
        map = null;
    }


    @Override
    public void showPrgbar() {
        progessbar.showCustomProgrssDialog(this);
    }

    @Override
    public void hidePrgbar() {
        progessbar.hideCustomProgressDialog();
    }


    @Override
    public void failure() {
        LogUtils.e("====failure");
    }

    @Override
    public void error(int responseCode) {
        LogUtils.e(responseCode + "======");
    }


}
