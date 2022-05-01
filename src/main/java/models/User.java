/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author cano
 */
public class User implements Serializable{
    
    public enum Role {
        USER("User"),
        ADMIN("Admin");
        
        String role;
        
        Role(String role) {
            this.role = role;
        }
        
    }
    
    private static HashMap<String, String> saltuations = new HashMap<String, String>() {{
        put("Herr", "Herr");
        put("Frau", "Frau");
    }};


    private int uid;
    private String salutation;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String username;
    private String password;
    private Role role;
    
    public User() {
        
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        
    }
    
    public User(int uid, String salutation, String name, String surname, String email, String phone, String username, String password, Role role) {
        
        this.uid = uid;
        this.salutation = salutation;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static HashMap<String, String> getSaltuations() {
        return saltuations;
    }

    public static void setSaltuations(HashMap<String, String> saltuations) {
        User.saltuations = saltuations;
    }
    
    

    
}
