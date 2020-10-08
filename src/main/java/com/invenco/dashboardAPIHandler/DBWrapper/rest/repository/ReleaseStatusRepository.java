package com.invenco.dashboardAPIHandler.DBWrapper.rest.repository;

import com.invenco.dashboardAPIHandler.DBWrapper.rest.model.ReleaseStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReleaseStatusRepository extends JpaRepository<ReleaseStatus, Long> {
}
