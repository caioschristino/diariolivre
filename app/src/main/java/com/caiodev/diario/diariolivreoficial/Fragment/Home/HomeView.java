package com.caiodev.diario.diariolivreoficial.Fragment.Home;

import com.caiodev.diario.diariolivreoficial.Model.Response;
import com.caiodev.diario.diariolivreoficial.Service.Request.ResultRequest;

import java.util.List;

/**
 * Created by CaioSChristino on 07/10/16.
 */

public interface HomeView {
    void showProgress();

    void hideProgress();

    void setItems(Response response);

    void showMessage(String message);
}