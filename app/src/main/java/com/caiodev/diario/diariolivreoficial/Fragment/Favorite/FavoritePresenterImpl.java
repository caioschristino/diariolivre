package com.caiodev.diario.diariolivreoficial.Fragment.Favorite;

import android.content.Context;

import com.caiodev.diario.diariolivreoficial.Model.Doc;
import com.caiodev.diario.diariolivreoficial.Model.Response;

import java.util.List;

/**
 * Created by CaioSChristino on 07/10/16.
 */

public class FavoritePresenterImpl implements FavoritePresenter, FindItemsInteractor.OnFinishedListener {
    private FavoriteView favoriteView;
    private FindItemsInteractor findItemsInteractor;

    public FavoritePresenterImpl(FavoriteView favoriteView) {
        this.favoriteView = favoriteView;
        findItemsInteractor = new FindItemsInteractorImpl();
    }

    @Override
    public void onResume(Context context) {
        if (favoriteView != null) {
            favoriteView.showProgress();
        }
        findItemsInteractor.findItems(this, context);
    }

    @Override
    public void onItemClicked(int position) {
        if (favoriteView != null) {
            favoriteView.showMessage(String.format("Position %d clicked", position + 1));
        }
    }

    @Override
    public void onDestroy() {
        favoriteView = null;
    }

    @Override
    public void reload(Context context) {
        findItemsInteractor.findItems(this, context);
    }

    @Override
    public void onFinished(List<Doc> docs) {
        if (favoriteView != null) {
            favoriteView.setItems(docs);
            favoriteView.hideProgress();
        }
    }

    @Override
    public void onError(String message) {
        if (favoriteView != null) {
            favoriteView.showMessage(message);
            favoriteView.hideProgress();
        }
    }
}