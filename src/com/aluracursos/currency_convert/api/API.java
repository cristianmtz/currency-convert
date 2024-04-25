package com.aluracursos.currency_convert.api;


import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class API {

    public ExchangeRate getExchangeRate(String base_code){

        URI uri = URI.create("https://v6.exchangerate-api.com/v6/842892f29a0d50cad704314f/latest/" + base_code);

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), ExchangeRate.class);
        } catch (Exception e) {
            throw new RuntimeException("error");
        }
    }


}
