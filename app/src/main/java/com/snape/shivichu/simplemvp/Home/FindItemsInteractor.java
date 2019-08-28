package com.snape.shivichu.simplemvp.Home;

import android.os.Handler;

import java.util.Arrays;
import java.util.List;

public class FindItemsInteractor {

    interface OnFinishedListener {
        void onFinished(List<String> items);
    }

    public void findItems(final OnFinishedListener listener) {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                listener.onFinished(createArrayList());
            }
        }, 2000);

    }

    private List<String> createArrayList() {
        return Arrays.asList(
                "ItemView 1",
                "ItemView 2",
                "ItemView 3",
                "ItemView 4",
                "ItemView 5",
                "ItemView 6",
                "ItemView 7",
                "ItemView 8",
                "ItemView 9",
                "ItemView 10",
                "ItemView 11",
                 "ItemView 12",
                "ItemView 13",
                "ItemView 14",
                "ItemView 15"
        );
    }
}
