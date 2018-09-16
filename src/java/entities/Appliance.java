/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;

/**
 *
 * @author RenJie
 */
public class Appliance {

    Integer resid;
    Date date;
    Integer usagehour;
    Double usage;
    Double fridgeUsage;
    Double airconUsage;
    Double washUsage;
    String address;
    String postcode;
    Double temperature;
    
    public Appliance() {
    }
    
    //4.1 & 4.2 & 4.4
    public Appliance(Integer resid, Date date, Integer usagehour, Double usage) {
        this.resid = resid;
        this.date = date;
        this.usagehour = usagehour;  
        this.usage = usage;
    }

    //4.2
    /*
    public Appliance(Integer resid, Date date, Integer usagehour, Double fridgeUsage, Double airconUsage, Double washUsage) {
        this.resid = resid;
        this.date = date;
        this.usagehour = usagehour;
        this.fridgeUsage = fridgeUsage;
        this.airconUsage = airconUsage;
        this.washUsage = washUsage;
    } */
    
    
    //4.3 
    public Appliance(Integer resid, String address, String postcode, Double usage) {
        this.usage = usage;
        this.address = address;
        this.postcode = postcode;
        this.resid = resid;
    }
    
    //5.1

    public Appliance(Integer resid, Double washUsage, Double fridgeUsage, Double airconUsage) {
        this.resid = resid;
        this.fridgeUsage = fridgeUsage;
        this.airconUsage = airconUsage;
        this.washUsage = washUsage;
    }
    
    //5.2.1

    public Appliance(Integer resid, Date date, Integer usagehour, Double temperature, Double usage) {
        this.resid = resid;
        this.date = date;
        this.usagehour = usagehour;
        this.usage = usage;
        this.temperature = temperature;
    }
    
    //5.2.2

    public Appliance(Integer resid, Double temperature, Double usage) {
        this.resid = resid;
        this.usage = usage;
        this.temperature = temperature;
    }
    
    
    
    
    public Integer getResid() {
        return resid;
    }

    public Date getDate() {
        return date;
    }

    public Integer getUsagehour() {
        return usagehour;
    }


    public void setResid(Integer resid) {
        this.resid = resid;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setUsagehour(Integer usagehour) {
        this.usagehour = usagehour;
    }

    public Double getFridgeUsage() {
        return fridgeUsage;
    }

    public void setFridgeUsage(Double fridgeUsage) {
        this.fridgeUsage = fridgeUsage;
    }

    public Double getAirconUsage() {
        return airconUsage;
    }

    public void setAirconUsage(Double airconUsage) {
        this.airconUsage = airconUsage;
    }

    public Double getWashUsage() {
        return washUsage;
    }

    public void setWashUsage(Double washUsage) {
        this.washUsage = washUsage;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public Double getUsage() {
        return usage;
    }

    public void setUsage(Double usage) {
        this.usage = usage;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }
    
    

}
