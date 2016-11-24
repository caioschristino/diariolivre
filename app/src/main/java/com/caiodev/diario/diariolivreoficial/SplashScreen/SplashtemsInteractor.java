package com.caiodev.diario.diariolivreoficial.SplashScreen;

import com.caiodev.diario.diariolivreoficial.Model.Response;
import com.caiodev.diario.diariolivreoficial.SessionManager;

import java.util.List;

/**
 * Created by CaioSChristino on 07/10/16.
 */

public interface SplashtemsInteractor {
    interface OnFinishedListener {
        void onFinished(Response response);

        void onError(String message);
    }

    void findItems(OnFinishedListener listener);
}