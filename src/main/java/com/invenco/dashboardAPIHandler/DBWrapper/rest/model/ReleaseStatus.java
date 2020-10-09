package com.invenco.dashboardAPIHandler.DBWrapper.rest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table( name = "invreleasestatus")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReleaseStatus {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id;

    @Column ( name = "ReleaseStatus")
    public String releaseStatus;

    @OneToMany(mappedBy = "releasestatus", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Release> release;

    public ReleaseStatus(String rStatus) {
        this.releaseStatus = rStatus;
    }
}
