package com.caiodev.diario.diariolivreoficial.SplashScreen;

import com.caiodev.diario.diariolivreoficial.Model.Response;

import java.util.List;

/**
 * Created by CaioSChristino on 07/10/16.
 */

public interface SplashView {
    void showProgress();

    void hideProgress(Response response);

    void showMessage(String message);
}
