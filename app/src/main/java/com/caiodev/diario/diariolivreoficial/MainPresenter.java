package com.caiodev.diario.diariolivreoficial;

/**
 * Created by CaioSChristino on 07/10/16.
 */

public interface MainPresenter {
    void onResume();

    void onItemClicked(int position);

    void onDestroy();
}