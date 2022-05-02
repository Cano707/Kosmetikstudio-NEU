/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import utils.PasswordHashConverter;
import models.User;
import manager.SessionManager;
import java.io.Serializable;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author Onur-Can Yaman
 * @version 1.0
 * 
 * Login Klasse, die dafür zuständig ist, die Logindaten zu validieren und 
 * den Nutzer bei korrekter Eingabe einzuloggen bzw. bei fehlerhaften Eingaben
 * darüber zu informieren.
 */
@Named(value = "login")
@RequestScoped
public class Login implements Serializable{
    private static final Logger LOGGER = Logger.getLogger(Login.class.getName());
    
    private String username;
    private String password;
    private PasswordHashConverter phc;
    
    @Inject
    private SessionManager session;
    
    @Inject
    private Database db;
    
    /**
     * Creates a new instance of Login
     */
    public Login() {
    }
    
    @PostConstruct
    public void init() {
        phc = new PasswordHashConverter();
    }
    
    /**
     * Gleicht die Logindaten mit den Userdaten in der Datenbank ab und
     * gibt eine entsprechende Rückmeldung bei korrekter bzw. inkorrekter 
     * Eingabe zurück.
     * @return Nächste Seite auf die weitergeleitet werden soll.
     */
    public String login() {
        FacesMessage fm;
        FacesContext cxt = FacesContext.getCurrentInstance();
        for(User u : db.getUserList()) {
            if(u.getPassword().equals(phc.getPwdHash(password)) && u.getUsername().equals(username)) {
                if(u.getRole().equals(User.Role.ADMIN)) {
                    session.setAdmin(true);
                }
                session.getSession().setAttribute("username", username);
                session.getSession().setAttribute("name", u.getName());
                session.setLoggedIn(true);
                fm = new FacesMessage("Anmeldung erfolgreich");
                fm.setSeverity(FacesMessage.SEVERITY_INFO);
                cxt.addMessage("login-notfication-key", fm);
                return "index";
            }
        }
        fm = new FacesMessage("Benutzername oder Password sind falsch");
        fm.setSeverity(FacesMessage.SEVERITY_ERROR);
        cxt.addMessage("login-notfication-key", fm);
        return "signin";
    }
    
    /**
     * Invalidiert die Session und meldet den Benuter entsprechend ab.
     * 
     * @return Startseite auf die weitergeleitet werden soll.
     */
    public String logout() {
        FacesContext cxt = FacesContext.getCurrentInstance();
        cxt.getExternalContext().invalidateSession();
        cxt.getExternalContext().getSession(true);
        session.setLoggedIn(false);
        return "index?faces-redirect=true";
    }
    
    public SessionManager getSession() {
        return session;
    }

    public void setSession(SessionManager session) {
        this.session = session;
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
    
}
