/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mycompany.praktikum1_neu;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author cano
 */
@Named(value = "sessionManager")
@SessionScoped
public class SessionManager implements Serializable {
    private boolean loggedIn;
    private boolean admin;
    private PasswordHashConverter phc;
    private HttpSession session;


    private FacesContext cxt;
    
    /**
     * Creates a new instance of Session
     */
    public SessionManager() {
    }
    
    @PostConstruct
    public void init() {
        phc = new PasswordHashConverter();
        loggedIn = false;
        cxt = FacesContext.getCurrentInstance();
        session = (HttpSession) cxt.getExternalContext().getSession(false);
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public HttpSession getSession() {
        return session;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }
    
    public boolean getAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
