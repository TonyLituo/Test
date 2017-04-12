package com.dhcc.visa.ui.view.prdtlist;

import com.dhcc.visa.ui.base.IBaseView;

/**
 * Created by Administrator on 2017/4/10.
 */

public interface IPrdtListView extends IBaseView {
    void loading();

    void loadingEnd();

    void error();
}
