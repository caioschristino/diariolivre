package com.caiodev.diario.diariolivreoficial.Fragment.Favorite;

import android.content.Context;

import com.caiodev.diario.diariolivreoficial.Model.Doc;
import com.caiodev.diario.diariolivreoficial.Persistence.Controller.History;
import com.caiodev.diario.diariolivreoficial.SessionManager;

import java.util.List;

/**
 * Created by CaioSChristino on 07/10/16.
 */

public class FindItemsInteractorImpl implements FindItemsInteractor {
    private History history;

    @Override
    public void findItems(final OnFinishedListener listener, Context context) {
        history = new History(context);
        if (history == null) {
            listener.onError("Erro inesperado. Impossível abrir o aplicativo..");
            return;
        }

        List<Doc> docs = history.getAll();
        if (docs == null) {
            listener.onError("Erro inesperado. Impossível abrir o aplicativo..");
            return;
        }
        listener.onFinished(docs);
    }
}