/**
 * @author Moorthi Rajan
 * @version 0.0.1
 * @since 03/10/2020
 */

package com.invenco.dashboardAPIHandler.DBWrapper.rest.service;

import com.invenco.dashboardAPIHandler.DBWrapper.rest.dao.Release_DAO;
import com.invenco.dashboardAPIHandler.DBWrapper.rest.model.Product;
import com.invenco.dashboardAPIHandler.DBWrapper.rest.model.ReleaseKey;
import com.invenco.dashboardAPIHandler.DBWrapper.rest.model.Releases;
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

    public Releases saveReleaseData(Release_DAO rdata) {
        System.out.println("Saving data into DB");
        Releases releaseData = new Releases();
        releaseData.setDescription(rdata.description);
        releaseData.setStartdate(rdata.startdate);
        releaseData.setEnddate(rdata.enddate);
        releaseData.setName(rdata.releasename);
        releaseData.setIteration(rdata.iteration);
        releaseData.setProductName(prodService.findByName(rdata.pname));
        releaseData.setReleasestatus(releaseStatusService.findByName(rdata.status));
        System.out.println(releaseData.getReleasestatus());
        return repo.save(releaseData);
        //return new ResponseEntity<>("Successfully saved", HttpStatus.OK);
    }

    public ResponseEntity<String> deleteReleaseData(Releases relData) {
        repo.delete(relData);
        return new ResponseEntity<>("Successfully deleted Entry from DB", HttpStatus.OK);
    }

    public Releases findByNameAndIteration(String release_name, int release_iteration) {
        return repo.findByNameAndIteration(release_name, release_iteration);
    }

}
