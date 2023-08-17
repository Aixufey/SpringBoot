package com.rinseo.learnspringboot;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * Pattern: Rest Controller is handling HTTP requests and acting as a bridge between HTTP requests and business service.
 * HTTP means URL, HTTP method, and HTTP response status code.
 *
 */
@RestController
public class CurrencyConfigurationController {

    @Autowired
    private CurrencyServiceConfiguration configBean;

    @RequestMapping("/currency-configuration")
    public CurrencyServiceConfiguration getAll() {
        return configBean;
    }
}
