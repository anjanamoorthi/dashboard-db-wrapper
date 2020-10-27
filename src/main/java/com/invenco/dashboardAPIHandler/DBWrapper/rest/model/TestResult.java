package com.invenco.dashboardAPIHandler.DBWrapper.rest.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.invenco.dashboardAPIHandler.DBWrapper.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true) // Required if we are extending BaseClass
public class TestResult extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "release_id", referencedColumnName = "release_id", insertable = true, updatable = true)
	private Releases release;

	@NotNull
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "test_id", referencedColumnName = "test_id", insertable = true, updatable = true)
	private TestCase testcase_name;

	private String test_module;
	
	private int test_duration;

	@NotNull
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "test_status_id", referencedColumnName = "test_status_id", insertable = true, updatable = true)
	private TestStatus test_status;
	
	private String test_starttime;
	private String test_finishtime;
	
	private String product;
	private String note;

}
