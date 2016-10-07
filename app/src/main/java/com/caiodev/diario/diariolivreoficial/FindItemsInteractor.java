package com.caiodev.diario.diariolivreoficial;

import java.util.List;

/**
 * Created by CaioSChristino on 07/10/16.
 */

public interface FindItemsInteractor {
    interface OnFinishedListener {
        void onFinished(List<String> items);
    }

    void findItems(OnFinishedListener listener);
}