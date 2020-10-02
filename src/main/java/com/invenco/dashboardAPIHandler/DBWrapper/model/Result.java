package com.invenco.dashboardAPIHandler.DBWrapper.model;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author DulaniK
 * @version 0.0.1
 * @since 2/10/2020
 */
@Entity
public class Result {

    @Column(name ="result_type")
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
