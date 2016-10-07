package com.caiodev.diario.diariolivreoficial;

import java.util.List;

/**
 * Created by CaioSChristino on 07/10/16.
 */

public interface MainView {
    void showProgress();

    void hideProgress();

    void setItems(List<String> items);

    void showMessage(String message);
}