package com.invenco.dashboardAPIHandler.DBWrapper.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table( name = "product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id;

    @Column( name = "ProductName")
    private String productName;

    @JsonIgnore
    @OneToMany(mappedBy = "productName", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Releases> product;


    public Product(String pName) {
        this.productName = pName;
    }
}
