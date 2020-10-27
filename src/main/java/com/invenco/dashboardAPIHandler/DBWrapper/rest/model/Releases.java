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
import java.util.Date;
import java.util.UUID;

import static java.util.Calendar.DATE;


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
    @Column(name = "release_name", length = 20)
    private String name;

    @NotNull
    @Column(name = "release_iteration")
    private int iteration;

    @Column(name = "description")
    private String description;


    @Temporal(TemporalType.DATE)
    @Column(name = "start_date")
    private Date start_date;

    @Temporal(TemporalType.DATE)
    @Column(name = "end_date")
    private Date end_date;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "release_status_id", referencedColumnName = "release_status_id", insertable = true, updatable = true)
    private ReleaseStatus release_status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product_name;

}

