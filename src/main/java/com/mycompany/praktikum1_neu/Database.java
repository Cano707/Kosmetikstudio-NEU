/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mycompany.praktikum1_neu;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author cano
 */
@Named(value = "database")
@SessionScoped
public class Database implements Serializable {
    static final Logger LOGGER = Logger.getLogger(Database.class.getName());

    private static int id = 0;
    private List<User> userList;
    private FacesContext cxt;
    private HttpSession session;
    private PasswordHashConverter phc;
    
    /**
     * Creates a new instance of UserManager
     */
    public Database() {
        LOGGER.info("Construtor: Database");
    }
    
    @PostConstruct
    public void init() {
        LOGGER.info("Init: Database");
        cxt = FacesContext.getCurrentInstance();
        session = (HttpSession) cxt.getExternalContext().getSession(false);
        LOGGER.info(session.getId());
        userList = new ArrayList<>();
        phc = new PasswordHashConverter();
        fillUserList();
    }
    
    private void fillUserList() {
        User admin = new User(getId(), "", "", "", "admin@mail.com", "" ,"admin", phc.getPwdHash("1!AAaaaa"), User.Role.ADMIN);
        User user = new User(getId() ,"", "", "", "admin@mail.com", "" ,"cano", phc.getPwdHash("1!AAaaaa"), User.Role.USER);
        this.userList.add(user);
        this.userList.add(admin);
        
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Database.id = id;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public FacesContext getCxt() {
        return cxt;
    }

    public void setCxt(FacesContext cxt) {
        this.cxt = cxt;
    }

    public HttpSession getSession() {
        return session;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }
    
    
}
