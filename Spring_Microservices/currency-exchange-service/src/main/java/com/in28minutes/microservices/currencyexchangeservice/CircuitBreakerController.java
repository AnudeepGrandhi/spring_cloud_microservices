package com.in28minutes.microservices.currencyexchangeservice;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {

    private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

    ////Retry for temporary failure of APIS
    @GetMapping("sample-api")
    @Retry(name="sample-api", fallbackMethod = "hardcodedResponse")
    public String sampleApi() {
        logger.info("Sample API call is received.");
        ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8000/some-dummy-url",
                String.class);
        return forEntity.getBody();
    }

    ///This is a fallback method to return fallback response in case calling microservice not available.
    ///Should accept a Throwable object otherwise result in error.
    public String hardcodedResponse(Exception ex) {
        return "fallback-response";
    }

    ////Circuit Breaker is returning fallback response without calling API (for continuous request failures)
    @GetMapping("sample-api-breaker")
    @CircuitBreaker(name="default", fallbackMethod = "hardcodedResponse")
    public String sampleApiBreaker() {
        logger.info("Sample API call is received from Circuit Breaker.");
        ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8000/some-dummy-url",
                String.class);
        return forEntity.getBody();
    }

    ///Rate Limiter - To configure no. of API calls in specific duration - in 10s => 2 calls to sample API
    @GetMapping("sample-api-limiter")
    @RateLimiter(name="default")
    public String sampleApiLimiter() {
        logger.info("Sample API call is received from Rate Limiter.");
        return "sample-api-limiter";
    }

    ///Bulkhead - To configure number of concurrent calls for an API
    @GetMapping("sample-api-bulkhead")
    @Bulkhead(name="default")
    public String sampleApiBulkhead() {
        logger.info("Sample API call is received from Bulkhead.");
        return "sample-api-bulkhead";
    }
}
