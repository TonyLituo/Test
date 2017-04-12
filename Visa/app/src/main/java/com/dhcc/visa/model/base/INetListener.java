package com.dhcc.visa.model.base;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by Lituo on 2017/4/10 0010. 20:09 .
 * Mail：tony1994_vip@163.com
 * 网络访问Model监听
 */

public interface INetListener {

    void onSucceed(JSONObject jsonResponseBody);

    void onFailed();

    void onError(int responseCode);
}
