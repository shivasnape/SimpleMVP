package com.snape.shivichu.simplemvp.Home;

import java.util.List;

public interface HomeView {

    void showProgress();

    void hideProgress();

    void setItems(List<String> items);

    void showMessage(String message);
}