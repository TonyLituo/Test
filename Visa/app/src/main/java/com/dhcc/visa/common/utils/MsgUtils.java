package com.dhcc.visa.common.utils;

import com.alibaba.fastjson.JSONObject;

/**
 * 公共报文处理工具类
 * Created by zhanY on 2017/4/12.
 */

public class MsgUtils {

    /**
     * 公共报文头
     *
     * @param json
     */
    public static void DealMsgHeader(JSONObject json,JSONObject innejson) {
        if (null == json) json = new JSONObject();
        json.put("PartnerId","B001");
        json.put("PartnerAppId","05");
        json.put("MsgTime",DateUtils.getCurrentDate());
        json.put("SignType","02");
        json.put("Sign","123456");
        json.put("ReqParams",innejson);

    }
}
