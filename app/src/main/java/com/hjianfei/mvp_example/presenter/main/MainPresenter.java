package com.hjianfei.mvp_example.presenter.main;

/**
 * Created by HJianFei on 2016-7-26.
 */
public interface MainPresenter {
    void onResume();

    void onItemClicked(int position);

    void onDestroy();
}
