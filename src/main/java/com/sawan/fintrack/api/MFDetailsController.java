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
public class MFDetailsController {

    @RequestMapping("/fetchNav")
    public String fetchNav(){

        String ret = "issue in api call";
        AsyncHttpClient client = new DefaultAsyncHttpClient();
        Response response = client.prepare("GET", "https://latest-mutual-fund-nav.p.rapidapi.com/fetchLatestNAV")
                .setHeader("x-rapidapi-host", "latest-mutual-fund-nav.p.rapidapi.com")
                .setHeader("x-rapidapi-key", "5440505a66mshdf3a45d9d3424cep14f806jsn37fe479ece23")
                .execute()
                .toCompletableFuture()
                .join();

        try {
            client.close();

            ObjectMapper objectMapper = new ObjectMapper();
            List<FetchNavRes> fetchNavRes = objectMapper.readValue(response.getResponseBody(),
                    new TypeReference<List<FetchNavRes>>(){});

            return fetchNavRes.get(0).getSchemaName();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ret;
    }
}



 /*
            String json = "{ \"color\" : \"Black\", \"type\" : \"FIAT\" }";
            JsonNode jsonNode = objectMapper.readTree(json);
            String color = jsonNode.get("color").asText();
            // Output: color -> Black
             */
// json to java
            /*String json = "{ \"color\" : \"Black\", \"type\" : \"BMW\" }";
            Car car = objectMapper.readValue(json, Car.class);
            String jsonCarArray =
              "[{ \"color\" : \"Black\", \"type\" : \"BMW\" }, { \"color\" : \"Red\", \"type\" : \"FIAT\" }]";
            List<Car> listCar = objectMapper.readValue(jsonCarArray, new TypeReference<List<Car>>(){});
            String json = "{ \"color\" : \"Black\", \"type\" : \"BMW\" }";
            Map<String, Object> map
              = objectMapper.readValue(json, new TypeReference<Map<String,Object>>(){});
            */
//java to json
            /*
            ObjectMapper objectMapper = new ObjectMapper();
            Car car = new Car("yellow", "renault");
            objectMapper.writeValue(new File("target/car.json"), car);
             */