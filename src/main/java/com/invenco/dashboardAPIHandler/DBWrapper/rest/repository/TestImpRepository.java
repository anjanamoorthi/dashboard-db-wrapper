package com.invenco.dashboardAPIHandler.DBWrapper.rest.repository;

import com.invenco.dashboardAPIHandler.DBWrapper.rest.model.Importance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestImpRepository extends JpaRepository<Importance, Long> {
}
