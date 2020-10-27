package com.invenco.dashboardAPIHandler.DBWrapper.rest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table( name = "importance")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Importance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "importance_id")
    private Long id;

    @Column ( name = "importance_name")
    public String impName;

   // @OneToMany(mappedBy = "impName", cascade = CascadeType.ALL, orphanRemoval = true)
    //private List<Release> release;

    public Importance(String impName) {
        this.impName = impName;
    }
}
