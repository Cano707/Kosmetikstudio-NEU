/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import models.Service;
import models.ServiceOrder;
import models.ProductOrder;
import models.Product;
import manager.SessionManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author Onur-Can Yaman
 * @version 1.0
 * 
 * Einkaufswagen, der die von den Nutzer ausgewählten Produkte über die Session 
 * hinweg speichert und die Bestellung in Auftrag gibt.
 */
@Named(value = "shoppingCart")
@SessionScoped
public class ShoppingCart implements Serializable {
    private List<ProductOrder> productList;
    private List<ServiceOrder> serviceList;
    private float priceSum;
    private float priceSumProducts;
    private float priceSumServices;
    private ProductOrder selectedProductOrder;

    private int amount; 
    private Date date;
    private String time;

    @Inject
    SessionManager session;


    /**
     * Creates a new instance of ShoppingCart
     */
    public ShoppingCart() {
    }
    
    @PostConstruct
    public void init() {
        productList = new ArrayList<>();
        serviceList = new ArrayList<>();
        priceSum = 0f;
        priceSumProducts = 0f;
        priceSumServices = 0f;
    }
    
    /**
     * Gibt die Bestellung im Auftrag, falls der Nutzer eingeloggt i
     * @return 
     */
    public String order() {
        if(session.isLoggedIn()) {
            return "index";
        }
        return "signin";
    }
    
    
    /**
     * Fügt ein Produkt zum Einkaufswagen hinzu
     * @param product: Das ausgewählte Produkt
     */
    public void addProductToCart(Product product) {
        System.out.println("AMOUNT: " + amount);
        if(product.getStock() - amount >= 0) {
            product.setStock(product.getStock()-amount);

            ProductOrder pOrder = new ProductOrder(product, amount, date);
            productList.add(pOrder);
            priceSumProducts = priceSumProducts + product.getPrice() * amount;
            priceSum = priceSum + product.getPrice() * amount;
        }
        
    }
    
    /**
     * Fügt einene Service zum Einkaufswagen hinzu
     * @param service: Der ausgewählte Seite 
     */
    public void addServiceToCart(Service service) {
        ServiceOrder sOrder = new ServiceOrder(service, date, time);
        serviceList.add(sOrder);
        priceSumServices = priceSumServices + service.getPrice() ;
        priceSum = priceSum + service.getPrice();
    }

    public float getPriceSumProducts() {
        return priceSumProducts;
    }

    public void setPriceSumProducts(float priceSumProducts) {
        this.priceSumProducts = priceSumProducts;
    }

    public float getPriceSumServices() {
        return priceSumServices;
    }

    public void setPriceSumServices(float priceSumServices) {
        this.priceSumServices = priceSumServices;
    }
    
    
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public List<ProductOrder> getProductList() {
        for(ProductOrder pOrder : productList) {
            System.out.println(pOrder.getProduct().getName());
        }
        return productList;
    }

    public void setProductList(List<ProductOrder> productList) {
        this.productList = productList;
    }

    public List<ServiceOrder> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<ServiceOrder> serviceList) {
        this.serviceList = serviceList;
    }
    public float getPriceSum() {
        return priceSum;
    }

    public void setPriceSum(float priceSum) {
        this.priceSum = priceSum;
    }
    
        
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ProductOrder getSelectedProductOrder() {
        return selectedProductOrder;
    }

    public void setSelectedProductOrder(ProductOrder selectedProductOrder) {
        this.selectedProductOrder = selectedProductOrder;
    }
 
}
