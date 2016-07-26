package com.hjianfei.mvp_example.presenter.login;

import com.hjianfei.mvp_example.model.login.LoginInteractor;
import com.hjianfei.mvp_example.model.login.LoginInteractorImpl;
import com.hjianfei.mvp_example.view.login.LoginView;

/**
 * Created by HJianFei on 2016-7-26.
 */
public class LoginPresenterImpl implements LoginPresenter, LoginInteractor.OnLoginFinishListener {

    private LoginView loginView;
    private LoginInteractor loginInteractor;

    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        this.loginInteractor = new LoginInteractorImpl();
    }

    @Override
    public void validateCredentials(String userName, String userPassword) {
        if (loginView != null) {
            loginView.showProgress();
        }
        loginInteractor.login(userName, userPassword, this);

    }

    @Override
    public void onDestroy() {
        loginView = null;

    }

    @Override
    public void onUserNameError() {
        if (loginView != null) {
            loginView.setUserNameError();
            loginView.hideProgress();
        }

    }

    @Override
    public void onUserPasswordError() {
        if (loginView != null) {
            loginView.setPasswordError();
            loginView.hideProgress();
        }

    }

    @Override
    public void onSuccess() {
        if (loginView != null) {
            loginView.navicateToHome();
        }

    }
}
