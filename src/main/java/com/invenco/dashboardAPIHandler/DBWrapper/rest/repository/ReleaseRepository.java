/**
 * @author Moorthi Rajan
 * @version 0.0.1
 * @since 03/10/2020
 */

package com.invenco.dashboardAPIHandler.DBWrapper.rest.repository;

import com.invenco.dashboardAPIHandler.DBWrapper.rest.model.Releases;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ReleaseRepository extends JpaRepository<Releases, String> {

    @Query(value = "SELECT r FROM Releases r where r.name = ?1 AND r.iteration = ?2")
    Releases findByNameAndIteration(String release_name, int release_iteration);
}
