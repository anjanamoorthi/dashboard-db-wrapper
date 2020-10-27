package com.invenco.dashboardAPIHandler.DBWrapper.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Release_DTO {

    public String releasename;
    public String description;
    public int iteration;
    public String startdate;
    public String enddate;
    public String status;
    public String pname;
    public String user;


}
