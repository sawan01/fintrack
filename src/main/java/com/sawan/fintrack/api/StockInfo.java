package com.sawan.fintrack.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sawan.fintrack.pojo.FetchNavRes;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClient;
import org.asynchttpclient.Response;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class StockInfo {

    @RequestMapping("/stock")
    public String stockDetail(){

        String ret = "issue in api call";
        AsyncHttpClient client = new DefaultAsyncHttpClient();
        Response response = client.prepare("GET", "https://yfapi.net/v6/finance/quote?region=IN&lang=en&symbols=TCS.NS")
                .setHeader("accept", "application/json")
                .setHeader("X-API-KEY", "yBtloMnG3a2Wa8E6pljvT2WZxf6fBhDL7cDWkAAT")
                .execute()
                .toCompletableFuture()
                .join();

        try {
            client.close();

            ObjectMapper objectMapper = new ObjectMapper();
           // List<FetchNavRes> fetchNavRes = objectMapper.readValue(response.getResponseBody(),
              //      new TypeReference<List<FetchNavRes>>(){});

            return response.getResponseBody();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ret;
    }
}
