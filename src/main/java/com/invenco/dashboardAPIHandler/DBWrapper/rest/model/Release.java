/**
 * @author Moorthi Rajan
 * @version 0.0.1
 * @since 03/10/2020
 */

package com.invenco.dashboardAPIHandler.DBWrapper.rest.model;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;


@Entity
@Table ( name = "invreleasebundledata")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Release {

    @EmbeddedId
    private ReleaseKey id;

//    @Id
    @GeneratedValue(generator = "hibernate-uuid")
    @GenericGenerator(name="hibernate-uuid", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID uuid;// = UUID.randomUUID();

//    @NotNull
//    @Column(name = "releasename")
//    public String releasename;

    @Column(name = "description")
    public String description;

//    @Column(name = "iteration")
//    @ColumnDefault("1")
//    public int iteration;

    @NotNull
    @Column(name = "startdate")
    public String startdate;

    @Column(name = "enddate")
    public String enddate;

   // @Column(name = "status")
    //public String status;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "release_id", referencedColumnName = )
    private ReleaseStatus releasestatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private Product productName;

    @Column(name = "user")
    public String user;

}

