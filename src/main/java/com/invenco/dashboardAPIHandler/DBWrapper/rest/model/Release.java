/**
 * @author Moorthi Rajan
 * @version 0.0.1
 * @since 03/10/2020
 */

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

    @Transient
    @Column(name = "description")
    public String description;

    @Transient
    @Column(name = "iteration")
    public int iteration;

    @Column(name = "startdate")
    public String startdate;

    @Column(name = "enddate")
    public String enddate;

    @Column(name = "status")
    public String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "release_status_id")
    private ReleaseStatus releaseStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productname_id")
    private Product productName;

    @Transient
    @Column(name = "user")
    public String user;

}

