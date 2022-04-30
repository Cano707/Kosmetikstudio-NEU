/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mycompany.praktikum1_neu;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author cano
 */
@Named(value = "userManager")
@RequestScoped
public class UserManager implements Serializable {
    
    @Inject
    private Database db;

    /**
     * Creates a new instance of UserManager
     */
    public UserManager() {
    }
    
    @PostConstruct
    public void init() {
        
    }
    
    public void editUser(String salutation, String name, String surname, String email, String phone, String username, String password, String role) {
        if(salutiation)
    }
    
}
