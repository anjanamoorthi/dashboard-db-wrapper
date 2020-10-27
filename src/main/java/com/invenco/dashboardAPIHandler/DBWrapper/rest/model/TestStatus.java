package com.invenco.dashboardAPIHandler.DBWrapper.rest.model;

import com.invenco.dashboardAPIHandler.DBWrapper.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table( name = "teststatus")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true) // Required if we are extending BaseClass
public class TestStatus extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "test_status_id")
    private Long id;

    @Column(name = "status", unique = true, length = 20)
    @NotNull
    private String status;

    public TestStatus(String test_status) {
        this.status = test_status;
    }

}
