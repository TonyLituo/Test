package com.dhcc.visa.common.AValidations;

import android.content.Context;

import com.dhcc.visa.common.utils.ValidationUtil;

/**
 * Created by zhanY on 2017/4/10.
 */

public abstract class ValidationExecutor extends ValidationUtil {

    /**
     * 这里做校验处理
     *
     * @return 校验成功返回true 否则返回false
     */
    public abstract boolean doValidate(Context context, String text);

}