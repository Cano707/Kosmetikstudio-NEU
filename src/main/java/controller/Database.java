/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import utils.PasswordHashConverter;
import models.Service;
import models.Product;
import models.User;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Onur-Can Yaman
 * @version 1.0
 * 
 * Datenbank-Dummy Klasse, die - zum jetzigen Zeitpunkt - die Daten
 * initialisiert und Funktion zum Abruf dieser bereitstellt.
 */
@Named(value = "database")
@ApplicationScoped
public class Database implements Serializable {
    static final Logger LOGGER = Logger.getLogger(Database.class.getName());

    private static int uid = 0;
    private List<User> userList;
    
    private static int pid = 0;
    private List<Product> productList;
    
    private static int sid = 0;
    private List<Service> serviceList;
    
    
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
        productList = new ArrayList<>();
        serviceList = new ArrayList<>();
        phc = new PasswordHashConverter();
        fillUserList();
        fillProductList();
        fillServiceList();
    }
    
    /**
     * Füllt Userlist mit Dummy Daten
     */
    private void fillUserList() {
        User admin = new User(getUid(), "Herr", "", "", "admin@mail.com", "" ,"admin", phc.getPwdHash("1!AAaaaa"), User.Role.ADMIN);
        User user = new User(getUid() ,"Herr", "Onur", "Yaman", "admin@mail.com", "2123" ,"cano", phc.getPwdHash("1!AAaaaa"), User.Role.USER);
        this.userList.add(user);
        this.userList.add(admin);   
    }
    
    /**
     * Füllt Produktliste mit Dummy Daten
     */
    private void fillProductList() {
        Product p1 = new Product(10, "Ohrenpflegecreme", "Schenkt Ihren Ohren Feuchtigkeit und Glanz.", 49.99f, getPid());
        Product p2 = new Product(10, "Ellenbogenlotion", "Ihre Ellenbögen werden so weich wie nie zuvor.", 89.99f, getPid());
        this.productList.add(p1);
        this.productList.add(p2);
    }
   
    
    /**
     * Füllt Serviceliste mit Dummy Daten
     */
    public void fillServiceList() {
        HashMap<String, String> timeList1 = new HashMap<>();
        timeList1.put("09:00", "09:00");
        timeList1.put("10:00", "10:00");
        timeList1.put("11:00", "11:00");
        timeList1.put("12:00", "12:00");
        timeList1.put("13:00", "13:00");
        HashMap<String, String> timeList2 = new HashMap<>();
        timeList2.put("09:00", "09:00");
        timeList2.put("10:00", "10:00");
        timeList2.put("11:00", "11:00");
        timeList2.put("12:00", "12:00");
        timeList2.put("13:00", "13:00");
        
        Service s1 = new Service(true, "Wimpern färben", "Färben der Wimpern in jeder beliebigen Farbe.", 13.99f, getSid(), timeList1);
        Service s2 = new Service(false, "Augenbrauen föhnen", "Föhnen der Augenbrauen bis sie vollkommen trocken sind.", 69.69f, getSid(), timeList2);
        this.serviceList.add(s1);
        this.serviceList.add(s2);
    }

    public static int getSid() {
        return sid++;
    }

    public static void setSid(int sid) {
        Database.sid = sid;
    }

    public List<Service> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<Service> serviceList) {
        this.serviceList = serviceList;
    }

    public static int getUid() {
        return uid++;
    }

    public static void setUid(int id) {
        Database.uid = id;
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
    
    
    public static int getPid() {
        return pid++;
    }

    public static void setPid(int pid) {
        Database.pid = pid;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
    
    
}
