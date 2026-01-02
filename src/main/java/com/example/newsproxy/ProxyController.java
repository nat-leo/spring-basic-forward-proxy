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

    Enumeration<String> names = request.getParameterNames();
    while (names.hasMoreElements()) {
      String name = names.nextElement();
      for (String value : request.getParameterValues(name)) {
        uri.queryParam(name, value);
      }
    }

    return newsApi.get()
        .uri(uri.build(true).toUriString())
        .retrieve()
        .body(String.class);
  }
}
