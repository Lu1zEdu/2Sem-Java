package com.api.service;

import com.api.model.Endereco;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import com.google.gson.Gson;

public class ViaCEPService {

    public Endereco buscarEnderecoPorCEP(String cep) throws Exception {
        String url = "https://viacep.com.br/ws/" + cep + "/json/";

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(url);
            HttpResponse response = httpClient.execute(request);
            String jsonResponse = EntityUtils.toString(response.getEntity());

            Gson gson = new Gson();
            return gson.fromJson(jsonResponse, Endereco.class);
        }
    }
}
