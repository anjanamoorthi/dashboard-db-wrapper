package com.invenco.dashboardAPIHandler.DBWrapper.rest.repository;

import com.invenco.dashboardAPIHandler.DBWrapper.rest.model.TestResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestResultRepository extends JpaRepository<TestResult, Long> {

}
