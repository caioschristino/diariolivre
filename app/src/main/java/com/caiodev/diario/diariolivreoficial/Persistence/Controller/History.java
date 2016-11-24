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
        historyLike.createOrUpdate(Arrays.asList(doc));
    }

    public List<Doc> getAll() {
        return historyLike.getAll();
    }

    public Doc findByName(String name) {
        return historyLike.get(Doc.TITLE, name).get(0);
    }
}
