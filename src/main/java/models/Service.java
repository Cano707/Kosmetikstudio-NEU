/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.model.SelectItem;

/**
 *
 * @author cano
 */

public class Service extends Item {
    private boolean available;
    private Map<String, String> times;
    
    public Service(boolean available, String name, String description, float price, int id, HashMap<String, String> times) {
        super(name, description, price, id);
        this.available = available;
        this.times = times;
    }
    
    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Map<String, String> getTimes() {
        return times;
    }

    public void setTimes(Map<String, String> times) {
        this.times = times;
    }

 
}

/*
public class Service {
    private int sid;
    private String name;
    private String description;
    private float price;

    public Service(int sid, String name, String description, float price) {
        this.sid = sid;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    
    
    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    
}
*/