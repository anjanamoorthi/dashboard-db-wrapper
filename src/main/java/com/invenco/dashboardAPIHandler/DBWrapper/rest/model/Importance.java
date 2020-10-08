package com.invenco.dashboardAPIHandler.DBWrapper.rest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table( name = "invtestimportance")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Importance {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id;

    @Column ( name = "ImportanceName")
    public String impName;

   // @OneToMany(mappedBy = "impName", cascade = CascadeType.ALL, orphanRemoval = true)
    //private List<Release> release;

    public Importance(String impName) {
        this.impName = impName;
    }
}
