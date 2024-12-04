package com.example.currencies;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
@CrossOrigin(origins="http://localhost:4200/")
public class CurrenciesController {
    @PostMapping("/currencies/get-current-currency-value-command")
    public float getCurrentCurrencyValue(@RequestBody CurrencyRequest currencyRequest) {
        String nbpApiUrl = "https://api.nbp.pl/api/exchangerates/rates/A/"+currencyRequest.getCurrency();

        RestTemplate restTemplate = new RestTemplate();
        String resultStr = restTemplate.getForObject(nbpApiUrl, String.class);

        ObjectMapper mapper = new ObjectMapper();

        JsonNode resultJson;
        float result = 0;

        try {
            resultJson = mapper.readTree(resultStr);
            resultJson = resultJson.get("rates");

            if(resultJson.isArray()){
                for (JsonNode obj : resultJson){
                    result = Float.parseFloat(obj.get("mid").toString());
                }
            }      
        } catch (Exception e) {
            return 0;
        }

        DataRequest dataRequest = new DataRequest(currencyRequest.getCurrency(), currencyRequest.getName(), new Date(), result);

        return result;
    }
    
    @GetMapping("/currencies/requests")
    public List<DataRequest> getAllRequests() {
        List<DataRequest> requests = new ArrayList<>();
        return requests;
    } 
}
