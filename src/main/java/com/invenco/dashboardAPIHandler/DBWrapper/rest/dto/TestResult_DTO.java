package com.invenco.dashboardAPIHandler.DBWrapper.rest.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TestResult_DTO {

	@NotNull
	private String release_name;
	
	@NotNull
	private int release_iteration;
	
	@NotNull
	private String testcase_name;
	
	@NotNull
	private String test_module;
	
	@NotNull
	private int test_duration;
	
	@NotNull
	private String test_status;
	
	@NotNull
	private String test_starttime;
	
	@NotNull
	private String test_finishtime;
	
	@NotNull
	private String product;
	
	@NotNull
	private String note;

}
