/**
 * @author Moorthi Rajan
 * @version 0.0.1
 * @since 03/10/2020
 */

package com.invenco.dashboardAPIHandler.DBWrapper.rest.service;

import com.invenco.dashboardAPIHandler.DBWrapper.rest.dao.Release_DAO;
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

    @Autowired
    private ProductService prodService;

    @Autowired
    private ReleaseStatusService releaseStatusService;

    public Release saveReleaseData(Release_DAO rdata) {
        System.out.println("Saving data into DB");
        //Release releaseData = new Release();
        Release releaseData = new Release();
        releaseData.setReleasename(rdata.releasename);
        releaseData.setDescription(rdata.description);
        releaseData.setIteration(rdata.iteration);
        releaseData.setStartdate(rdata.startdate);
        releaseData.setEnddate(rdata.enddate);
        releaseData.setUser(rdata.user);
        releaseData.setProductName(prodService.findByName(rdata.pname));
        releaseData.setReleasestatus(releaseStatusService.findByName(rdata.status));
        return repo.save(releaseData);
        //return new ResponseEntity<>("Successfully saved", HttpStatus.OK);
    }

    public ResponseEntity<String> deleteReleaseData(Release relData) {
        repo.delete(relData);
        return new ResponseEntity<>("Successfully deleted Entry from DB", HttpStatus.OK);
    }

}
