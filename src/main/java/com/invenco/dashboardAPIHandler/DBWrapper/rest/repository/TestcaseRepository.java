/**
 * @author Moorthi Rajan
 * @version 0.0.1
 * @since 03/10/2020
 */

package com.invenco.dashboardAPIHandler.DBWrapper.rest.repository;

import com.invenco.dashboardAPIHandler.DBWrapper.rest.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TestcaseRepository extends JpaRepository<TestCase, UUID> {

}
