package com.invenco.dashboardAPIHandler.DBWrapper.rest.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestResult_DAO {

    private Long id;
    private String testcase_name;
    private String test_module;
    private String user;
    private String result;
    private String test_starttime;
    private String test_finishtime;
    private String product;
    private String note;
    private Integer test_duration;
    private Integer release_iteration;
    private String release;

}
