package com.caiodev.diario.diariolivreoficial.Fragment.Fragment;

import android.content.Context;

/**
 * Created by CaioSChristino on 07/10/16.
 */

public interface HomePresenter {
    void onResume(Context context);

    void onItemClicked(int position);

    void onDestroy();
}