/**
 * @author Moorthi Rajan
 * @version 0.0.1
 * @since 03/10/2020
 */

package com.invenco.dashboardAPIHandler.DBWrapper.rest.repository;

import com.invenco.dashboardAPIHandler.DBWrapper.rest.model.Releases;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface ReleaseRepository extends JpaRepository<Releases, String> {

    @Query(value = "SELECT * FROM releases where release_name = ?1", nativeQuery = true)
    Releases findByValue(String release_name);

    @Query(value = "SELECT * FROM releases where release_name = ?1 AND release_iteration = ?2", nativeQuery = true)
    Releases findByNameAndIteration(String release_name, int release_iteration);

}
