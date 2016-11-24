package com.caiodev.diario.diariolivreoficial;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.caiodev.diario.diariolivreoficial.Model.Doc;
import com.caiodev.diario.diariolivreoficial.Model.Response;
import com.caiodev.diario.diariolivreoficial.Persistence.DatabaseManager;
/**
 * Created by CaioSChristino on 23/11/16.
 */

public class SessionManager extends Application {
    private Response sessionResponse;
    private Doc sessionDoc;
    private SharedPreferences preferences;

    @Override
    public void onCreate() {
        super.onCreate();
        DatabaseManager.init(this);
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
    }

    public SharedPreferences getPreferences() {
        return preferences;
    }

    public void setSessionResponse(Response response) {
        this.sessionResponse = response;
    }

    public Response getSessionResponse() {
        return this.sessionResponse;
    }

    public void setSessionDoc(Doc doc) {
        this.sessionDoc = doc;
    }

    public Doc getSessionDoc() {
        return this.sessionDoc;
    }
}
