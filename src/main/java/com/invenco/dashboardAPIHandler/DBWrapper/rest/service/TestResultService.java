/**
 * @author Moorthi Rajan
 * @version 0.0.1
 * @since 03/10/2020
 */

package com.invenco.dashboardAPIHandler.DBWrapper.rest.service;

import com.invenco.dashboardAPIHandler.DBWrapper.rest.dao.TestResult_DAO;
import com.invenco.dashboardAPIHandler.DBWrapper.rest.dto.TestResult_DTO;
import com.invenco.dashboardAPIHandler.DBWrapper.rest.model.*;
import com.invenco.dashboardAPIHandler.DBWrapper.rest.repository.TestResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TestResultService {

    @Autowired
    private TestResultRepository repo;

    @Autowired
    private ReleaseService releaseService;

    @Autowired
    private TestStatusService testStatusService;

    @Autowired
    private TestCaseService testCaseService;

    @Autowired
    private TestResultService testResultService;

    @Autowired
    private ModelMapper modelMapper;

    public TestResult_DTO saveTestResultData(TestResult_DAO trData) {
        System.out.println("Saving data into DB");
        TestResult testresult = modelMapper.map(trData, TestResult.class);

        Releases release = releaseService.findByNameAndIteration(trData.getRelease(),
                trData.getRelease_iteration());
        testresult.setRelease(release);

        TestStatus status = testStatusService.findByValue(trData.getResult());
        testresult.setTest_status(status);

        TestCase testcase = testCaseService.findByName(trData.getTestcase_name());
        testresult.setTestcase_name(testcase);

        testresult = repo.save(testresult);
        TestResult_DTO response = modelMapper.map(testresult, TestResult_DTO.class);
        return response;
    }

    @Transactional
    public TestResult_DTO updateTestResultData(TestResult_DAO trData) {
        System.out.println("Update Test Result : [TEST CASE] "+ trData.getTestcase_name() + "[STATUS] " + trData.getResult());

        Optional<TestResult> testresult = repo.findById(trData.getId());
        testresult.ifPresent(result ->
                {
                    TestStatus status = testStatusService.findByValue(trData.getResult());
                    result.setTest_status(status);
                }
        );

        TestResult_DTO response = modelMapper.map(testresult, TestResult_DTO.class);
        return response;
    }


    public TestResult_DTO deleteTestResultData(Long id) {
        TestResult_DTO response = new TestResult_DTO();
        repo.deleteById(id);
        response.setId(id);
        return response;
    }

}
