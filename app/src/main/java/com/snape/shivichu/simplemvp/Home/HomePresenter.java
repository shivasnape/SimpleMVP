/*
 *
 *  * Copyright (C) 2018 Antonio Leiva Gordillo.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *      http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package com.snape.shivichu.simplemvp.Home;

import java.util.List;

class HomePresenter {

    private HomeView mHomeView;
    private FindItemsInteractor mFindItemsInteractor;

    HomePresenter(HomeView homeView, FindItemsInteractor findItemsInteractor) {
        this.mHomeView = homeView;
        this.mFindItemsInteractor = findItemsInteractor;
    }

    void onResume() {
        if (mHomeView != null) {
            mHomeView.showProgress();
        }

        mFindItemsInteractor.findItems(this::onFinished);
    }

    void onItemClicked(String item) {
        if (mHomeView != null) {
            mHomeView.showMessage("You have clicked "+String.format("%s", item));
        }
    }

    void onDestroy() {
        mHomeView = null;
    }

    public void onFinished(List<String> items) {
        if (mHomeView != null) {
            mHomeView.setItems(items);
            mHomeView.hideProgress();
        }
    }

    public HomeView getmHomeView() {
        return mHomeView;
    }
}
