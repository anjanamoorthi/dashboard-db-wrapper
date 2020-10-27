package com.invenco.dashboardAPIHandler.DBWrapper.rest.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestCase_DAO {

    private String name;
    private String module;
    private String importance;
    private String testplan;
    private Integer ktf;
    private Integer skip;
    private String requirement;
    private Integer expectedDuration;

}
