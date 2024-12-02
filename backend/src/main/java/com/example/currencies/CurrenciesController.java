package com.example.currencies;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CurrenciesController {
    @PostMapping("/currencies/get-current-currency-value-command")
    public double getCurrentCurrencyValue(@RequestBody CurrencyRequest currencyRequest) {
        return 5.5;
    }
    
    @GetMapping("/currencies/requests")
    public List<DataRequest> getAllRequests() {
        return null;
    } 
}
