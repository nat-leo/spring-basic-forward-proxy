# Getting Started

This Spring Boot app is a minimal forward proxy for NewsAPI. It exposes a local endpoint (/proxy/top-headlines) that accepts the same query parameters as NewsAPI’s /v2/top-headlines, then forwards the request to NewsAPI using a server-side RestClient. The NewsAPI key is never sent by the client; it’s injected from configuration and attached as an X-Api-Key header on outbound requests, so you can keep credentials private while centralizing request routing through your own API.

Go to https://newsapi.org and get an API Key.

Run `export NEWS_API_KEY=<YOUR_API_KEY_HERE>`
Run `./gradlew bootRUN`

Use `curl "http://localhost:8080/proxy/top-headlines?country=us"` to test the application. Success looks liek this:

```
{"status":"ok","totalResults":35,"articles":[{"source":{"id":null,"name":"Collegefootballplayoff.com"},"author":null,"title":"Playoff Quarterfinal at the Goodyear Cotton Bowl Classic Recap - College Football Playoff","description":"Playoff Quarterfinal at the Goodyear Cotton Bowl Classic Recap","url":"https://collegefootballplayoff.com/sports/2026/1/1/QF-Cotton-recap.aspx","urlToImage":"https://s3.amazonaws.com/sidearmfiles/logos/acc/Miami.png","publishedAt":"2026-01-01T21:00:00Z","content":"Kickoff Time:6:41 p.m. CT\r\nARLINGTON, Texas (AP) Keionte Scott peeked over at the Miami sideline to see the reaction of his teammates as he sprinted 72 yards untouched for a touchdown returning an in… [+4656 chars]"},{"source":{"id":null,"name":"NPR"},"author":"","title":"Congress failed to extend Obamacare subsidies. This Democrat says Trump can save them - NPR","description":"Sen. Peter Welch, D-Vt., says he thinks the Senate can pass a \"retroactive\" Affordable Care Act subsidy extension, but \"we need President Trump.\"","url":"https://www.npr.org/2026/01/01/g-s1-104216/obamacare-subsidies-congress-peter-welch","urlToImage":"https://npr.brightspotcdn.com/dims3/default/strip/false/crop/5033x2831+0+262/resize/1400/quality/100/format/jpeg/?url=http%3A%2F%2Fnpr-brightspot.s3.amazonaws.com%2F37%2F4f%2F4485a115449ab4f0d194beb93fb9%2Fap25350842286467.jpg","publishedAt":"2026-01-01T20:48:39Z","content":"Millions of Americans are facing higher health care premiums in the new year after Congress allowed Affordable Care Act subsidies to expire. But earlier this week, a bipartisan group of senators work… [+3037 chars]"}, ... ]}
```

### Reference Documentation for Spring Boot
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/4.0.1/gradle-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/4.0.1/gradle-plugin/packaging-oci-image.html)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

