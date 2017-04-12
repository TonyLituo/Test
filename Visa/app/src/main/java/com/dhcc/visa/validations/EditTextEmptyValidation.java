package com.dhcc.visa.validations;

import android.content.Context;
import android.text.TextUtils;

import com.dhcc.visa.common.AValidations.ValidationExecutor;

/**
 * Created by zhanY on 2017/4/12.
 */

public class EditTextEmptyValidation extends ValidationExecutor {

    @Override
    public boolean doValidate(Context context, String text) {
        if (TextUtils.isEmpty(text)) {
            return false;
        }
        return true;
    }
}
