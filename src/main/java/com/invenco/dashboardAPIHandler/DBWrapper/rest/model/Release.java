/**
 * @author Moorthi Rajan
 * @version 0.0.1
 * @since 03/10/2020
 */

package com.invenco.dashboardAPIHandler.DBWrapper.rest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;


@Entity
@Table ( name = "invreleasebundledata")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Release {

    @Id
    @Column(columnDefinition = "BINARY(16)")
    private UUID id = UUID.randomUUID();

    @NotNull
    @Column(name = "releasename")
    public String releasename;


    @Column(name = "description")
    public String description;

    @Column(name = "iteration")
    @ColumnDefault("1")
    public int iteration;

    @NotNull
    @Column(name = "startdate")
    public String startdate;

    @Column(name = "enddate")
    public String enddate;

   // @Column(name = "status")
    //public String status;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "release_id")
    private ReleaseStatus releasestatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product productName;

    @Column(name = "user")
    public String user;

}

