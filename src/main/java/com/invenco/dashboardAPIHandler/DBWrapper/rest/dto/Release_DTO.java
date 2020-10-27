package com.invenco.dashboardAPIHandler.DBWrapper.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Release_DTO {

    private Long id;
    private String name;
    private int iteration;
    private String description;
    private Date start_date;
    private Date end_date;
    private String release_status;
    private String product_name;

}
