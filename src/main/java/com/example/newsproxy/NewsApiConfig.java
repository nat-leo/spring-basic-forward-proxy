package com.example.newsproxy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestClient;

@Configuration
public class NewsApiConfig {

  @Bean
  RestClient newsApiClient(
    @Value("${newsapi.base-url}") String baseUrl,
    @Value("${newsapi.api-key}") String apiKey
  ) {
    return RestClient.builder()
      .baseUrl(baseUrl)
      .defaultHeader("X-Api-Key", apiKey)
      .defaultHeader(HttpHeaders.ACCEPT, "application/json")
      .build();
  }
}
