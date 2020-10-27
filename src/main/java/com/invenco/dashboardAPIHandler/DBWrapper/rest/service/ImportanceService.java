package com.invenco.dashboardAPIHandler.DBWrapper.rest.service;

import java.util.List;

import com.invenco.dashboardAPIHandler.DBWrapper.rest.model.Importance;
import com.invenco.dashboardAPIHandler.DBWrapper.rest.repository.ImportanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ImportanceService {

	@Autowired
	ImportanceRepository importanceRepository;

	public Importance save(Importance importance) {
		importanceRepository.save(importance);
		return importance;
	}

	public List<Importance> list() {
		return importanceRepository.findAll();
	}

	public Importance findByName(String importance) {
		return importanceRepository.findByName(importance);
	}
}
