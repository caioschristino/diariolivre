package com.caiodev.diario.diariolivreoficial.SplashScreen;

import java.util.List;

/**
 * Created by CaioSChristino on 07/10/16.
 */

public interface SplashtemsInteractor {
    interface OnFinishedListener {
        void onFinished(List<String> items);

        void onError(String message);
    }

    void findItems(OnFinishedListener listener);
}