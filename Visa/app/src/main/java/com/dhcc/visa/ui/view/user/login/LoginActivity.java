package com.dhcc.visa.ui.view.user.login;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.dhcc.visa.R;
import com.dhcc.visa.common.AValidations.EditTextValidator;
import com.dhcc.visa.common.AValidations.ValidationModel;
import com.dhcc.visa.persenter.LoginPersenter;
import com.dhcc.visa.ui.base.BaseNetActivity;
import com.dhcc.visa.ui.view.user.forgetpwd.ForgetPwdActivity;
import com.dhcc.visa.ui.view.user.register.FirstRegisterActivity;
import com.dhcc.visa.validations.EditTextEmptyValidation;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseNetActivity<ILoginView, LoginPersenter> implements ILoginView {

    @BindView(R.id.base_toolbar_title)
    TextView mBaseToolbarTitle;
    @BindView(R.id.include)
    View mToolbar;
    @BindView(R.id.et_login_phone)
    EditText mEtPhone;
    @BindView(R.id.et_login_pwd)
    EditText mEtPwd;
    @BindView(R.id.tv_free_register)
    TextView mTvRegister;
    @BindView(R.id.tv_forget_pwd)
    TextView mTvFgPwd;
    @BindView(R.id.btn_login)
    Button mBtn;
    @BindView(R.id.iv_bg)
    ImageView ivBg;

    protected EditTextValidator editTextValidator;

    @Override
    public int getLayoutResID() {
        return R.layout.activity_login;
    }


    @Override
    protected void initView() {
        mBaseToolbarTitle.setText(R.string.login);
        editTextValidator = new EditTextValidator(this).setButton(mBtn)
                .add(new ValidationModel(mEtPhone, new EditTextEmptyValidation()))
                .add(new ValidationModel(mEtPwd, new EditTextEmptyValidation()))
                .execute();
    }

    @NonNull
    @Override
    public LoginPersenter createPresenter() {
        return new LoginPersenter();
    }

    @OnClick({R.id.btn_login, R.id.tv_free_register, R.id.tv_forget_pwd})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                if (editTextValidator.validate()) {
                    //key值根据接口字段定义
                    map.put("cellPhone", mEtPhone.getText().toString());
                    map.put("loginPwd", mEtPwd.getText().toString());

                    presenter.persenter(map);
                }
                break;
            case R.id.tv_free_register:
                mActivityUtils.startActivity(FirstRegisterActivity.class);
                break;
            case R.id.tv_forget_pwd:
                mActivityUtils.startActivity(ForgetPwdActivity.class);
                break;
        }

    }


    @Override
    public void succeed(String strJson) {

    }


    @OnClick(R.id.base_img_left)
    public void onViewClicked() {
        finish();
    }
}
