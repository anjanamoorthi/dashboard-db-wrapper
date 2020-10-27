package com.invenco.dashboardAPIHandler.DBWrapper.rest.service;

import com.invenco.dashboardAPIHandler.DBWrapper.rest.dto.TestResult_DTO;
import com.invenco.dashboardAPIHandler.DBWrapper.rest.model.Releases;
import com.invenco.dashboardAPIHandler.DBWrapper.rest.model.TestCase;
import com.invenco.dashboardAPIHandler.DBWrapper.rest.model.TestResult;
import com.invenco.dashboardAPIHandler.DBWrapper.rest.model.TestStatus;
import com.invenco.dashboardAPIHandler.DBWrapper.rest.repository.TestResultRepository;
import com.invenco.dashboardAPIHandler.DBWrapper.rest.repository.TestcaseRepository;
import com.netflix.discovery.converters.Auto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TestResultService {

	@Autowired
	TestResultRepository testResultRepository;

	@Autowired
	TestcaseRepository tcRepo;

	@Autowired
	TestcaseService testCaseService;

	@Autowired
	TestStatusService testStatusService;

	@Autowired
	ReleaseService releaseService;

	@Autowired
	TestResultService testResultService;

	@Autowired
	private ModelMapper modelMapper;

	public TestResult_DTO saveData(TestResult_DTO testResult_dto)  {

		TestResult result = convertToEntity(testResult_dto);
		// Store result
		TestResult testResult = testResultService.save(result);
		return convertToDto(testResult);
	}


	private TestResult_DTO convertToDto(TestResult testResult) {
		TestResult_DTO testResult_dto = modelMapper.map(testResult, TestResult_DTO.class);
		testResult_dto.setTestcase_name(testResult.getTestcase_name().getName());
		testResult_dto.setTest_status(testResult.getStatus().getTest_status());
		return testResult_dto;
	}

	private TestResult convertToEntity(TestResult_DTO testResult_dto) throws ParseException {
		TestResult testResult = modelMapper.map(testResult_dto, TestResult.class);

		// Find release with same name and iteration
		Releases release = releaseService.findByNameAndIteration(testResult_dto.getRelease_name(),
				testResult_dto.getRelease_iteration());
		testResult.setRelease(release);

		// Find result with same name
		TestCase testcase = testCaseService.findByName(testResult_dto.getTestcase_name());
		testResult.setTestcase_name(testcase);

		// Find status with same name
		TestStatus testStatus = testStatusService.findByName(testResult_dto.getTest_status());
		testResult.setStatus(testStatus);

		return testResult;
	}

	
	public TestResult save(TestResult testResult) {
		testResultRepository.save(testResult);
		return testResult;
	}

	public List<TestResult> list() {
		return testResultRepository.findAll();
	}

	public Optional<TestResult> findByID(Long id) {
		return testResultRepository.findById(id);
	}

}
