package com.caiodev.diario.diariolivreoficial.Fragment.Favorite;

import com.caiodev.diario.diariolivreoficial.Model.Doc;
import com.caiodev.diario.diariolivreoficial.Model.Response;

import java.util.List;

/**
 * Created by CaioSChristino on 07/10/16.
 */

public interface FavoriteView {
    void showProgress();

    void hideProgress();

    void setItems(List<Doc> docs);

    void showMessage(String message);
}