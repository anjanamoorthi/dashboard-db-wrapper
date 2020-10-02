package com.invenco.dashboardAPIHandler.DBWrapper.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author DulaniK
 * @version 0.0.1
 * @since 25/09/2020
 */
@Entity
public class ReleaseStatus {

    @Id
    @Column(name = "status")
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
