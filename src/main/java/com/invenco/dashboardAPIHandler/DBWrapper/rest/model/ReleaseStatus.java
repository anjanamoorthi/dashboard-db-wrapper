package com.invenco.dashboardAPIHandler.DBWrapper.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table( name = "release_status")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReleaseStatus {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id;

    @Column ( name = "ReleaseStatus")
    public String releaseStatus;

    @JsonIgnore
    @OneToMany(mappedBy = "releasestatus", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Releases> release_status;

    public ReleaseStatus(String rStatus) {
        this.releaseStatus = rStatus;
    }
}
