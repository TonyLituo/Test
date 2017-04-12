package com.dhcc.visa.model.network;

import com.dhcc.visa.app.VisaApplication;
import com.dhcc.visa.common.utils.SystemUtils;
import com.dhcc.visa.model.base.BaseNetModelImpl;

/**
 * Created by Lituo on 2017/4/12 0012. 16:51 .
 * Mail：tony1994_vip@163.com
 *
 */

public class LoginModel extends BaseNetModelImpl {

    @Override
    protected void addToMap() {
        //内部添加字段
        mJson.put("loginMode", "1");
        mJson.put("loginChnl", "APP");
        mJson.put("loginIp", SystemUtils.getLocalIpAddress());
        mJson.put("loginDevice", SystemUtils.getDeviceId(VisaApplication.getApplication()));
        //外部添加字段  交易码 TransCode
        mJsonComm.put("TransCode", 1234);
    }
}
