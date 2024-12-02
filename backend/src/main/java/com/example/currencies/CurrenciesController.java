package com.example.currencies;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CurrenciesController {
    @PostMapping("/currencies/get-current-currency-value-command")
    public double sendRequest(@RequestBody DataRequest currencyRequest) {
        return 5.5;
    }
    
    @GetMapping("/currencies/requests")
    public List<DataRequest> getAllRequests() {
        List<DataRequest> requests = new ArrayList<>();
        return requests;
    } 
}
