package com.caiodev.diario.diariolivreoficial.Persistence.DAO.Context;

import android.util.Log;

import com.caiodev.diario.diariolivreoficial.Model.Doc;
import com.j256.ormlite.dao.GenericRawResults;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by caios on 2/20/16.
 */
public class HistoryLike extends SimpleDAO<Doc> {
    public static final String TITLE = "";

    public HistoryLike() {
        super(Doc.class);
    }

    @Override
    public List<Doc> getByQuery(String q) {
        try {
            final GenericRawResults<String[]> rawResults = getHelper().getDocDAO().queryRaw(q);
        } catch (SQLException e) {
            Log.e("==>", e.getMessage());
        }

        return null;
    }
}
