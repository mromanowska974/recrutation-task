package com.example.currencies;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CurrenciesService {
    private final CurrenciesRepository currenciesRepository;

    public CurrenciesService(CurrenciesRepository currenciesRepository){
        this.currenciesRepository = currenciesRepository;
    }

    public float getCurrencyValueFromNbp(CurrencyRequest currencyRequest){
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
       
        return result;
    }
    
    public void sendRequestToDatabase(CurrencyRequest currencyRequest, float result){
        DataRequest dataRequest = new DataRequest(currencyRequest.getCurrency(), new Date(), currencyRequest.getName(), result);

        this.currenciesRepository.save(dataRequest);
    }

    public List<DataRequest> getAllRequests(){
        return this.currenciesRepository.findAll();
    }
}
