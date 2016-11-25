package com.caiodev.diario.diariolivreoficial.Adapter;

import com.caiodev.diario.diariolivreoficial.Model.Doc;
import com.caiodev.diario.diariolivreoficial.Model.Response;

/**
 * Created by CaioSChristino on 23/11/16.
 */

public interface IAdapterOnClickListener {
    void onShareItem(Doc doc);

    void onLikeItem(Doc doc);

    void onClickItem(Doc doc);

    boolean isFavorite(String id);
}