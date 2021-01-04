package com.shopapp.lamaria.models;

public class Product {

    private long product_id;
    private String product_name;
    private String category_id;
    private String category_name;
    private int product_price;
    private String product_status;
    private String product_image;
    private String product_description;
    private String currency_code;
    private double tax;


    public long getProduct_id() {
        return product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public String getCategory_id() {
        return category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public int getProduct_price() {
        return product_price;
    }

    public String getProduct_status() {
        return product_status;
    }

    public String getProduct_image() {
        return product_image;
    }

    public String getProduct_description() {
        return product_description;
    }

    public String getCurrency_code() {
        return currency_code;
    }

    public double getTax() {
        return tax;
    }


}