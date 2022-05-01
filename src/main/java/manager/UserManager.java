/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package manager;

import controller.Database;
import models.User;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author cano
 */
@Named(value = "userManager")
@ViewScoped
public class UserManager implements Serializable {
    private final static Logger LOGGER = Logger.getLogger(UserManager.class.getName());
    private List<User> userList;
    
    @Inject
    private Database db;

    /**
     * Creates a new instance of UserManager
     */
    public UserManager() {
    }
    
    @PostConstruct
    public void init() {
        LOGGER.info("Init: UserManager");
        userList = db.getUserList();
        
    }
    
    public void onUserEdit(RowEditEvent<User> event) {
        FacesMessage fm = new FacesMessage("Änderungen übernommen");
        FacesContext.getCurrentInstance().addMessage(null, fm);
    }
    
    public void onUserEditCancel(RowEditEvent<User> event) {
        FacesMessage fm = new FacesMessage("Änderungen verworfen");
        FacesContext.getCurrentInstance().addMessage(null, fm);
    }
    

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
    
    public void printUserList() {
        for(User u : db.getUserList()) {
            System.out.println(u.getEmail());
        }
    }
    
}
