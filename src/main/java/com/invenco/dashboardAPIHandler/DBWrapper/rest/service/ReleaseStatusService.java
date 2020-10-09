package com.invenco.dashboardAPIHandler.DBWrapper.rest.service;

import com.invenco.dashboardAPIHandler.DBWrapper.rest.model.ReleaseStatus;
import com.invenco.dashboardAPIHandler.DBWrapper.rest.repository.ReleaseStatusRepository;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Builder
public class ReleaseStatusService {

    @Autowired
    private ReleaseStatusRepository repo;

    public ReleaseStatus findByName(String name) {
        return repo.findByName(name);
    }
}
