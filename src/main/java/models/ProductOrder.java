/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import models.Product;
import java.util.Date;

/**
 *
 * @author cano
 */
public class ProductOrder  {
    private Product product;
    private int amount;
    private Date deliviery;

    public ProductOrder(Product product, int amount, Date date) {
        this.product = product;
        this.amount = amount;
        this.deliviery = date;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return deliviery;
    }

    public void setDate(Date date) {
        this.deliviery = date;
    }



}
