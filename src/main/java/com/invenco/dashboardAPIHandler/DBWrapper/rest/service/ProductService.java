package com.invenco.dashboardAPIHandler.DBWrapper.rest.service;

import com.invenco.dashboardAPIHandler.DBWrapper.rest.model.Product;
import com.invenco.dashboardAPIHandler.DBWrapper.rest.repository.ProductRepository;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Builder
public class ProductService {

    @Autowired
    private ProductRepository repo;

    public Product findByName(String name) {
        return repo.findByName(name);
    }

}
