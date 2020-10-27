/**
 * @author Moorthi Rajan
 * @version 0.0.1
 * @since 03/10/2020
 */

package com.invenco.dashboardAPIHandler.DBWrapper.rest.api;

import com.invenco.dashboardAPIHandler.DBWrapper.exception.APIError;
import com.invenco.dashboardAPIHandler.DBWrapper.rest.dao.Test_DAO;
import com.invenco.dashboardAPIHandler.DBWrapper.rest.dto.Test_DTO;
import com.invenco.dashboardAPIHandler.DBWrapper.rest.service.TestcaseService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/testcase")
public class TestcaseController {

    Logger logger = LogManager.getLogger(TestcaseController.class);

    @Autowired
    private TestcaseService service;

    @PostMapping("/add")
    public @ResponseBody HttpEntity<Object> saveTestcaseData(@RequestBody Test_DAO data) {
        Test_DTO dto;
        try {
            dto = service.saveTestcaseData(data);

        } catch (ConstraintViolationException ex) {
            APIError apiError =
                    new APIError(HttpStatus.BAD_REQUEST, "Constraint Violation");
            return new ResponseEntity<>(apiError, apiError.getStatus());
        } catch (Exception e) {
            APIError apiError =
                    new APIError(HttpStatus.BAD_REQUEST, e.getLocalizedMessage());
            return new ResponseEntity<>(apiError, apiError.getStatus());
        }
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{uuid}")
    public @ResponseBody HttpEntity<String> deleteTestCaseData(@PathVariable UUID uuid) {
        try {
            service.deleteTestcaseData(uuid);
            return new ResponseEntity(uuid, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Failed to Delete test case entry from DB");
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
