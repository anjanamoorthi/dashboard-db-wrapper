package com.invenco.dashboardAPIHandler.DBWrapper.rest.dao;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestResult_DAO {

	private String release_name;
	private int release_iteration;
	private String testcase_name;
	private String test_module;
	private int test_duration;
	private String test_status;
	private String test_starttime;
	private String test_finishtime;
	private String product;
	private String note;

}
