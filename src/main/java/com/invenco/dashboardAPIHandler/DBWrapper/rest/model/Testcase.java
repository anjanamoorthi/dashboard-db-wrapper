/**
 * @author Moorthi Rajan
 * @version 0.0.1
 * @since 03/10/2020
 */

package com.invenco.dashboardAPIHandler.DBWrapper.rest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "invtestcase")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Testcase {

    @Id
    @Column( name = "testcasename")
    private String name;

    @Column ( name = "module")
    private String module;

    @Column ( name = "importance")
    private String importance;

    @Column ( name = "testplan")
    private String testplan;

    @Column ( name = "ktf")
    private boolean ktf;

    @Column ( name = "skip")
    private boolean skip;

    @Column ( name = "requirement")
    private String requirement;

    @Column ( name = "expectedduration")
    private int expectedduration;

}
