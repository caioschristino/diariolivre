package com.caiodev.diario.diariolivreoficial.SplashScreen;

import com.caiodev.diario.diariolivreoficial.Service.IRetrofitService;
import com.caiodev.diario.diariolivreoficial.Service.Request.ResultRequest;
import com.caiodev.diario.diariolivreoficial.Service.ServiceFactory;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by CaioSChristino on 07/10/16.
 */

public class SplashItemsInteractorImpl implements SplashtemsInteractor {

    @Override
    public void findItems(final OnFinishedListener listener) {
        IRetrofitService service = ServiceFactory
                .createRetrofitService(IRetrofitService.class, IRetrofitService.SERVICE_ENDPOINT);

        service.GetHome().enqueue(new Callback<ResultRequest>() {
            @Override
            public void onResponse(Call<ResultRequest> call, Response<ResultRequest> response) {
                if (response.isSuccessful()) {
                    ResultRequest result = response.body();
                    listener.onFinished(null);
                }
            }

            @Override
            public void onFailure(Call<ResultRequest> call, Throwable t) {
                listener.onError(t.getMessage());
            }
        });
    }
}