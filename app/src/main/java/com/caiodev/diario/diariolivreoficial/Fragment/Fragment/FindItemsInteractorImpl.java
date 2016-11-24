package com.caiodev.diario.diariolivreoficial.Fragment.Fragment;

import android.content.Context;

import com.caiodev.diario.diariolivreoficial.SessionManager;

/**
 * Created by CaioSChristino on 07/10/16.
 */

public class FindItemsInteractorImpl implements FindItemsInteractor {

    @Override
    public void findItems(final OnFinishedListener listener, Context context) {
        com.caiodev.diario.diariolivreoficial.Model.Response response = ((SessionManager) context).getSessionResponse();
        if (response == null) {
            listener.onError("Erro inesperado. Impossível abrir o aplicativo..");
            return;
        }

        listener.onFinished(response);
    }
}