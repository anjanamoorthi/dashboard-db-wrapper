/**
 * @author Moorthi Rajan
 * @version 0.0.1
 * @since 03/10/2020
 */

package com.invenco.dashboardAPIHandler.DBWrapper.rest.model;

import com.invenco.dashboardAPIHandler.DBWrapper.BaseEntity;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;


@Entity
@Table ( name = "releases",uniqueConstraints = @UniqueConstraint(columnNames = { "release_name", "release_iteration" }))
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true) // Required if we are extending BaseClass
public class Releases extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "release_id")
    private Long id;

    @NotNull
    @Column(name = "release_name")
    private String name;

    @NotNull
    @Column(name = "release_iteration")
    private int iteration;

    @Column(name = "description")
    public String description;


    @NotNull
    @Column(name = "startdate")
    public String startdate;

    @Column(name = "enddate")
    public String enddate;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "release_status_id")
    private ReleaseStatus releasestatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product productName;

}

