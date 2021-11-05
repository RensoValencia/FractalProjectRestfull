package com.fracal.company.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Document(collection = "orders")
public class Order {

    public static final int CITY_TAX = 10;
    public static final int COUNTRY_TAX = 5;
    public static final int STATE_TAX = 8;
    public static final int FEDERAL_TAX = 2;


    @Id
    public String id;
    public String status;
    public String date;
    public String customer;

    public double taxes_amount;//
    private double total_amount;
    @Transient
    private double sub_total;//Subtotal = $100

    public double getCityTax() {return this.sub_total * CITY_TAX / 100;}
    public double getCountryTax() {return this.sub_total * COUNTRY_TAX / 100;}
    public double getStateTax() {return this.sub_total * STATE_TAX / 100;}
    public double getFederalTax() {return this.sub_total * FEDERAL_TAX / 100;}

    //You need to iterate the list of all order items of the buying
    public void getSubTotal(List<Double> listUnitPrice) {
        sub_total = listUnitPrice.stream().reduce(Double::sum).get();
    }

    public double getTotal_taxes() {//Total taxes = $10 + $5.5 + $9.24 + $2.49= $27.23
        return this.getCityTax() + this.getCountryTax() + this.getStateTax() + this.getFederalTax();
    }

    public double getTotal () { return this.getTotal_taxes() + this.sub_total;} // Total= $127.23

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public double getTaxes_amount() {
        return taxes_amount;
    }

    public void setTaxes_amount(double taxes_amount) {
        this.taxes_amount = taxes_amount;
    }

    public double getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(double total_amount) {
        this.total_amount = total_amount;
    }
}