package com.invenco.dashboardAPIHandler.DBWrapper.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Test_DTO {

    private Long id;
    private String name;
    private String module;
    private String importance;
    private String testplan;
    private Integer ktf;
    private Integer skip;
    private String requirement;
    private Integer duration;

}
