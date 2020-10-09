package com.invenco.dashboardAPIHandler.DBWrapper.rest.repository;

import com.invenco.dashboardAPIHandler.DBWrapper.rest.model.Product;
import com.invenco.dashboardAPIHandler.DBWrapper.rest.model.ReleaseStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReleaseStatusRepository extends JpaRepository<ReleaseStatus, Long> {

    @Query("SELECT r FROM ReleaseStatus r WHERE r.releaseStatus = ?1")
    public ReleaseStatus findByName(String relstatusname);

}
