package com.invenco.dashboardAPIHandler.DBWrapper.rest.repository;

import com.invenco.dashboardAPIHandler.DBWrapper.rest.model.Importance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ImportanceRepository extends JpaRepository<Importance, Long> {

	@Query(value = "SELECT i FROM Importance i where i.impName = ?1")
	Importance findByName(String importance);
}
