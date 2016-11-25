package com.caiodev.diario.diariolivreoficial.Fragment.Favorite;

import android.content.Context;

/**
 * Created by CaioSChristino on 07/10/16.
 */

public interface FavoritePresenter {
    void onResume(Context context);

    void onItemClicked(int position);

    void onDestroy();

    void reload(Context context);
}