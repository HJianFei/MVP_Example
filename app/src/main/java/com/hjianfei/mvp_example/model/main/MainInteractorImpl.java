package com.hjianfei.mvp_example.model.main;

import android.os.Handler;

import java.util.Arrays;
import java.util.List;

/**
 * Created by HJianFei on 2016-7-26.
 */
public class MainInteractorImpl implements MainInteractor {
    @Override
    public void findItems(final OnFinishListener listener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                listener.OnFinished(createArrayList());
            }
        }, 2000);
    }

    private List<String> createArrayList() {
        return Arrays.asList(
                "Item 1",
                "Item 2",
                "Item 3",
                "Item 4",
                "Item 5",
                "Item 6",
                "Item 7",
                "Item 8",
                "Item 9",
                "Item 10"
        );
    }
}
