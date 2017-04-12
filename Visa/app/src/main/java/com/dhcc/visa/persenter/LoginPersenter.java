package com.dhcc.visa.persenter;

import com.alibaba.fastjson.JSONObject;
import com.dhcc.visa.model.base.INetModel;
import com.dhcc.visa.model.network.LoginModel;
import com.dhcc.visa.persenter.base.BaseNetPersenter;
import com.dhcc.visa.ui.view.user.login.ILoginView;

/**
 * Created by Lituo on 2017/4/5 0005. 16:15 .
 * Mail：tony1994_vip@163.com
 * <p>
 * 登陆的逻辑实现
 */

public class LoginPersenter
        extends BaseNetPersenter<ILoginView> {
    // TODO: 2017/4/6 0006 测试用 不是正式版


    @Override
    protected INetModel setNetModel() {
        return new LoginModel();
    }

    @Override
    public void succeed(JSONObject jsonResponseBody) {
        getView().hidePrgbar();
// TODO: 2017/4/10 0010 转化为对象Bean
        getView().succeed(jsonResponseBody.toString());
    }
}
