package com.dhcc.visa.model.base;

import java.util.HashMap;

/**
 * Created by Lituo on 2017/4/10 0010. 22:59 .
 * Mail：tony1994_vip@163.com
 * model层网络访问的接口,单个交易
 */

public interface INetModel {

    void doPost(HashMap<String,String> map,INetListener listener);
}
