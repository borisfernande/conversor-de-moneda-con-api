package com.boris.screenmatch.modelos;


import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 *
 * @author BORIS
 */
public class ConsultaApi {    
    
    public MonedaOmdb buscarMoneda(String monedaBase, String monedaConvertir, double monto) {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/f0018974ea306f0d56c66727/pair/" + monedaBase + "/" + monedaConvertir + "/" + monto);
            
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                    .uri(direccion)
                    .build();
           
        try{
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());  
            return new Gson().fromJson(response.body(), MonedaOmdb.class);
        }catch(Exception e){
            throw new RuntimeException("No se encontro la moneda!");
        }  
    }
}



