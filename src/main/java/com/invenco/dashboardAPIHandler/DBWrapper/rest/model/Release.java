package com.invenco.dashboardAPIHandler.DBWrapper.rest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;



@Entity
@Table ( name = "invreleasebundledata")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Release {

    @Id
    @Column(name = "releasename")
    public String releasename;

    @Column(name = "description")
    public String description;

    @Column(name = "iteration")
    public int iteration;

    @Column(name = "startdate")
    public String startdate;

    @Column(name = "enddate")
    public String enddate;

    @Column(name = "status")
    public String status;

    @Column(name = "user")
    public String user;

}

