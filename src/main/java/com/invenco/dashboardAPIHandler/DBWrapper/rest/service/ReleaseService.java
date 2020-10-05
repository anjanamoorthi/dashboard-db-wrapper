/**
 * @author Moorthi Rajan
 * @version 0.0.1
 * @since 03/10/2020
 */

package com.invenco.dashboardAPIHandler.DBWrapper.rest.service;

import com.invenco.dashboardAPIHandler.DBWrapper.rest.model.Release;
import com.invenco.dashboardAPIHandler.DBWrapper.rest.repository.ReleaseRepository;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;


@Service
@Builder
public class ReleaseService {

    public static enum Result {
        OK,
        TIMEOUT,
        ERROR;

        private Result() {
        }
    }

    @Autowired
    private ReleaseRepository repo;

    public ResponseEntity<String> saveReleaseData(Release relData) {
        System.out.println("Saving data into DB");
        repo.save(relData);
        return new ResponseEntity<>("Successfully saved", HttpStatus.OK);
    }

    public ResponseEntity<String> deleteReleaseData(Release relData) {
        repo.delete(relData);
        return new ResponseEntity<>("Successfully deleted Entry from DB", HttpStatus.OK);
    }

}
