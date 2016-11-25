package com.caiodev.diario.diariolivreoficial.Persistence.Controller;

import android.content.Context;

import com.caiodev.diario.diariolivreoficial.Model.Doc;
import com.caiodev.diario.diariolivreoficial.Persistence.DAO.Context.HistoryLike;

import java.util.Arrays;
import java.util.List;

/**
 * Created by caios on 2/20/16.
 */
public class History {
    private HistoryLike historyLike;
    private Context context;

    public History(Context context) {
        this.context = context;
        historyLike = new HistoryLike();
    }

    public void add(Doc doc) {
        doc.setFavorito(true);
        historyLike.createOrUpdate(Arrays.asList(doc));
    }

    public void remove(Doc doc) {
        historyLike.delete(Arrays.asList(doc));
    }

    public List<Doc> getAll() {
        return historyLike.getAll();
    }

    public Doc findById(String id) {
        return historyLike.get(Doc.ID, id).get(0);
    }

    public boolean exist(String id) {
        List<Doc> docs = historyLike.get(Doc.ID, id);
        return (docs == null || docs.size() == 0) ? false : true;
    }
}
