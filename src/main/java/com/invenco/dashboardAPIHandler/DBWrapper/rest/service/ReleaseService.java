/**
 * @author Moorthi Rajan
 * @version 0.0.1
 * @since 03/10/2020
 */

package com.invenco.dashboardAPIHandler.DBWrapper.rest.service;

import com.invenco.dashboardAPIHandler.DBWrapper.rest.dao.Release_DAO;
import com.invenco.dashboardAPIHandler.DBWrapper.rest.dto.Release_DTO;
import com.invenco.dashboardAPIHandler.DBWrapper.rest.model.Product;
import com.invenco.dashboardAPIHandler.DBWrapper.rest.model.ReleaseKey;
import com.invenco.dashboardAPIHandler.DBWrapper.rest.model.Releases;
import com.invenco.dashboardAPIHandler.DBWrapper.rest.repository.ReleaseRepository;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;


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

    @Autowired
    private ModelMapper modelMapper;


    public Release_DTO saveReleaseData(Release_DAO rdata) {
        System.out.println("Saving data into DB");
        Releases releaseData = modelMapper.map(rdata, Releases.class);
        releaseData.setProduct_name(prodService.findByName(rdata.getProduct_name()));
        releaseData.setRelease_status(releaseStatusService.findByName(rdata.getRelease_status()));
        releaseData = repo.save(releaseData);

        Release_DTO response = new Release_DTO();
        response.setId(releaseData.getId());
        response.setIteration(releaseData.getIteration());
        return response;

    }

    public ResponseEntity<String> deleteReleaseData(Releases relData) {
        repo.delete(relData);
        return new ResponseEntity<>("Successfully deleted Entry from DB", HttpStatus.OK);
    }

}
