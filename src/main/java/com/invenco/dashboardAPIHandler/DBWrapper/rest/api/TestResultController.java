/**
 * @author Moorthi Rajan
 * @version 0.0.1
 * @since 03/10/2020
 */

package com.invenco.dashboardAPIHandler.DBWrapper.rest.api;

import com.invenco.dashboardAPIHandler.DBWrapper.rest.dao.TestCase_DAO;
import com.invenco.dashboardAPIHandler.DBWrapper.rest.dao.TestResult_DAO;
import com.invenco.dashboardAPIHandler.DBWrapper.rest.dto.TestResult_DTO;
import com.invenco.dashboardAPIHandler.DBWrapper.rest.dto.TestCase_DTO;
import com.invenco.dashboardAPIHandler.DBWrapper.rest.service.TestResultService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/test_result")
public class TestResultController {

    Logger logger = LogManager.getLogger(TestResultController.class);

    @Autowired
    private TestResultService service;

    @PostMapping("/add")
    public @ResponseBody HttpEntity<Object> saveTestResultData(@Valid @RequestBody TestResult_DAO data) {
        TestResult_DTO dto;
        try {
            dto = service.saveTestResultData(data);

        } catch (Exception e) {
            throw e;
        }
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public @ResponseBody HttpEntity<String> deleteTestResultData(@PathVariable Long id) {
        TestResult_DTO dto;
        try {
            dto = service.deleteTestResultData(id);
            return new ResponseEntity(dto, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Failed to Delete test case entry from DB");
            throw e;
        }
    }

    @PatchMapping("/update")
    public @ResponseBody HttpEntity<Object> updateTestResultData(@Valid @RequestBody TestResult_DAO data) {
        TestResult_DTO dto;
        try {
            dto = service.updateTestResultData(data);

        } catch (Exception e) {
            throw e;
        }
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

}
