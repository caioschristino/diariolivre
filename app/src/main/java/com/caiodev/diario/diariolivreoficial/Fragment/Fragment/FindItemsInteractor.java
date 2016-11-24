package com.caiodev.diario.diariolivreoficial.Fragment.Fragment;

import android.content.Context;

import com.caiodev.diario.diariolivreoficial.Model.Response;

/**
 * Created by CaioSChristino on 07/10/16.
 */

public interface FindItemsInteractor {
    interface OnFinishedListener {
        void onFinished(Response response);

        void onError(String message);
    }

    void findItems(OnFinishedListener listener, Context context);
}