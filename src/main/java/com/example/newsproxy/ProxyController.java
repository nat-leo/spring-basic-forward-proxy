package com.example.newsproxy;

import jakarta.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class ProxyController {

    private final RestClient newsApi;

    public ProxyController(RestClient newsApiClient) {
        this.newsApi = newsApiClient;
    }

    // Example:
    // GET /proxy/top-headlines?country=us
    // -> GET https://newsapi.org/v2/top-headlines?country=us  (with X-Api-Key header)
    @GetMapping(value = "/proxy/top-headlines", produces = MediaType.APPLICATION_JSON_VALUE)
    public String topHeadlines(HttpServletRequest request) {
        UriComponentsBuilder uri = UriComponentsBuilder.fromPath("/top-headlines");

        /*
        This whole block iteerates through the HTTP headers in the request.

        request.getParameterNames() - I grab all the url parameters from the request

        The double loop is for any parameters that have multiple values. Each are copied
        over into the request that I the backend will send. It's Copy-paste the request 
        over.
        */
        Enumeration<String> names = request.getParameterNames();

        while(names.hasMoreElements()) {
            String name = names.nextElement();
            for (String value : request.getParameterValues(name)) {
                uri.queryParam(name, value);
            }
        }

        /*
        This is the fetch. uri now has all the params, so the get sent over, and
        then I return the body of the response from the external API.
         */
        return newsApi.get()
            .uri(uri.build(true).toUriString())
            .retrieve()
            .body(String.class);
    }

}