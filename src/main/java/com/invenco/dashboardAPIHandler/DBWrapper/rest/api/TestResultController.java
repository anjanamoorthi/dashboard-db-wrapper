package com.invenco.dashboardAPIHandler.DBWrapper.rest.api;


import com.invenco.dashboardAPIHandler.DBWrapper.rest.dto.TestResult_DTO;
import com.invenco.dashboardAPIHandler.DBWrapper.rest.model.TestResult;
import com.invenco.dashboardAPIHandler.DBWrapper.rest.service.ReleaseService;
import com.invenco.dashboardAPIHandler.DBWrapper.rest.service.TestResultService;
import com.invenco.dashboardAPIHandler.DBWrapper.rest.service.TestStatusService;
import com.invenco.dashboardAPIHandler.DBWrapper.rest.service.TestcaseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/***
 * JSON Object for POST Message is as shown below
 * 
 * <PRE>
 * {
    "release_name" : "R1.1.1",
    "release_iteration" : 1,
    "testcase_name" : "com.test.test1",
    "test_module" : "contactless",
    "test_duration" : 530,
    "test_status" : "PASS",
    "test_starttime" : "2020-10-09T15:52:57",
    "test_finishtime" : "2020-10-09T15:52:57",
    "product" : "G6200",
    "note" : "   "
	}
 * </PRE>
 * 
 * @author MoorthiR
 */
@RestController
@RequestMapping(value = "/TestResult")
public class TestResultController {

	@Autowired
	TestResultService testResultService;


	@PostMapping("/add")
	public TestResult_DTO add(@Valid @RequestBody TestResult_DTO testResult_dto) {
		 return testResultService.saveData(testResult_dto);
	}

	@GetMapping
	public List<TestResult> add() {
		return testResultService.list();
	}

}
