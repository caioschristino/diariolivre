package com.caiodev.diario.diariolivreoficial.Fragment.Fragment;

import com.caiodev.diario.diariolivreoficial.Model.Response;

/**
 * Created by CaioSChristino on 07/10/16.
 */

public interface HomeView {
    void showProgress();

    void hideProgress();

    void setItems(Response response);

    void showMessage(String message);
}