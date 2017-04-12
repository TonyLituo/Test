package com.dhcc.visa.model.base;

import com.alibaba.fastjson.JSONObject;
import com.dhcc.visa.common.utils.LogUtils;
import com.dhcc.visa.common.utils.MsgUtils;
import com.dhcc.visa.common.utils.OkHttpUtils;
import com.dhcc.visa.model.network.UICallBack;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;

/**
 * Created by Lituo on 2017/4/10 0010. 20:11 .
 * Mail：tony1994_vip@163.com
 * model层网络访问的基类 ,单个网络访问的model继承就行了
 *
 * 多个交易  自定义接口去再实现之(一个请求一个抽象方法)
 */

public abstract class BaseNetModelImpl implements INetModel {
    //内部请求Json
    protected JSONObject mJson;

    //外部公共Json
    protected JSONObject mJsonComm;


    public INetListener mListener;

    public BaseNetModelImpl() {
        super();
        this.mJson = new JSONObject();
        this.mJsonComm = new JSONObject();
    }

    public void setListener(INetListener listener) {
        this.mListener = listener;
    }

    private void setRequestJson(HashMap<String, String> map) {

        setJson(map);
        MsgUtils.DealMsgHeader(mJsonComm, mJson);
        LogUtils.e("发送报文：" + mJsonComm.toString());
        OkHttpUtils.Builder().build().doPostJsonAsync(mJsonComm, new UICallBack() {
            @Override
            public void onResponseUI(Call call, JSONObject jsonResponseBody) {
                mListener.onSucceed(jsonResponseBody);
            }

            @Override
            public void onFailureUI(Call call, IOException e) {
                mListener.onFailed();
            }

            @Override
            public void onError(int responseCode) {
                mListener.onError(responseCode);
            }


        });
    }


    @Override
    public void doPost(HashMap<String, String> map, INetListener listener) {
        setListener(listener);
        setRequestJson(map);
    }


    /**
     * 设置Json请求，通過遍歷map存放到Json請求中去
     */
    private void setJson(HashMap<String, String> map) {
        if (null == map) return;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (null != entry.getKey() && null != entry.getValue()) {
                mJson.put(entry.getKey(), entry.getValue());
            }
        }
        //其他字段
        addToMap();
    }

    /**
     * 用于添加除了从View中获取到的之外的数据
     *
     * 以及外部字段添加交易码
     */
    protected abstract void addToMap();


}
