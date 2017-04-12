package com.dhcc.visa.persenter.base;

import com.alibaba.fastjson.JSONObject;
import com.dhcc.visa.model.base.INetListener;
import com.dhcc.visa.model.base.INetModel;
import com.dhcc.visa.ui.base.IBaseNetView;

import java.util.HashMap;

/**
 * Created by Lituo on 2017/4/5 0005. 16:08 .
 * Mail：tony1994_vip@163.com
 * 含有网络请求数据处理的persenter的基类,不可直接使用;
 *
 * <p>
 */

public abstract class BaseNetPersenter<V extends IBaseNetView> extends BasePersenter<V> {
    //在子类中初始化
    protected INetModel mNetModel;

    /**
     * model层初始化
     *
     * @return
     */
    protected abstract INetModel setNetModel();

    /**
     * 交易处理
     */
    public void persenter(HashMap<String, String> map) {
        //初始化model
        mNetModel = setNetModel();
        //显示pgbar
        getView().showPrgbar();
        //通过model拿到数据
        mNetModel.doPost(map, new INetListener() {
            @Override
            public void onSucceed(JSONObject jsonResponseBody) {
                succeed(jsonResponseBody);
            }

            @Override
            public void onFailed() {
                getView().hidePrgbar();
                getView().failure();
            }

            @Override
            public void onError(int responseCode) {
                getView().hidePrgbar();
                getView().error(responseCode);
            }
        });

    }


    /**
     * 根据响应码获取错误的信息
     */
    public String getNetError(int responseCode) {
        switch (responseCode) {
            case 404:
                return "请求页面路径错误";
            case 500:
                return "服务器内部错误";
            case 502:
                return "错误网关";
            case 504:
                return "网关超时";
            default:
                return responseCode + "错误";
        }
    }

    /**
     * 网络连接失败
     *
     * @return
     */
    public String connFailure() {

        return "网络连接失败";
    }

    public String exception(Exception e) {
        return e.getMessage();
    }


    /**
     * 成功的交易处理
     */
    public abstract void succeed(JSONObject jsonResponseBody);
}
