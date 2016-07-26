package com.hjianfei.mvp_example.view.mian;

import java.util.List;

/**
 * Created by HJianFei on 2016-7-26.
 */
public interface MainView {
    void showProgress();

    void hideProgress();

    void setItem(List<String> items);

    void showMessage(String message);
}
