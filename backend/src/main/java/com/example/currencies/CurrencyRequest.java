package com.example.currencies;

public class CurrencyRequest {
    private String currency;
    private String name;

    public CurrencyRequest() {
    }

    public CurrencyRequest(String currency, String name) {
        this.currency = currency;
        this.name = name;
    }
    
    public String getCurrency() {
        return currency;
    }
    public void setCurrency(String currency) {
        this.currency = currency;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
