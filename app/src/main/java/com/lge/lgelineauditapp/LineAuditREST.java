package com.lge.lgelineauditapp;

/**
 * Created by jose.filho on 22/01/2018.
 */

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;


public interface LineAuditREST {

    @POST("wsPostItem.php")
    Call<Void> postItem(@Body ClassItemChecklist item);

    @GET("wsListItens.php")
    Call<List<ClassItemChecklist>> getItens();

    @GET("buscar/{id}")
    Call<ClassItemChecklist> getItemById(@Path("id") String id);

    @PUT("editar/{id}")
    Call<Void> updateItem(@Path("id") String id, @Body ClassItemChecklist item);

    @DELETE("remover/{id}")
    Call<Void> removeItem(@Path("id") String id);

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://localhost:85/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
