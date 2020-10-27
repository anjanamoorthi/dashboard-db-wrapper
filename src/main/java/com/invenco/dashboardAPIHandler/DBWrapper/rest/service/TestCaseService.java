/**
 * @author Moorthi Rajan
 * @version 0.0.1
 * @since 03/10/2020
 */

package com.invenco.dashboardAPIHandler.DBWrapper.rest.service;

import com.invenco.dashboardAPIHandler.DBWrapper.rest.dao.TestCase_DAO;
import com.invenco.dashboardAPIHandler.DBWrapper.rest.dto.TestCase_DTO;
import com.invenco.dashboardAPIHandler.DBWrapper.rest.model.Importance;
import com.invenco.dashboardAPIHandler.DBWrapper.rest.model.TestCase;
import com.invenco.dashboardAPIHandler.DBWrapper.rest.repository.TestCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

@Service
public class TestCaseService {

    @Autowired
    private TestCaseRepository repo;

    @Autowired
    private ImportanceService importanceService;

    @Autowired
    private ModelMapper modelMapper;

    public TestCase_DTO saveTestcaseData(TestCase_DAO tcData) {
        System.out.println("Saving data into DB");
        TestCase testcase = modelMapper.map(tcData, TestCase.class);
        Importance importance = importanceService.findByName(tcData.getImportance());
        testcase.setImportance(importance);
        testcase = repo.save(testcase);

        TestCase_DTO response = new TestCase_DTO();
        response.setId(testcase.getId());
        return response;
    }

    public TestCase_DTO deleteTestcaseData(Long id) {
        TestCase_DTO response = new TestCase_DTO();
        repo.deleteById(id);
        response.setId(id);
        return response;
    }

    public TestCase findByName(String testcaseName) {
        return repo.findByName(testcaseName);
    }
}
