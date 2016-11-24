package com.caiodev.diario.diariolivreoficial.SplashScreen;

import com.caiodev.diario.diariolivreoficial.SessionManager;

/**
 * Created by CaioSChristino on 07/10/16.
 */

public interface SplashPresenter {
    void onResume();

    void onItemClicked(int position);

    void onDestroy();
}
