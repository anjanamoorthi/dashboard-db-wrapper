package com.invenco.dashboardAPIHandler.DBWrapper.model;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * @author DulaniK
 * @version 0.0.1
 * @since 2/10/2020
 */
public class Product {

    @Id
    @Column(name = "product_name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
