package com.invenco.dashboardAPIHandler.DBWrapper.dao;

import com.invenco.dashboardAPIHandler.DBWrapper.model.Release;
import org.springframework.data.repository.CrudRepository;

/**
 * @author DulaniK
 * @version 0.0.1
 * @since 25/09/2020
 */
public interface ReleaseRepository extends CrudRepository<Release, String> {



}
