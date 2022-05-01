/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import controller.Database;
import utils.PasswordHashConverter;
import models.User;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
/**
 *
 * @author cano
 */
@Named(value = "registration")
@RequestScoped
public class Registration implements Serializable {
    private static final Logger LOGGER = Logger.getLogger(Registration.class.getName());
    
    private String salutation;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String username;
    private String password;
    
    private PasswordHashConverter phc;
    private FacesContext cxt;
    private List<User> userList;
    
    @Inject
    private Database db;
    
    private HashMap<String, String> salutations;
    
    /**
     * Creates a new instance of Registration
     */
    public Registration() {
        LOGGER.info("Constructor: RegistrationBean");
    }
    
    @PostConstruct
    public void init(){
        LOGGER.info("Init: RegistrationBean");
        cxt = FacesContext.getCurrentInstance();
        userList = db.getUserList();
        phc = new PasswordHashConverter();
        salutations = User.getSaltuations();
    }

    public HashMap<String, String> getSalutations() {
        return salutations;
    }

    public void setSalutations(HashMap<String, String> salutations) {
        this.salutations = salutations;
    }
    
    public String register() {
        cxt = FacesContext.getCurrentInstance();
        User newUser = new User(Database.getUid(), salutation, name, surname, email, phone, username, phc.getPwdHash(password), User.Role.USER);
        String redirect = "?faces-redirect=true";
        
        if(this.userList.isEmpty()) {
            this.userList.add(newUser);
        } else {
            boolean neu = true;
            for(User u : userList) {
                if(u.getUsername().equals(username) || u.getEmail().equals(email)) {
                    neu = false;
                    FacesMessage fm = new FacesMessage("Benutzer existiert bereits!");
                    fm.setSeverity(FacesMessage.SEVERITY_ERROR);
                    cxt.addMessage("registration-notfication-key", fm);
                    LOGGER.info("User already exists");redirect = "";
                }
            }
            if(neu) {
                userList.add(newUser);
                db.setUserList(userList);
                FacesMessage fm = new FacesMessage("Benutzer registriert!");
                fm.setSeverity(FacesMessage.SEVERITY_INFO);
                cxt.addMessage("registration-notfication-key", fm);
                LOGGER.info("User signed up");
                redirect = "signin?faces-redirect=true";
            }
        }
        return redirect;
        
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

    public FacesContext getCxt() {
        return cxt;
    }

    public void setCxt(FacesContext cxt) {
        this.cxt = cxt;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public Database getDb() {
        return db;
    }

    public void setDb(Database db) {
        this.db = db;
    }

    public PasswordHashConverter getPhc() {
        return phc;
    }

    public void setPhc(PasswordHashConverter phc) {
        this.phc = phc;
    }
    

    
    
    
}
