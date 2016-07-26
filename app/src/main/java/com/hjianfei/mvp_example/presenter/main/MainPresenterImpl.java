package com.hjianfei.mvp_example.presenter.main;

import com.hjianfei.mvp_example.model.main.MainInteractor;
import com.hjianfei.mvp_example.model.main.MainInteractorImpl;
import com.hjianfei.mvp_example.view.mian.MainView;

import java.util.List;

/**
 * Created by HJianFei on 2016-7-26.
 */
public class MainPresenterImpl implements MainPresenter, MainInteractor.OnFinishListener {

    private MainView mainView;
    private MainInteractor mainInteractor;

    public MainPresenterImpl(MainView mainView) {
        this.mainView = mainView;
        mainInteractor = new MainInteractorImpl();
    }

    @Override
    public void onResume() {
        if (mainView != null) {
            mainView.showProgress();
        }
        mainInteractor.findItems(this);

    }

    @Override
    public void onItemClicked(int position) {
        if (mainView != null) {
            mainView.showMessage(String.format("Position %d clicked", position + 1));
        }

    }

    @Override
    public void onDestroy() {
        mainView = null;

    }

    @Override
    public void OnFinished(List<String> items) {
        if (mainView != null) {
            mainView.setItem(items);
            mainView.hideProgress();
        }
    }
}
