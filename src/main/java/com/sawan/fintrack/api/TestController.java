package com.sawan.fintrack.api;

import com.sun.deploy.net.HttpRequest;
import com.sun.deploy.net.HttpResponse;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClient;
import org.asynchttpclient.Response;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.net.www.http.HttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;

@RestController
public class TestController {

    @RequestMapping("/test")
    public String test(){
        try {

            URL url = new URL("https://weatherapi-com.p.rapidapi.com/current.json?q=%3CREQUIRED%3E");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }

            conn.disconnect();

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }
        return null;
    }

    @RequestMapping("/test2")
    public String test2(){
        /*HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://latest-mutual-fund-nav.p.rapidapi.com/fetchAllSchemeTypes"))
                .header("x-rapidapi-host", "latest-mutual-fund-nav.p.rapidapi.com")
                .header("x-rapidapi-key", "SIGN-UP-FOR-KEY")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());*/

        String ret = "in there";
        AsyncHttpClient client = new DefaultAsyncHttpClient();
        Response response = client.prepare("GET", "https://latest-mutual-fund-nav.p.rapidapi.com/fetchAllSchemeNames")
                .setHeader("x-rapidapi-host", "latest-mutual-fund-nav.p.rapidapi.com")
                .setHeader("x-rapidapi-key", "5440505a66mshdf3a45d9d3424cep14f806jsn37fe479ece23")
                .execute()
                .toCompletableFuture()
                .join();

        try {
            client.close();
            String str =  response.getResponseBody().replaceAll("\\[","")
                    .replaceAll("\\]","").replaceAll("\"","");
            String[] arr = str.split(",");
            //for (String s : arr) {
                AsyncHttpClient client1 = new DefaultAsyncHttpClient();
                Response res = client1.prepare("GET", "https://latest-mutual-fund-nav.p.rapidapi.com/fetchLatestNAV?SchemeType=All")
                        .setHeader("x-rapidapi-host", "latest-mutual-fund-nav.p.rapidapi.com")
                        .setHeader("x-rapidapi-key", "5440505a66mshdf3a45d9d3424cep14f806jsn37fe479ece23")
                        .execute()
                        .toCompletableFuture().join();
// this one giving whole list above call not required
                client1.close();
            //}
            return arr[0]+ "  :  " +res.getResponseBody();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ret;
    }
}
