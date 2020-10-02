package com.invenco.dashboardAPIHandler.DBWrapper.model;

import javax.persistence.*;
import java.sql.Date;

/**
 * Holds release information
 * @author DulaniK
 * @version 0.0.1
 * @since 25/09/2020
 */
@Entity
public class Release {

    @Id
    @Column(name="release_name")
    private String releaseName;

    @Column(name="product_name")
    private String productName;

    @OneToOne
    @JoinColumn(name = "status", referencedColumnName = "status")
    private ReleaseStatus status;

    @ManyToOne()
    @JoinColumn(name = "user", referencedColumnName = "user_id")
    private User user;

    @Column(name="description")
    private String description;

    @Column(name="iteration")
    private int iteration;

    @Column(name="start_date")
    private Date startDate;

    @Column(name="end_date")
    private Date endDate;

    public String getReleaseName() {
        return releaseName;
    }

    public void setReleaseName(String releaseName) {
        this.releaseName = releaseName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIteration() {
        return iteration;
    }

    public void setIteration(int iteration) {
        this.iteration = iteration;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
