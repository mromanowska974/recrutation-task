package com.example.currencies;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class DataRequest {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String currency;
    private String name;
    private Date date;
    private float currencyValue;
 
    public DataRequest() {
    }

    public DataRequest(Long id, String currency, String name, Date date, float value) {
        this.id = id;
        this.currency = currency;
        this.name = name;
        this.date = date;
        this.currencyValue = value;
    }

    public DataRequest(String currency, Date date, String name, float value) {
        this.currency = currency;
        this.date = date;
        this.name = name;
        this.currencyValue = value;
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
        return currencyValue;
    }
    public void setValue(float value) {
        this.currencyValue = value;
    }   

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
