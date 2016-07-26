package com.hjianfei.mvp_example.model.login;

import android.os.Handler;
import android.text.TextUtils;

/**
 * Created by HJianFei on 2016-7-26.
 */
public class LoginInteractorImpl implements LoginInteractor {
    @Override
    public void login(final String userName, final String userPassword, final OnLoginFinishListener loginFinishListener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                boolean error = false;
                if (TextUtils.isEmpty(userName)) {
                    loginFinishListener.onUserNameError();
                    error = true;
                }
                if (TextUtils.isEmpty(userPassword)) {
                    loginFinishListener.onUserPasswordError();
                    error = true;
                }
                if (!error) {
                    loginFinishListener.onSuccess();
                }
            }
        }, 2000);
    }
}
