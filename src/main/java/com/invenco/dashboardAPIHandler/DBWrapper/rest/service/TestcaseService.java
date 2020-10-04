package com.invenco.dashboardAPIHandler.DBWrapper.rest.service;

import com.invenco.dashboardAPIHandler.DBWrapper.rest.model.Testcase;
import com.invenco.dashboardAPIHandler.DBWrapper.rest.repository.TestcaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestcaseService {

    @Autowired
    private TestcaseRepository repo;

    public String saveTestcaseData(Testcase tcData) {
        System.out.println("Saving data into DB");
        repo.save(tcData);
        return "success";
    }

    public String deleteTestcaseData(Testcase tcData) {
        repo.delete(tcData);
        return "success";
    }

}
