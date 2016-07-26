package com.hjianfei.mvp_example.model.main;

import java.util.List;

/**
 * Created by HJianFei on 2016-7-26.
 */
public interface MainInteractor {
    interface OnFinishListener {
        void OnFinished(List<String> items);
    }

    void findItems(OnFinishListener listener);
}
