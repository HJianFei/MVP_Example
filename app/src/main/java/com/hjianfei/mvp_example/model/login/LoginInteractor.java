package com.hjianfei.mvp_example.model.login;

/**
 * Created by HJianFei on 2016-7-26.
 */
public interface LoginInteractor {
    interface OnLoginFinishListener {
        void onUserNameError();

        void onUserPasswordError();

        void onSuccess();
    }

    void login(String userName, String userPassword, OnLoginFinishListener loginFinishListener);
}
