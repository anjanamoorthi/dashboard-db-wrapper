/**
 * @author Moorthi Rajan
 * @version 0.0.1
 * @since 03/10/2020
 */

package com.invenco.dashboardAPIHandler.DBWrapper.rest.repository;

import com.invenco.dashboardAPIHandler.DBWrapper.rest.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface TestcaseRepository extends JpaRepository<TestCase, UUID> {

    @Query(value = "SELECT * FROM testcase where test_name = ?1", nativeQuery = true)
    TestCase findByName(String name);

}
