/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package manager;

import controller.Database;
import models.Service;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author cano
 */
@Named(value = "serviceManager")
@ViewScoped
public class ServiceManager {
    private final static Logger LOGGER = Logger.getLogger(ServiceManager.class.getName());
    private List<Service> serviceList;
    
    @Inject
    private Database db;
    
    /**
    * Creates a new instance of ServiceManager
    */
    public ServiceManager() {
        LOGGER.info("Constructor: ServiceManager");
    }
    
    @PostConstruct
    public void init() {
        LOGGER.info("Init: ServiceManager");
        serviceList = db.getServiceList();
    }

    public List<Service> getServiceList() {
        for(Service s : serviceList) {
            System.out.println(s.getTimes());
        }
        return serviceList;
    }

    public void setServiceList(List<Service> serviceList) {
        this.serviceList = serviceList;
    }
    

   
}
