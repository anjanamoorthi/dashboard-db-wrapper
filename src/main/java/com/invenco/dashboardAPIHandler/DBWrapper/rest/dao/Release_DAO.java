package com.invenco.dashboardAPIHandler.DBWrapper.rest.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Release_DAO {

    private String name;
    private int iteration;
    private String description;
    private Date start_date;
    private Date end_date;
    private String release_status;
    private String product_name;


}
