package com.example.currencies;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins="http://localhost:4200/")
public class CurrenciesController {
    private final CurrenciesService currenciesService;

    public CurrenciesController(CurrenciesService currenciesService){
        this.currenciesService = currenciesService;
    }

    @PostMapping("/currencies/get-current-currency-value-command")
    public float getCurrentCurrencyValue(@RequestBody CurrencyRequest currencyRequest) {
        float value = this.currenciesService.getCurrencyValueFromNbp(currencyRequest);

        this.currenciesService.sendRequestToDatabase(currencyRequest, value);

        return value;
    }
    
    @GetMapping("/currencies/requests")
    public List<DataRequest> getAllRequests() {
        List<DataRequest> requests = this.currenciesService.getAllRequests();
        return requests;
    } 
}
