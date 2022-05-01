/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package manager;

import controller.Database;
import models.Product;
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
@Named(value = "productManager")
@ViewScoped
public class ProductManager {
    private final static Logger LOGGER = Logger.getLogger(ProductManager.class.getName());
    private List<Product> productList;
    
    @Inject
    private Database db;
    
    /**
    * Creates a new instance of ProductManager
    */
    public ProductManager() {
        LOGGER.info("Constructor: ProductManager");
    }
    
    @PostConstruct
    public void init() {
        LOGGER.info("Init: ProductManager");
        productList = db.getProductList();
    }
    
    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
   
    
}
