package com.invenco.dashboardAPIHandler.DBWrapper.rest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "invteststatus")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestStatus {

    @Id
    @Column ( name = "TestStatusName")
    public String testStatus;
}
