package com.invenco.dashboardAPIHandler.DBWrapper.rest.repository;

import com.invenco.dashboardAPIHandler.DBWrapper.rest.model.TestStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TestStatusRepository extends JpaRepository<TestStatus, Long> {

	@Query(value = "SELECT ts FROM TestStatus ts where ts.status = ?1")
	TestStatus findByValue(String status);
}
