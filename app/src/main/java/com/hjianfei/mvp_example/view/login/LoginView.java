package com.hjianfei.mvp_example.view.login;

/**
 * Created by HJianFei on 2016-7-26.
 */
public interface LoginView {
    void showProgress();

    void hideProgress();

    void setUserNameError();

    void setPasswordError();

    void navicateToHome();
}
