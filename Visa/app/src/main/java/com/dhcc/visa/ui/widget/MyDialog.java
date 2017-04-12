package com.dhcc.visa.ui.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Transformation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dhcc.visa.R;

/**
 * Created by zhanY on 2017/4/6.
 */

public class MyDialog extends Dialog implements View.OnClickListener {
    private View mDialogView;
    private AnimationSet mModalInAnim;
    private AnimationSet mModalOutAnim;
    private Animation mOverlayOutAnim;
    private TextView mContentTextView;
    private String mContentText;
    private boolean mShowCancel;
    private boolean mShowContent;
    private String mCancelText;
    private String mConfirmText;
    private int mAlertType;
    private Button mConfirmButton, mOkButton;
    private Button mCancelButton;
    private OnSweetClickListener mCancelClickListener;
    private OnSweetClickListener mConfirmClickListener;
    private OnSweetClickListener mOkButtonClickListener;
    private boolean mCloseFromCancel;
    private boolean mShowVisaMsg;
    private boolean mShowVisaAmt;
    private boolean mShowDisVisaAmt;

    public static final int NORMAL_TYPE = 0;
    public static final int CONFIRM_TYPE = 1;
    public static final int OTHER_TYPE =2 ;
    private LinearLayout mDialog;
    private LinearLayout mVisaMessageLayout;
    private TextView mVisaMsgText;
    private TextView mVisaAmtText;
    private TextView mDiscountAmtText;
    private String mVisaMsg;
    private String mVisaAmt;
    private String mDiscountAmt;
    private TextView mTitleText;

    public static interface OnSweetClickListener {
        public void onClick(MyDialog MyDialog);
    }

    public MyDialog(Context context) {
        this(context, NORMAL_TYPE);
    }

    public MyDialog(Context context, int alertType) {
        super(context, R.style.alert_dialog);
        setCancelable(true);
        setCanceledOnTouchOutside(false);
        mAlertType = alertType;
        mModalInAnim = (AnimationSet) OptAnimationLoader.loadAnimation(getContext(), R.anim.alert_modal_in);
        mModalOutAnim = (AnimationSet) OptAnimationLoader.loadAnimation(getContext(), R.anim.alert_modal_out);
        mModalOutAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mDialogView.setVisibility(View.GONE);
                mDialogView.post(new Runnable() {
                    @Override
                    public void run() {
                        if (mCloseFromCancel) {
                            MyDialog.super.cancel();
                        } else {
                            MyDialog.super.dismiss();
                        }
                    }
                });
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
//        // dialog overlay fade out
        mOverlayOutAnim = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                WindowManager.LayoutParams wlp = getWindow().getAttributes();
                wlp.alpha = 1 - interpolatedTime;
                getWindow().setAttributes(wlp);
            }
        };
        mOverlayOutAnim.setDuration(120);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.custom_alert_dialog);
        mDialogView = getWindow().getDecorView().findViewById(android.R.id.content);
        mTitleText = (TextView) findViewById(R.id.title_text);
        mContentTextView = (TextView) findViewById(R.id.content_text);
        mOkButton = (Button) findViewById(R.id.ok_button);
        mConfirmButton = (Button) findViewById(R.id.confirm_button);
        mCancelButton = (Button) findViewById(R.id.cancel_button);
        mDialog = (LinearLayout) findViewById(R.id.dialog);
        mVisaMessageLayout = (LinearLayout) findViewById(R.id.ll_visa_message);
        mVisaMsgText = (TextView) findViewById(R.id.visa_message);
        mVisaAmtText = (TextView) findViewById(R.id.visa_amt);
        mDiscountAmtText = (TextView) findViewById(R.id.discount_amt);
        mConfirmButton.setOnClickListener(this);
        mCancelButton.setOnClickListener(this);
        mOkButton.setOnClickListener(this);
        setTitleText(mTitle);
        setContentText(mContentText);
        setCancelText(mCancelText);
        setConfirmText(mConfirmText);
        setVisaMsg(mVisaMsg);
        setVisaAmt(mVisaAmt);
        setDiscountAmt(mDiscountAmt);
        changeAlertType(mAlertType, true);

    }


    private void restore() {
        mOkButton.setVisibility(View.GONE);
        mDialog.setVisibility(View.GONE);
        mVisaMessageLayout.setVisibility(View.GONE);
        mVisaMsgText.setVisibility(View.GONE);

    }

    private void changeAlertType(int alertType, boolean fromCreate) {
        mAlertType = alertType;
        if (mDialogView != null) {
            if (!fromCreate) {
                restore();
            }
            switch (mAlertType) {

                case NORMAL_TYPE:
                    mOkButton.setVisibility(View.VISIBLE);
                    mContentTextView.setVisibility(View.VISIBLE);
                    mDialog.setVisibility(View.GONE);
                    mVisaMessageLayout.setVisibility(View.GONE);
                    mVisaMsgText.setVisibility(View.GONE);
                    break;
                case CONFIRM_TYPE:
                    mDialog.setVisibility(View.VISIBLE);
                    mContentTextView.setVisibility(View.VISIBLE);
                    mOkButton.setVisibility(View.GONE);
                    mVisaMessageLayout.setVisibility(View.GONE);
                    mVisaMsgText.setVisibility(View.GONE);
                    break;
                case OTHER_TYPE:
                    mDialog.setVisibility(View.GONE);
                    mContentTextView.setVisibility(View.GONE);
                    mOkButton.setVisibility(View.GONE);
                    mVisaMessageLayout.setVisibility(View.VISIBLE);
                    mVisaMsgText.setVisibility(View.VISIBLE);
                    break;

            }
        }
    }

    public MyDialog setVisaAmt(String visaAmt) {
        mVisaAmt = visaAmt;
        if (mVisaAmtText != null && mVisaAmt != null) {
            showVisaAmtText(true);
            mVisaAmtText.setText(mVisaAmt);
        }
        return this;
    }

    public boolean isShowVisaAmt() {
        return mShowVisaAmt;
    }


    public boolean isShowVisaMsg() {
        return mShowVisaMsg;
    }


    public boolean isShowDisVisaAmt() {
        return mShowDisVisaAmt;
    }


    private MyDialog showVisaAmtText(boolean isShow) {
        mShowVisaAmt= isShow;
        if (mVisaAmtText != null) {
            mVisaAmtText.setVisibility(mShowVisaAmt ? View.VISIBLE : View.GONE);
        }
        return this;
    }

    public MyDialog setVisaMsg(String visaMsg) {
        mVisaMsg = visaMsg;
        if (mVisaMsgText != null && mVisaMsg != null) {
            showVisaMsgText(true);
            mVisaMsgText.setText(mVisaMsg);
        }
        return this;
    }

    private MyDialog showVisaMsgText(boolean isShow) {
        mShowVisaMsg = isShow;
        if (mVisaMsgText != null) {
            mVisaMsgText.setVisibility(mShowVisaMsg ? View.VISIBLE : View.GONE);
        }
        return this;
    }

    public MyDialog setDiscountAmt(String discountAmt) {
        mDiscountAmt = discountAmt;
        if (mDiscountAmtText != null && mDiscountAmt != null) {
            showVisaDisAmtText(true);
            mDiscountAmtText.setText(mDiscountAmt);
        }
        return this;
    }

    private MyDialog showVisaDisAmtText(boolean isShow) {
        mShowDisVisaAmt = isShow;
        if (mDiscountAmtText != null) {
            mDiscountAmtText.setVisibility(mShowDisVisaAmt ? View.VISIBLE : View.GONE);
        }
        return this;
    }

    public int getAlerType() {
        return mAlertType;
    }

    public void changeAlertType(int alertType) {
        changeAlertType(alertType, false);
    }


    public String getContentText() {
        return mContentText;
    }

    public MyDialog setContentText(String text) {
        mContentText = text;
        if (mContentTextView != null && mContentText != null) {
            showContentText(true);
            mContentTextView.setText(mContentText);
        }
        return this;
    }
private String mTitle;
    public MyDialog setTitleText(String text) {
        mTitle=text;
        if (mTitleText != null && mTitle != null) {
            mTitleText.setText(mTitle);
        }
        return this;
    }

    public boolean isShowCancelButton() {
        return mShowCancel;
    }

    public MyDialog showCancelButton(boolean isShow) {
        mShowCancel = isShow;
        if (mCancelButton != null) {
            mCancelButton.setVisibility(mShowCancel ? View.VISIBLE : View.GONE);
        }
        return this;
    }

    public boolean isShowContentText() {
        return mShowContent;
    }

    public MyDialog showContentText(boolean isShow) {
        mShowContent = isShow;
        if (mContentTextView != null) {
            mContentTextView.setVisibility(mShowContent ? View.VISIBLE : View.GONE);
        }
        return this;
    }

    public String getCancelText() {
        return mCancelText;
    }

    public MyDialog setCancelText(String text) {
        mCancelText = text;
        if (mCancelButton != null && mCancelText != null) {
            showCancelButton(true);
            mCancelButton.setText(mCancelText);
        }
        return this;
    }

    public String getConfirmText() {
        return mConfirmText;
    }

    public MyDialog setConfirmText(String text) {
        mConfirmText = text;
        if (mConfirmButton != null && mConfirmText != null) {
            mConfirmButton.setText(mConfirmText);
        }
        return this;
    }

    public MyDialog setCancelClickListener(OnSweetClickListener listener) {
        mCancelClickListener = listener;
        return this;
    }

    public MyDialog setConfirmClickListener(OnSweetClickListener listener) {
        mConfirmClickListener = listener;
        return this;
    }


    public MyDialog setOkButtonClickListener(OnSweetClickListener listener) {
        mOkButtonClickListener = listener;
        return this;
    }


    @Override
    protected void onStart() {
        mDialogView.startAnimation(mModalInAnim);
//        playAnimation();
    }

    /**
     * The real Dialog.cancel() will be invoked async-ly after the animation finishes.
     */
    @Override
    public void cancel() {
        dismissWithAnimation(true);
    }

    /**
     * The real Dialog.dismiss() will be invoked async-ly after the animation finishes.
     */
    public void dismissWithAnimation() {
        dismissWithAnimation(false);
    }

    private void dismissWithAnimation(boolean fromCancel) {
        mCloseFromCancel = fromCancel;
        mConfirmButton.startAnimation(mOverlayOutAnim);
        mOkButton.startAnimation(mOverlayOutAnim);
        mDialogView.startAnimation(mModalOutAnim);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.cancel_button) {
            if (mCancelClickListener != null) {
                mCancelClickListener.onClick(MyDialog.this);
            } else {
                dismissWithAnimation();
            }
        } else if (v.getId() == R.id.confirm_button) {
            if (mConfirmClickListener != null) {
                mConfirmClickListener.onClick(MyDialog.this);
            } else {
                dismissWithAnimation();
            }
        } else if (v.getId() == R.id.ok_button) {
            if (mOkButtonClickListener != null) {
                mOkButtonClickListener.onClick(MyDialog.this);
            } else {
                dismissWithAnimation();
            }
        }
    }

}