package com.hjianfei.mvp_example.presenter.login;

/**
 * Created by HJianFei on 2016-7-26.
 */
public interface LoginPresenter {
    void validateCredentials(String userName, String userPassword);

    void onDestroy();
}
