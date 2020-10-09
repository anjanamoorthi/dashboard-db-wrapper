package com.invenco.dashboardAPIHandler.DBWrapper.rest.repository;

import com.invenco.dashboardAPIHandler.DBWrapper.rest.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT r FROM Product r WHERE r.productName = ?1")
    public Product findByName(String prodname);
}
