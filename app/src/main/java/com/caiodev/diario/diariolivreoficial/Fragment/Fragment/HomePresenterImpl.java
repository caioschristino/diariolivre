package com.caiodev.diario.diariolivreoficial.Fragment.Fragment;

import android.content.Context;

import com.caiodev.diario.diariolivreoficial.Model.Response;

/**
 * Created by CaioSChristino on 07/10/16.
 */

public class HomePresenterImpl implements HomePresenter, FindItemsInteractor.OnFinishedListener {
    private HomeView homeView;
    private FindItemsInteractor findItemsInteractor;

    public HomePresenterImpl(HomeView homeView) {
        this.homeView = homeView;
        findItemsInteractor = new FindItemsInteractorImpl();
    }

    @Override
    public void onResume(Context context) {
        if (homeView != null) {
            homeView.showProgress();
        }
        findItemsInteractor.findItems(this, context);
    }

    @Override
    public void onItemClicked(int position) {
        if (homeView != null) {
            homeView.showMessage(String.format("Position %d clicked", position + 1));
        }
    }

    @Override
    public void onDestroy() {
        homeView = null;
    }

    @Override
    public void onFinished(Response response) {
        if (homeView != null) {
            homeView.setItems(response);
            homeView.hideProgress();
        }
    }

    @Override
    public void onError(String message) {
        if (homeView != null) {
            homeView.showMessage(message);
            homeView.hideProgress();
        }
    }
}