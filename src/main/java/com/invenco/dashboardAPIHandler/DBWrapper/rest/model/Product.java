package com.invenco.dashboardAPIHandler.DBWrapper.rest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table( name = "invproduct")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id;

    @Column( name = "ProductName")
    private String productName;

    @OneToMany(mappedBy = "productName", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Release> product;


    public Product(String pName) {
        this.productName = pName;
    }
}
