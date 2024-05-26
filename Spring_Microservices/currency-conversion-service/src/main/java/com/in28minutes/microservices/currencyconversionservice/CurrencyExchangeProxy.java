package com.in28minutes.microservices.currencyconversionservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

///name should be name of the microservice which we are calling
///urls should be url of the microservice which we are calling
//@FeignClient(name="currency-exchange", url="localhost:8000")
///url needs to be removed if we want Feign client to pick up all the instances of currency exchange service.
@FeignClient(name="currency-exchange")
public interface CurrencyExchangeProxy {

    ////Provide a declaration for the service which we need to call and map the response to Currency Conversion instead of Currency Exchange.
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyConversion retreiveExchangeValue(@PathVariable String from, @PathVariable String to);
}
