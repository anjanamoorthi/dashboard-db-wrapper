package com.invenco.dashboardAPIHandler.DBWrapper.rest.service;

import com.invenco.dashboardAPIHandler.DBWrapper.rest.model.TestStatus;
import com.invenco.dashboardAPIHandler.DBWrapper.rest.repository.TestStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TestStatusService {

	@Autowired
	TestStatusRepository testStatusRepository;

	public TestStatus save(TestStatus status) {
		testStatusRepository.save(status);
		return status;
	}

	public List<TestStatus> list() {
		return testStatusRepository.findAll();
	}

	public TestStatus findByName(String status) {
		return testStatusRepository.findByName(status);
	}
}
