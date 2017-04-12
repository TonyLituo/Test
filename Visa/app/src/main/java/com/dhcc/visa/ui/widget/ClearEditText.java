package com.dhcc.visa.ui.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.EditText;

import com.dhcc.visa.R;

/**
 * Created by Administrator on 2017/4/10.
 */

public class ClearEditText extends EditText {
    private Drawable rightDrawable;

    public ClearEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    // 给编辑框设置图片
    public void initView() {
        // 获取编辑框右边的图片 左0，顶1，右2，底3
        rightDrawable = this.getCompoundDrawables()[2];
        rightDrawable = this.getResources().getDrawable(R.drawable.delect);

        setIsVisibleRight(false);

        // 监听编辑框是否有内容输入
        this.addTextChangedListener(new TextWatcher() {

            // 文本改变时调用
            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {

                setIsVisibleRight(s.length() > 0);
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    // 右图片的显示与否
    public void setIsVisibleRight(boolean isVisible) {
        this.setCompoundDrawablesWithIntrinsicBounds(null, null,
                isVisible ? rightDrawable : null, null);

    }

    // 右图片的触摸事件
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP) {
            float x = event.getX();
            if (x > this.getWidth() - rightDrawable.getIntrinsicWidth()
                    - this.getPaddingRight()
                    && x < this.getWidth() - this.getPaddingRight()) {

                this.setText("");
            }
        }
        return super.onTouchEvent(event);
    }
}
