package com.caiodev.diario.diariolivreoficial.SplashScreen;

import com.caiodev.diario.diariolivreoficial.Model.Response;
import com.caiodev.diario.diariolivreoficial.SessionManager;

import java.util.List;

/**
 * Created by CaioSChristino on 07/10/16.
 */

public class SplashPresenterImpl implements SplashPresenter, SplashtemsInteractor.OnFinishedListener {
    private SplashView splashView;
    private SplashtemsInteractor splashItemsInteractor;

    public SplashPresenterImpl(SplashView sView) {
        this.splashView = sView;
        splashItemsInteractor = new SplashItemsInteractorImpl();
    }

    @Override
    public void onResume() {
        if (splashView != null) {
            splashView.showProgress();
        }
        splashItemsInteractor.findItems(this);
    }

    @Override
    public void onItemClicked(int position) {
        if (splashView != null) {
            splashView.showMessage(String.format("Position %d clicked", position + 1));
        }
    }

    @Override
    public void onDestroy() {
        splashView = null;
    }

    @Override
    public void onFinished(Response response) {
        if (splashView != null) {
            splashView.hideProgress(response);
        }
    }

    @Override
    public void onError(String message) {
        if (splashView != null) {
            splashView.showMessage(message);
            splashView.hideProgress(null);
        }
    }
}
