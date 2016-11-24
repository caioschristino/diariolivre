package com.caiodev.diario.diariolivreoficial.Persistence.DAO.Context;

import android.util.Log;

import com.caiodev.diario.diariolivreoficial.Persistence.DatabaseManager;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by caios on 2/29/16.
 */
public abstract class SimpleDAO<T> extends DatabaseManager {
    Dao<T, Integer> dao;

    public SimpleDAO(Class<T> clazz) {
        super();
        DatabaseManager.getInstance();
        try {
            dao = getHelper().getDao(clazz);
        } catch (SQLException e) {
            e.printStackTrace();
            Log.e("==>", e.getMessage());
        }
    }

    public T getLastInsert() {
        QueryBuilder<T, Integer> query = null;
        try {
            query = dao.queryBuilder();
            return query.queryForFirst();
        } catch (SQLException e) {
            Log.e("==>", e.getMessage());
        }
        return null;
    }

    public List<T> getAll() {
        final QueryBuilder<T, Integer> query;
        try {
            query = dao.queryBuilder();
            return query.query();
        } catch (SQLException e) {
            Log.e("==>", e.getMessage());
        }
        return null;
    }

    public List<T> get(String columnName, Object value) {
        final QueryBuilder<T, Integer> query;
        try {
            query = dao.queryBuilder();
            query.where().eq(columnName, value);
            return query.query();
        } catch (SQLException e) {
            Log.e("==>", e.getMessage());
        }
        return null;
    }

    public void createOrUpdate(List<T> o) {
        for (T obj : o) {
            try {
                dao.createOrUpdate(obj);
            } catch (final Exception e) {
                Log.e("==>", e.getMessage());
            }
        }
    }

    public void delete(List<T> o) {
        for (T obj : o) {
            try {
                dao.delete(obj);
            } catch (final Exception e) {
                Log.e("==>", e.getMessage());
            }
        }
    }

    protected abstract List<T> getByQuery(String q);
}
