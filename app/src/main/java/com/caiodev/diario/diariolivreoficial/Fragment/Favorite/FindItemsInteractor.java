package com.caiodev.diario.diariolivreoficial.Fragment.Favorite;

import android.content.Context;

import com.caiodev.diario.diariolivreoficial.Model.Doc;
import com.caiodev.diario.diariolivreoficial.Model.Response;

import java.util.List;

/**
 * Created by CaioSChristino on 07/10/16.
 */

public interface FindItemsInteractor {
    interface OnFinishedListener {
        void onFinished(List<Doc> docs);

        void onError(String message);
    }

    void findItems(OnFinishedListener listener, Context context);
}