package com.caiodev.diario.diariolivreoficial.Fragment.Home;

import android.content.Context;

import com.caiodev.diario.diariolivreoficial.Model.Response;
import com.caiodev.diario.diariolivreoficial.Service.Request.ResultRequest;

import java.util.List;

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