package com.caiodev.diario.diariolivreoficial.SplashScreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;

import com.caiodev.diario.diariolivreoficial.MainActivity;
import com.caiodev.diario.diariolivreoficial.Model.Response;
import com.caiodev.diario.diariolivreoficial.R;
import com.caiodev.diario.diariolivreoficial.SessionManager;

/**
 * Created by CaioSChristino on 07/10/16.
 */

public class SplashActivity extends AppCompatActivity implements SplashView {
    private ProgressBar progressBar;
    private SplashPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        progressBar = (ProgressBar) findViewById(R.id.progress);
        presenter = new SplashPresenterImpl(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress(Response response) {
        if (response != null) {
            ((SessionManager) getApplicationContext()).setSessionResponse(response);

            progressBar.setVisibility(View.INVISIBLE);
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }
    }

    @Override
    public void showMessage(String message) {
        Snackbar.make(progressBar, message, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }
}
