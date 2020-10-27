package com.invenco.dashboardAPIHandler.DBWrapper.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TestResult_DTO {


	@NotNull
	private Long id;

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
