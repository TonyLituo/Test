package com.dhcc.visa.common.AValidations;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by zhanY on 2017/4/10.
 */

public class EditTextValidator {
    private ArrayList<ValidationModel> validationModels;

    private View button;

    private Context context;

    public EditTextValidator(Context context) {
        init(context, null);
    }

    public EditTextValidator(Context context, View button) {

        init(context, button);
    }

    private void init(Context context, View button) {
        this.context = context;
        this.button = button;
        validationModels = new ArrayList<ValidationModel>();
    }

    /**
     * 设置button，支持各种有点击事件的view
     *
     * @param button
     * @return
     */
    public EditTextValidator setButton(View button) {
        this.button = button;
        return this;
    }

    public EditTextValidator add(ValidationModel validationModel) {
        validationModels.add(validationModel);
        return this;
    }

    public EditTextValidator execute() {
        for (final ValidationModel validationModel : validationModels) {
            if (validationModel.getEditText() == null) {
                return this;
            }
            validationModel.getEditText().addTextChangedListener(new TextWatcher() {

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    setEnabled();
                }

                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override
                public void afterTextChanged(Editable s) {
                }
            });
        }

        setEnabled();

        return this;
    }

    private void setEnabled() {
        for (final ValidationModel validationModel : validationModels) {
            if (button != null) {

                if (validationModel.isTextEmpty()) {// 如果有一个是空的，button直接不可点击
                    button.setEnabled(false);
                    return;
                } else {
                    if (!button.isEnabled()) {
                        button.setEnabled(true);
                    }
                }
            }
        }

    }

    public boolean validate() {
        for (ValidationModel validationModel : validationModels) {
            if (validationModel.getValidationExecutor() == null || validationModel.getEditText() == null) {
                // 如果没有验证处理器，直接返回正确
                return true;
            }
            if (!validationModel.getValidationExecutor().doValidate(context, validationModel.getEditText().getText().toString())) {

                // 如果需要做单个EditText验证不通过标记，可以在这里实现

                return false;// 只要有不通过的直接返回false，不要往下执行了
            }
        }
        return true;
    }

    public View getButton() {
        return button;
    }

}
