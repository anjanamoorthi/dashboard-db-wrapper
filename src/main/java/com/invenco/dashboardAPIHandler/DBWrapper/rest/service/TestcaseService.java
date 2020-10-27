/**
 * @author Moorthi Rajan
 * @version 0.0.1
 * @since 03/10/2020
 */

package com.invenco.dashboardAPIHandler.DBWrapper.rest.service;

import com.invenco.dashboardAPIHandler.DBWrapper.rest.dao.Test_DAO;
import com.invenco.dashboardAPIHandler.DBWrapper.rest.dto.Test_DTO;
import com.invenco.dashboardAPIHandler.DBWrapper.rest.model.Importance;
import com.invenco.dashboardAPIHandler.DBWrapper.rest.model.TestCase;
import com.invenco.dashboardAPIHandler.DBWrapper.rest.repository.TestcaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TestcaseService {

    @Autowired
    private TestcaseRepository repo;

    @Autowired
    private ImportanceService importanceService;

    public Test_DTO saveTestcaseData(Test_DAO tcData) {
        System.out.println("Saving data into DB");
        TestCase testcase = new TestCase();
        testcase.setName(tcData.getName());
        testcase.setModule(tcData.getModule());
        testcase.setTestplan(tcData.getTestplan());
        testcase.setKtf(Boolean.parseBoolean(""+ tcData.getKtf()));
        testcase.setSkip(Boolean.parseBoolean(""+ tcData.getSkip()));
        testcase.setRequirement(tcData.getRequirement());
        testcase.setDuration(tcData.getDuration());
        Importance importance = importanceService.findByName(tcData.getImportance());
        testcase.setImportance(importance);
        testcase = repo.save(testcase);

        Test_DTO response = new Test_DTO();
        response.setUuid(testcase.getUuid());
        return response;
    }

    public String deleteTestcaseData(UUID uuid) {
        repo.deleteById(uuid);
        return uuid.toString();
    }

}
