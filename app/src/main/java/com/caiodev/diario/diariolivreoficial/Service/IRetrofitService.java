package com.caiodev.diario.diariolivreoficial.Service;

import com.caiodev.diario.diariolivreoficial.Model.Response;
import com.caiodev.diario.diariolivreoficial.Service.Request.ResultRequest;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by CaioSChristino on 07/10/16.
 */

public interface IRetrofitService {
    String SERVICE_ENDPOINT = "http://devcolab.each.usp.br";

    @GET("/do/catalog.json")
    Call<ResultRequest> GetDoc(@Query("facet") String facet);

    @GET("/do/catalog.json")
    Call<ResultRequest> GetHome();
}