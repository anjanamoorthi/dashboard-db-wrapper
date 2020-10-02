package com.invenco.dashboardAPIHandler.DBWrapper.service;

import com.invenco.dashboardAPIHandler.DBWrapper.dao.ReleaseRepository;
import com.invenco.dashboardAPIHandler.DBWrapper.model.Release;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author DulaniK
 * @version 0.0.1
 * @since 25/09/2020
 */
@Service
public class ReleaseManagementService {
    @Autowired
    ReleaseRepository repository;

    public void add(Release release) {
        repository.save(release);
    }
}
