package com.example.currencies;

import java.util.Date;

public class DataRequest {
    private String currency;
    private String name;
    private Date date;
    private float value;
 
    public DataRequest() {
    }

    public DataRequest(String currency, String name, Date date, float value) {
        this.currency = currency;
        this.name = name;
        this.date = date;
        this.value = value;
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
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public float getValue() {
        return value;
    }
    public void setValue(float value) {
        this.value = value;
    }   
}
