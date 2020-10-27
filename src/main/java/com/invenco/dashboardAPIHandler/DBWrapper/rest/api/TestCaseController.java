/**
 * @author Moorthi Rajan
 * @version 0.0.1
 * @since 03/10/2020
 */

package com.invenco.dashboardAPIHandler.DBWrapper.rest.api;

import com.invenco.dashboardAPIHandler.DBWrapper.rest.dao.TestCase_DAO;
import com.invenco.dashboardAPIHandler.DBWrapper.rest.dto.TestCase_DTO;
import com.invenco.dashboardAPIHandler.DBWrapper.rest.service.TestCaseService;
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
@RequestMapping("/testcase")
public class TestCaseController {

    Logger logger = LogManager.getLogger(TestCaseController.class);

    @Autowired
    private TestCaseService service;

    @PostMapping("/add")
    public @ResponseBody HttpEntity<Object> saveTestcaseData(@Valid @RequestBody TestCase_DAO data) {
        TestCase_DTO dto;
        try {
            dto = service.saveTestcaseData(data);

        } catch (Exception e) {
            throw e;
        }
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public @ResponseBody HttpEntity<String> deleteTestCaseData(@Valid @PathVariable Long id) {
        TestCase_DTO dto;
        try {
            dto = service.deleteTestcaseData(id);
            return new ResponseEntity(dto, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Failed to Delete test case entry from DB");
            throw e;
        }
    }


}
