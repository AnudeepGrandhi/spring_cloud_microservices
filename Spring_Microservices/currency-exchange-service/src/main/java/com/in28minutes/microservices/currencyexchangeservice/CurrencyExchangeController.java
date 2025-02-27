package com.in28minutes.microservices.currencyexchangeservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

    private Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);

    @Autowired
    private Environment environment;

    @Autowired
    private CurrencyExchangeRepository repository;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retreiveExchangeValue(@PathVariable String from, @PathVariable String to) {

        logger.info("retrieveExchangeValue called with {} to {}", from, to);
        //CurrencyExchange currencyExchange = new CurrencyExchange(10001L, from, to, BigDecimal.valueOf(50));
        CurrencyExchange currencyExchange = repository.findByFromAndTo(from, to);
        if(currencyExchange == null)
            throw new RuntimeException("Unable to fetch currency exchange value for " + from + " and "+ to);
        String port = environment.getProperty("local.server.port");
        currencyExchange.setEnvironment(port);
        return currencyExchange;
    }
}
