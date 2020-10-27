package com.invenco.dashboardAPIHandler.DBWrapper.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.invenco.dashboardAPIHandler.DBWrapper.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table( name = "release_status")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true) // Required if we are extending BaseClass
public class ReleaseStatus extends BaseEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "release_status_id")
    private Long id;

    @Column ( name = "ReleaseStatus")
    public String releaseStatus;

    //@JsonIgnore
    //@OneToMany(mappedBy = "releaseStatus", cascade = CascadeType.ALL, orphanRemoval = true)
    //private List<Releases> release_status;

    public ReleaseStatus(String rStatus) {
        this.releaseStatus = rStatus;
    }
}
