/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author cano
 */

public class Product extends Item {
    private int stock;

    public Product(int stock, String name, String description, float price, int id) {
        super(name, description, price, id);
        this.stock = stock;
    }

    
    
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
